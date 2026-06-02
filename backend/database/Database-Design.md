# Digital Marketplace Platform - Diseño de Base de Datos

## 1. Objetivo

Diseñar la estructura lógica y física de la base de datos que soportará las operaciones principales de la plataforma Digital Marketplace Platform.

## 2. Motor de Base de Datos

Se utilizará PostgreSQL como sistema gestor de base de datos debido a su recistencia, seguridad, escalabilidad y compatibilidad con aplicaciones empresariales.

## 3. Entidades Principales

### 3.1 Tabla: Usuarios

| Campo | Tipo de Dato | Restricción |
|--------------------------------------------------------|
| id_usuario | SERIAL | PRIMARY KEY |
| nombre | VARCHAR(50) | NOT NULL |
| apellido | VARCHAR(50) | NOT NULL |
| correo | VARCHAR(100) | UNIQUE NOT NULL |
| contraseña | VARCHAR(30) | NOT NULL |
| rol | VARCHAR(30) | NOT NULL |
| fecha_registro | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP |

### 3.2 Tabla: Productos

| Campo | Tipo de Dato | Restricción |
|-----------------------------------------------------------|
| id_producto | SERIAL | PRIMARY KEY |
| nombre | VARCHAR(50) | NOT NULL |
| descripcion | TEXT | NOT NULL |
| precio | DECIMAL(7,2) | NOT NULL |
| stock | INT | NOT NULL |
| id_vendedor | INT | FOREIGN KEY |
| fecha_publicacion | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP |

### 3.3 Tabla: Pedidos

| Campo | Tipo de Dato | Restricción |
|------------------------------------------------------|
| id_pedido | SERIAL | PRIMARY KEY |
| id_usuario | INT | FOREIGN KEY |
| fecha_pedido | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP |
| total | DECIMAL(8,2) | NOT NULL |
| estado | VARCHAR(30) | NOT NULL |

### 3.4 Tabla: Detalle_Pedido

| Campo | Tipo de Dato | Restricción |
|-------------------------------------|
| id_detalle | SERIAL | PRIMARY KEY |
| id_pedido | INT | FOREIGN KEY |
| id_producto | INT | FOREIGN KEY |
| cantidad | INT | NOT NULL |
| subtotal | DECIMAL(8,2) | NOT NULL |

## 4. Relaciones

- Un usuario puede realizar varios pedidos.
- Un vendedor puede publicar varios productos.
- Un pedido puede contener múltiples productos.
- La tabla detalle_pedido resuelve la relación entre pedidos y productos.

## 5. Modelo Relacional

usuarios (1) ---- (N) pedidos  
usuarios (1) ---- (N) productos  
pedidos  (1) ---- (N) detalle_pedido  
productos(1) ---- (N) detalle_pedido  

## 6. Conclusión

El diseño garantiza integridad de datos, escalabilidad y una estructura sólida para el desarrollo del sistema.
