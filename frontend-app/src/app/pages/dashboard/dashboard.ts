import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    CommonModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatTableModule
  ],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class DashboardComponent implements OnInit {

  // ==========================
  // Actividad guía
  // ==========================

  mensajes: any[] = [];

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
    private http: HttpClient
  ) {}

  ngOnInit(): void {

    // ========= Guía =========

    this.http.get<any[]>('http://localhost:8080/api/v1/mensajes')
      .subscribe(data => {
        this.mensajes = data;
      });

    // ========= Proyecto =========

    this.http.get<any[]>('http://localhost:8080/productos')
      .subscribe(data => {
        this.productos = data;
      });

  }

  logout(): void {
    this.router.navigate(['/login']);
  }

}