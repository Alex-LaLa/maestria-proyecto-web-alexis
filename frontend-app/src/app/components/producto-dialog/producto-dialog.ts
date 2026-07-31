import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { MAT_DIALOG_DATA, MatDialogRef, MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';

@Component({
  selector: 'app-producto-dialog',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatDialogModule,
    MatButtonModule,
    MatInputModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatSelectModule
  ],
  templateUrl: './producto-dialog.html',
  styleUrl: './producto-dialog.css'
})
export class ProductoDialog {

  producto: any = {
    nombre: '',
    categoria: null,
    precio: 0,
    activo: true
  };

  categorias: any[] = [];

  constructor(
    public dialogRef: MatDialogRef<ProductoDialog>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {

    if (data) {

      this.producto = { ...data.producto };

      this.categorias = data.categorias;

    }

  }

  guardar() {

    this.dialogRef.close(this.producto);

  }

  cancelar() {

    this.dialogRef.close();

  }

}