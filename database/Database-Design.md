# Digital Marketplace Platform - Diseño de Base de Datos

## 1. Objetivo

Definir la estructura de la base de datos para soportar las operaciones principales del sistema Digital Marketplace Platform.

## 2. Entidades Principales

### 2.1 Usuarios

| Campo | Tipo de Dato | Restricción |
|-------------------------------------|
| id_usuario | SERIAL | PRIMARY KEY |
| nombre | VARCHAR(60) | NOT NULL |
| correo | VARCHAR(80) | UNIQUE |
| contraseña | VARCHAR(20) | NOT NULL |
| rol | VARCHAR(30) | NOT NULL |

### 2.2 Productos

| Campo | Tipo de Dato | Restricción |
|------------------------------------|
| id_producto | SERIAL | PRIMARY KEY |
| nombre | VARCHAR(100) | NOT NULL |
| descripcion | TEXT | NOT NULL |
| precio | DECIMAL(7,2) | NOT NULL |
| stock | INT | NOT NULL |

### 2.3 Pedidos

| Campo | Tipo de Dato | Restricción |
|------------------------------------|
| id_pedido | SERIAL | PRIMARY KEY |
| id_usuario | INT | FOREIGN KEY |
| fecha | TIMESTAMP | NOT NULL |
| total | DECIMAL(8,2) | NOT NULL |

## 3. Relaciones

- Un usuario puede realizar varios pedidos.
- Un pedido puede incluir varios productos.
- Un vendedor puede publicar múltiples productos.

## 4. Motor de Base de Datos

Se utilizará PostgreSQL por su recistencia, escalabilidad y compatibilidad con aplicaciones empresariales.

## 5. Conclusión

El diseño propuesto permite almacenar y gestionar eficientemente la información crítica del sistema.
