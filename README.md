# 🗄️ ConexionOracleMaven — Consulta de Empleados (Filtrado JDBC)

Proyecto Java con Maven que establece una conexión a Oracle Database para realizar consultas específicas sobre la tabla `empleado`, filtrando registros mediante lógica SQL (IDs impares) y utilizando configuración externalizada.

## 📋 Descripción

Esta aplicación (Ejercicio 3) demuestra cómo interactuar con una base de datos Oracle mediante JDBC para recuperar información. El enfoque principal es la ejecución de una consulta `SELECT` con un filtro matemático para listar empleados cuyos identificadores no son pares, aplicando buenas prácticas de cierre de recursos y seguridad.

## 🎯 Funcionalidades del Menú

Al ejecutarse, el programa realiza las siguientes acciones automáticas:
* **Conexión Automática**: Establece el enlace con Oracle usando las credenciales de `db.properties`.
* **Filtrado de Datos**: Ejecuta la sentencia SQL `SELECT * FROM empleado WHERE NOT MOD(id,2)=0`.
* **Procesamiento de Resultados**: Recorre el `ResultSet` para extraer `id`, `nombre` y `salario`.
* **Visualización**: Muestra por consola los datos de los empleados que cumplen la condición.

## 🏗️ Estructura del Proyecto

```text
Ejercicio3 [ConexionOracleMaven]/
│
├── 📁 src/
│   └── 📁 main/
│       ├── 📁 java/
│       │   └── 📁 org/example/
│       │       ├── ☕ DBConfig.java        # Carga credenciales (URL, User, Pass)
│       │       └── ☕ Main.java            # Lógica de consulta y filtrado
│       └── 📁 resources/
│           └── 📄 db.properties           # Archivo de configuración externa
│
├── 📁 target/                             # Binarios generados por Maven
├── 🚫 .gitignore                          # Exclusión de archivos sensibles
└── 📄 pom.xml                             # Dependencias y configuración Maven
```

## 📄 Formato del Archivo de Entrada

El archivo `db.properties` debe ubicarse en `src/main/resources/` con el siguiente formato:

```properties
db.url=jdbc:oracle:thin:@localhost:1521:xe
db.user=TU_USUARIO
db.password=TU_CONTRASEÑA
```

## 🚀 Compilación y Ejecución

### Requisitos Previos
* **Java JDK 17 o superior** (Optimizado para JDK 25).
* **Maven 3.8+**.
* **Oracle JDBC Driver** (`ojdbc11`).

### Comandos de Terminal
```bash
# Limpiar y compilar el proyecto
mvn clean compile

# Ejecutar la aplicación
mvn exec:java -Dexec.mainClass="org.example.Main"
```

## 🔧 Características Técnicas Implementadas

* **Gestión Segura de Recursos**: Uso de `try-with-resources` para asegurar el cierre de `Connection` y `Statement`.
* **Configuración Desacoplada**: El código fuente no contiene credenciales (evita hardcoding).
* **Lógica SQL en Servidor**: Uso de la función `MOD` para optimizar la carga de datos desde la base de datos.
* **Manejo de Excepciones**: Captura de `SQLException` con mensajes descriptivos en consola.

## 🎮 Ejemplo de Uso Visual

**Estado de la tabla en la DB:**
| ID | NOMBRE        | SALARIO |
|----|---------------|---------|
|  1 | Judith Olmedo | 3500.00 |
|  2 | Juan Pérez    | 2800.00 |
|  3 | Maria García  | 3100.00 |

**Salida en Consola:**
```bash
Conexión establecida con Oracle.
ID: 1, Nombre: Judith Olmedo, Salario: 3500.0
ID: 3, Nombre: Maria García, Salario: 3100.0
```

---
**Autor:** Judith Olmedo Andrés  
*Ejercicio 3 - Desarrollo de Aplicaciones con Java y Oracle.*
```