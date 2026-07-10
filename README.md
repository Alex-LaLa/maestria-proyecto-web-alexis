# Sistema de Inventario para Pequeños Negocios (MVP) -- SaaS

**Autor:** Alexis Emmanuel Fernández González  
**Materia:** Desarrollo de Aplicaciones para Internet - Maestría en Sistemas

## Descripción del Proyecto

Este proyecto consiste en el desarrollo de un Software como Servicio (SaaS) orientado a la administración de inventarios para pequeños negocios, como tiendas de abarrotes, papelerías y comercios locales. El sistema permitirá gestionar productos, categorías, clientes y ventas mediante una aplicación web accesible desde cualquier navegador. Como primera versión (MVP), el objetivo es ofrecer las funcionalidades esenciales para el control del inventario y el registro de operaciones, dejando preparada la arquitectura para incorporar en el futuro características como soporte para múltiples empresas, suscripciones y pagos en línea.

## Objetivo General

Desarrollar una aplicación web basada en una arquitectura cliente-servidor que permita administrar el inventario y las ventas de pequeños negocios, aplicando tecnologías modernas para el desarrollo de aplicaciones empresariales.

## Objetivos Específicos

- Implementar autenticación de usuarios.
- Gestionar productos y categorías mediante operaciones CRUD.
- Administrar clientes.
- Registrar ventas y actualizar automáticamente el inventario.
- Mostrar indicadores básicos mediante un dashboard.
- Contenerizar la aplicación utilizando Docker (objetivo opcional).

## Stack Tecnológico

- **Frontend:** Angular
- **Backend:** Java + Spring Boot
- **Base de Datos:** MySQL
- **IA:** Spring AI + Modelos de Lenguaje
- **Contenedores:** Docker y Docker Compose
- **Control de Versiones:** Git y GitHub

## Alcance del MVP

La primera versión del sistema incluirá:

- Inicio de sesión de usuarios.
- Administración de productos.
- Administración de categorías.
- Administración de clientes.
- Registro de ventas.
- Actualización automática del inventario.
- Dashboard con estadísticas básicas.
- Desarrollo de una API REST para la gestión de productos, clientes y ventas.
- Almacenamiento permanente de la información en una base de datos MySQL.

## Funcionalidades previstas para futuras versiones

La arquitectura del proyecto permitirá incorporar nuevas funcionalidades sin modificar la base del sistema, entre ellas:

- Soporte para múltiples empresas (Multi-Tenant).
- Gestión de sucursales.
- Control de proveedores.
- Compras e ingreso de mercancía.
- Reportes avanzados.
- Exportación a PDF y Excel.
- Notificaciones por correo electrónico.
- Planes de suscripción.
- Integración con pasarelas de pago.
- Asistente inteligente utilizando Spring AI.
