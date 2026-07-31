import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MarkdownModule } from 'ngx-markdown';
import { AiService } from '../../services/ai';
import { AuthService } from '../../services/auth';
import { MatChipsModule } from '@angular/material/chips';
import { ViewChild, AfterViewInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatIconModule } from '@angular/material/icon';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { ProductoDialog } from '../../components/producto-dialog/producto-dialog';
import { CategoriaService } from '../../services/categoria';
import { ProductoService } from '../../services/producto';
import { HttpClient } from '@angular/common/http';
import { ConfirmDialog } from '../../components/confirm-dialog/confirm-dialog';
import { BaseChartDirective } from 'ng2-charts';
import { ChartConfiguration } from 'chart.js';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatTableModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatChipsModule,
    MatPaginatorModule,
    MatSortModule,
    MatIconModule,
    MatDialogModule,
    MarkdownModule,
    BaseChartDirective
  ],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})

export class DashboardComponent implements OnInit, AfterViewInit {

  // ==========================
  // Actividad guía
  // ==========================

  mensajes: any[] = [];

  pregunta: string = '';

  respuestaIA: string = '';

  cargando = false;

  // ==========================
  // Proyecto SaaS
  // ==========================

  productos: any[] = [];
  categorias: any[] = [];
  totalProductos = 0;
  totalCategorias = 0;
  productosActivos = 0;
  valorInventario = 0;

  dataSource = new MatTableDataSource<any>();

  columnas: string[] = [
    'id',
    'nombre',
    'categoria',
    'precio',
    'activo',
    'acciones'
  ];
  public barChartData: ChartConfiguration<'bar'>['data'] = {

    labels: [],

    datasets: [

      {

        label: 'Productos',

        data: []

      }

    ]

  };

  public barChartOptions: ChartConfiguration<'bar'>['options'] = {

    responsive: true,

    plugins: {

      legend: {

        display: false

      }

    }

  };
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  @ViewChild(MatSort)
  sort!: MatSort;

  constructor(
    private router: Router,
    private aiService: AiService,
    private productoService: ProductoService,
    private categoriaService: CategoriaService,
    private cdr: ChangeDetectorRef,
    private authService: AuthService,
    private dialog: MatDialog
  ) { }

  ngOnInit(): void {

    // ========= Proyecto =========

    this.cargarProductos();

    this.cargarCategorias();

    this.dataSource.filterPredicate = (data, filter) => {

      const texto = (
        data.nombre +
        ' ' +
        data.categoria?.nombre +
        ' ' +
        data.precio
      ).toLowerCase();

      return texto.includes(filter);

    };

  }
cargarProductos(): void {
  this.productoService
    .obtenerProductos()
    .subscribe(data => {

      this.productos = data;

      this.dataSource.data = data;

      this.totalProductos = data.length;

      this.totalCategorias = new Set(
        data.map((p: any) => p.categoria?.nombre)
      ).size;

      this.productosActivos =
        data.filter((p: any) => p.activo).length;

      this.valorInventario =
        data.reduce(
          (t: number, p: any) => t + p.precio,
          0
        );

      // ======== Gráfica ========

      const conteoCategorias: any = {};

      this.productos.forEach((producto: any) => {

        const nombreCategoria = producto.categoria.nombre;

        conteoCategorias[nombreCategoria] =
          (conteoCategorias[nombreCategoria] || 0) + 1;

      });

      this.barChartData = {

        labels: Object.keys(conteoCategorias),

        datasets: [

          {

            label: 'Productos',

            data: Object.values(conteoCategorias)

          }

        ]

      };

      // Actualiza la vista
      this.cdr.detectChanges();

    });

}
  cargarCategorias(): void {

    this.categoriaService
      .obtenerCategorias()
      .subscribe(data => {

        this.categorias = data;

      });
  }
  ngAfterViewInit(): void {

    this.dataSource.paginator = this.paginator;

    this.dataSource.sort = this.sort;

    this.dataSource.sortingDataAccessor = (item, property) => {

      switch (property) {

        case 'categoria':
          return item.categoria?.nombre;

        default:
          return item[property];

      }

    };

  }

  filtrar(event: Event): void {

    const filtro = (event.target as HTMLInputElement).value;

    this.dataSource.filter = filtro.trim().toLowerCase();

  }

  enviarPregunta(): void {
    if (!this.pregunta.trim()) {
      return;
    }

    this.cargando = true;
    this.respuestaIA = '';

    this.aiService.consultar(this.pregunta)
      .subscribe({

        next: (res) => {

          this.respuestaIA = res.respuesta;
          this.cargando = false;
          this.cdr.detectChanges();

        },

        error: (err) => {

          console.error(err);

          this.respuestaIA =
            'Ocurrió un error al consultar la IA.';

          this.cargando = false;
          this.cdr.detectChanges();

        }

      });

  }
  abrirDialogoProducto(): void {

    const dialogRef = this.dialog.open(ProductoDialog, {

      width: '500px',

      data: {

        producto: {
          nombre: '',
          categoria: null,
          precio: 0,
          activo: true
        },

        categorias: this.categorias

      }

    });

    dialogRef.afterClosed().subscribe(resultado => {

      if (!resultado) {
        return;
      }

      this.productoService
        .crearProducto(resultado)
        .subscribe({

          next: () => {

            this.cargarProductos();

          },

          error: (err) => {

            console.error(err);

            alert("No se pudo guardar el producto.");

          }

        });

    });

  }
  editarProducto(producto: any): void {

    const dialogRef = this.dialog.open(ProductoDialog, {

      width: '500px',

      data: {

        producto: { ...producto },

        categorias: this.categorias

      }

    });

    dialogRef.afterClosed().subscribe(resultado => {

      if (!resultado) {

        return;

      }

      this.productoService
        .actualizarProducto(resultado.id, resultado)
        .subscribe({

          next: () => {

            this.cargarProductos();

          },

          error: (err) => {

            console.error(err);

            alert("No se pudo actualizar el producto.");

          }

        });

    });

  }
  eliminarProducto(producto: any): void {

    const dialogRef = this.dialog.open(ConfirmDialog, {

      width: '400px',

      data: {

        nombre: producto.nombre

      }

    });

    dialogRef.afterClosed().subscribe(confirmado => {

      if (!confirmado) {

        return;

      }

      this.productoService
        .eliminarProducto(producto.id)
        .subscribe({

          next: () => {

            this.cargarProductos();

          },

          error: (err) => {

            console.error(err);

            alert("No se pudo eliminar el producto.");

          }

        });

    });

  }
  logout(): void {

    this.authService.logout();

    this.router.navigate(['/login']);

  }

}