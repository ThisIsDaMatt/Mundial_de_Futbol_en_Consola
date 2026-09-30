#  Mundial de Fútbol en Consola

> **Taller N.º 4 — Lógica de Programación**
> **Enfoque:** Arreglos y matrices en Java | Control de versiones con Git y GitHub

##  Descripción del proyecto

Este repositorio contiene una aplicación interactiva desarrollada en **Java** que simula la gestión de un **Mundial de Fútbol**.

El proyecto utiliza **arreglos y matrices** para representar diferentes componentes del torneo, como:

* 🚩 Visualización de banderas mediante matrices.
* 📊 Gestión de una tabla de posiciones.
* 📅 Organización y consulta del calendario de partidos.
* ⌨️ Entrada de datos mediante consola.

El proyecto fue desarrollado como parte del **Taller N.º 4 del curso de Lógica de Programación**, aplicando estructuras de datos y conceptos básicos de programación en Java.

### 🛠️ Requisitos

Para ejecutar correctamente el proyecto se necesita:

* **Java JDK**
* **Visual Studio Code**
* **Extension Pack for Java** para Visual Studio Code
* **Git**, para trabajar con el repositorio y el control de versiones.

---

## 👥 Integrantes del equipo

Juan Pablo
Loren Liseth
Matías Múnera

# 🎯 Metas y fases del trabajo

## 🚩 Paso 1: Matrix 2 Console

En esta primera fase se implementa la **visualización matricial de las banderas** correspondientes a los cuatro países del grupo.

El usuario puede seleccionar entre cuatro factores de escala:

| Escala         | Descripción                      |
| -------------- | -------------------------------- |
| 🟢 **Grande**  | Mayor nivel de detalle           |
| 🔵 **Mediano** | Resolución intermedia            |
| 🟡 **Pequeño** | Baja resolución                  |
| ⚪ **Ícono**    | Miniatura para utilizar en menús |

La representación de las banderas se realiza mediante **matrices**, tomando como referencia el código proporcionado por el profesor.

---

## 📊 Paso 2: Tabla de posiciones

En esta fase se desarrolla una **tabla de posiciones dinámica**, utilizando matrices para almacenar y actualizar las estadísticas de los equipos participantes.

### Equipos

La tabla contiene **48 equipos** creados durante las actividades de clase.

### Estadísticas

Para cada equipo se registran las siguientes variables:

| Abreviatura | Significado         |
| ----------- | ------------------- |
| **PJ**      | Partidos Jugados    |
| **PG**      | Partidos Ganados    |
| **PE**      | Partidos Empatados  |
| **PP**      | Partidos Perdidos   |
| **GF**      | Goles a Favor       |
| **GC**      | Goles en Contra     |
| **DG**      | Diferencia de Goles |
| **TA**      | Tarjetas Amarillas  |
| **TR**      | Tarjetas Rojas      |
| **Pts**     | Puntos Totales      |

La información puede ser **consultada, modificada y actualizada** desde la aplicación.

Además, la tabla cuenta con una **visualización paginada en consola**, facilitando la consulta de los diferentes equipos.

---

## 📅 Paso 3: Fixture de partidos

La tercera fase consiste en la creación del **fixture del Mundial**, utilizando arreglos y matrices para organizar los encuentros.

El usuario puede:

* 🔎 Consultar los partidos de un grupo específico.
* 📅 Consultar los partidos correspondientes a una fecha.
* ⏰ Revisar la hora de un encuentro.
* ⚽ Consultar los equipos que participan en un partido.
* 📋 Visualizar la información almacenada en el calendario.

La entrada de información se realiza mediante teclado utilizando el módulo `ConsoleInput.java`, con el objetivo de estandarizar la lectura de datos desde la consola.

---

# 📁 Estructura del proyecto

```text
Mundial-Futbol/
│
├── src/
│   ├── ConsoleInput.java
│   ├── Banderas.java
│   ├── TablaPosiciones.java
│   └── Fixture.java
│
└── README.md
```

### 📄 Descripción de los archivos

| Archivo                | Función                                                                       |
| ---------------------- | ----------------------------------------------------------------------------- |
| `ConsoleInput.java`    | Módulo encargado de estandarizar la lectura de datos desde la consola.        |
| `Banderas.java`        | Genera y muestra las banderas mediante matrices y diferentes escalas.         |
| `TablaPosiciones.java` | Contiene la matriz utilizada para almacenar y mostrar la tabla de posiciones. |
| `Fixture.java`         | Gestiona el calendario y las consultas de los partidos.                       |
| `README.md`            | Documentación general del proyecto.                                           |

---

# 💻 Tecnologías utilizadas

  **Java**
  **Arreglos**
  **Matrices**
  **Consola**
   **Git**
   **GitHub**
   **Visual Studio Code**
---

# 📚 Objetivo académico

El objetivo principal del proyecto es aplicar los conocimientos adquiridos en **Lógica de Programación**, especialmente el manejo de **arreglos, matrices, ciclos, estructuras de control, métodos y entrada de datos**, mediante la construcción de una aplicación basada en un Mundial de Fútbol.

Además, el proyecto permite practicar el uso de **Git y GitHub** para gestionar los cambios y trabajar colaborativamente en el desarrollo del software.
