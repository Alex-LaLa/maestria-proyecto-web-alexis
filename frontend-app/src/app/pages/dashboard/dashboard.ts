import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

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
    MarkdownModule
  ],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class DashboardComponent implements OnInit {

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

  columnas: string[] = [
    'id',
    'nombre',
    'categoria',
    'precio',
    'activo'
  ];

  constructor(
    private router: Router,
    private http: HttpClient,
    private aiService: AiService,
    private cdr: ChangeDetectorRef,
    private authService: AuthService
  ) {}

  ngOnInit(): void {

    // ========= Guía =========

    this.http.get<any[]>('http://localhost:8080/api/v1/mensajes')
      .subscribe(data => {
        this.mensajes = data;
      });


    
    // ========= Proyecto =========

    this.http.get<any[]>('http://localhost:8080/api/productos')
    .subscribe(data => {

      console.log("Productos:", data);

      this.productos = data;

      this.cdr.detectChanges();
    });
      

  }
    

  enviarPregunta(): void {

  if (!this.pregunta.trim()) {
    return;
  }

  console.time("TIEMPO_TOTAL_IA");

  console.log("1. ENVIANDO PREGUNTA:", this.pregunta);

  this.cargando = true;
  this.respuestaIA = '';

  console.log("2. cargando =", this.cargando);


  this.aiService.consultar(this.pregunta)
    .subscribe({

      next: (res) => {

        console.timeEnd("TIEMPO_TOTAL_IA");

        console.log("3. ENTRÓ AL NEXT");

        console.log("4. Respuesta completa:", res);

        console.log(
          "5. Tamaño respuesta:",
          res.respuesta?.length
        );


        this.respuestaIA = res.respuesta;

        console.log(
          "6. respuestaIA asignada:",
          this.respuestaIA
        );


        this.cargando = false;

        console.log(
          "7. cargando cambiado:",
          this.cargando
        );


        this.cdr.detectChanges();

        console.log(
          "8. detectChanges ejecutado"
        );


        setTimeout(() => {

          console.log(
            "9. Timeout después del render"
          );

          console.log(
            "10. Valor en pantalla debería ser:",
            this.respuestaIA
          );

        }, 0);

      },


      error: (err) => {

        console.error("ERROR IA:", err);

        this.respuestaIA =
          "Ocurrió un error al consultar la IA.";

        this.cargando = false;

        this.cdr.detectChanges();

      }

    });

}
    

    logout(): void {

      this.authService.logout();

      this.router.navigate(['/login']);

  }

}