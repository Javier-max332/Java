# ProyectoFinalPeliculasPOOII - Sistema de Gestión de Películas

## Descripción del Proyecto

`ProyectoFinalPeliculasPOOII` es una aplicación de escritorio desarrollada en Java Swing que permite a los usuarios gestionar de manera eficiente una base de datos de películas y sus géneros asociados. La aplicación está diseñada con una arquitectura modular, siguiendo el patrón de diseño DAO (Data Access Object) para una clara separación entre la lógica de negocio y la persistencia de datos. Utiliza MySQL como sistema de gestión de bases de datos para almacenar toda la información.

Este sistema es ideal para:
* Entusiastas del cine que deseen organizar su colección personal.
* Pequeñas videotecas o negocios de alquiler de películas para gestionar su inventario.
* Cualquier persona que necesite una herramienta sencilla para el manejo de datos de películas y sus categorías.

## Características

* **Gestión Completa de Películas (CRUD):**
    * **Crear:** Añade nuevas películas a la base de datos con su título y año.
    * **Leer:** Visualiza todas las películas existentes o busca películas específicas por su ID.
    * **Actualizar:** Modifica los detalles de las películas existentes.
    * **Eliminar:** Elimina películas de la base de datos.
* **Gestión de Géneros:**
    * Permite crear, leer, actualizar y eliminar géneros.
    * Asigna múltiples géneros a una sola película, estableciendo una relación de muchos a muchos.
* **Relación Película-Género:** Gestiona las asociaciones entre películas y sus géneros correspondientes.
* **Capa de Acceso a Datos (DAO):** Implementación robusta del patrón DAO para una interacción limpia y eficiente con la base de datos.
* **Manejo de Excepciones:** Incluye un manejo de excepciones personalizado (`DAOException`) para gestionar errores relacionados con la base de datos.
* **Generación de Informes:** Genera y visualiza informes de todas las películas disponibles utilizando JasperReports.
 
## Capturas de Pantalla

Aquí puedes ver la ventana principal de la aplicación:
![image](https://github.com/user-attachments/assets/20d1f7bf-e37b-4ae2-a403-e1cd7da8768f)

## Tecnologías Utilizadas

* **Java Development Kit (JDK):** Lenguaje de programación principal.
* **Java Swing:** Para el desarrollo de la interfaz gráfica de usuario (GUI).
* **MySQL Server:** Sistema de gestión de bases de datos relacionales.
* **JDBC (Java Database Connectivity):** API de Java para la conexión y ejecución de consultas a la base de datos MySQL.
* **JasperReports:** Para la generación de informes dinámicos y exportables.
* **Patrón DAO:** Aplicación del patrón Data Access Object para la organización del código de acceso a datos.

## Requisitos del Sistema

Para ejecutar esta aplicación, necesitarás tener instalado lo siguiente:

## Requisitos del Sistema

Para ejecutar esta aplicación, necesitarás tener instalado lo siguiente:

* **Java Development Kit (JDK):** Versión 8 o superior.
* **MySQL Server:** Una instancia de MySQL en ejecución (se recomienda la versión 8.0 o superior, aunque versiones anteriores probablemente funcionen).

## Configuración de la Base de Datos

El sistema espera una base de datos MySQL con el nombre `gestion_peliculas`.

1.  **Crear la Base de Datos:**
    Abre tu cliente MySQL (MySQL Workbench, línea de comandos, etc.) y ejecuta el siguiente script para crear la base de datos y las tablas necesarias:

    ```sql
    -- Creación de la base de datos
    CREATE DATABASE IF NOT EXISTS gestion_peliculas;
    USE gestion_peliculas;

    -- Tabla para Películas
    CREATE TABLE IF NOT EXISTS peliculas (
        idPelicula INT AUTO_INCREMENT PRIMARY KEY,
        titulo VARCHAR(255) NOT NULL,
        anio VARCHAR(4) -- Año de lanzamiento (ej. '2023')
    );

    -- Tabla para Géneros
    CREATE TABLE IF NOT EXISTS genero (
        idGenero INT AUTO_INCREMENT PRIMARY KEY,
        descripcion VARCHAR(100) NOT NULL UNIQUE
    );

    -- Tabla de unión para la relación muchos a muchos entre Películas y Géneros
    CREATE TABLE IF NOT EXISTS generopelicula (
        idGenero INT,
        idPelicula INT,
        PRIMARY KEY (idGenero, idPelicula),
        FOREIGN KEY (idGenero) REFERENCES genero(idGenero) ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (idPelicula) REFERENCES peliculas(idPelicula) ON DELETE CASCADE ON UPDATE CASCADE
    );

    -- Datos de ejemplo (opcional)
    -- INSERT INTO genero (descripcion) VALUES ('Acción'), ('Comedia'), ('Drama'), ('Ciencia Ficción');
    -- INSERT INTO peliculas (titulo, anio) VALUES ('Matrix', '1999'), ('Pulp Fiction', '1994');
    -- INSERT INTO generopelicula (idGenero, idPelicula) VALUES (1, 1), (4, 1), (3, 2);
    ```

2.  **Credenciales de Conexión:**
    La aplicación está configurada para conectarse a MySQL en `localhost:3306` con el usuario `root` y una contraseña vacía (`""`).
    ```java
    // En MySQLConexion/Conectar.java
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static final String URL_BASEDEDATOS = "jdbc:mysql://localhost:3306/gestion_peliculas?useSSL=false";
    ```
    Si tu configuración de MySQL es diferente, deberás modificar estas líneas en el archivo `src/MySQLConexion/Conectar.java` para que coincidan con tus credenciales.

## Instrucciones de Instalación y Ejecución

Sigue estos pasos para poner en marcha la aplicación:

1.  **Clonar el Repositorio:**
    ```bash
    git clone [https://github.com/Javier-max332/Java.git](https://github.com/Javier-max332/Java.git)
    cd Java
    ```
    *(**Nota:** Esta URL apunta directamente al repositorio principal. Si tu proyecto `ProyectoFinalPeliculasPOOII` es un subdirectorio o un proyecto independiente dentro de ese       repositorio `Java`, asegúrate de navegar al subdirectorio correcto después de clonar, o de usar la URL de clonación específica para tu proyecto si lo tienes como un repositorio separado.)*

2.  **Importar el Proyecto en tu IDE (NetBeans/IntelliJ/Eclipse):**
    * Abre tu IDE preferido.
    * Selecciona "Open Project" o "Import Project".
    * Navega hasta la carpeta `ProyectoFinalPeliculasPOOII` que acabas de clonar y ábrela. Tu IDE debería reconocerlo como un proyecto Java.

3.  **Añadir las Dependencias (JARs):**
    Este proyecto requiere los siguientes JARs para su correcto funcionamiento. Deberás añadirlos a las librerías de tu proyecto en el IDE.
    * **MySQL JDBC Driver:** `mysql-connector-java-X.X.X.jar` (donde X.X.X es la versión, ej. 8.0.28). Puedes descargarlo de [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/).
    * **JasperReports Libraries:** Necesitarás los JARs principales de JasperReports. Si usas una herramienta de construcción como Maven o Gradle, estos se gestionan automáticamente. Si no, deberás descargar el paquete de [JasperReports Library](https://community.jaspersoft.com/project/jasperreports-library) y añadir los JARs de la carpeta `lib` y el propio `jasperreports-X.X.X.jar`. Los más comunes son:
        * `jasperreports-X.X.X.jar`
        * `commons-collections4-X.X.jar`
        * `commons-beanutils-X.X.jar`
        * `commons-digester-X.X.jar`
        * `commons-logging-X.X.jar`

4.  **Ejecutar la Aplicación:**
    * Una vez que el proyecto esté configurado y las dependencias añadidas, busca el archivo `ProyectoFinalPeliculasPOOII.java` en el paquete raíz del proyecto.
    * Haz clic derecho sobre este archivo y selecciona "Run File" (o el equivalente en tu IDE).

    La aplicación se iniciará y mostrará la ventana principal.

## Uso de la Aplicación

Una vez que la aplicación esté en funcionamiento:

1.  **Ventana Principal:** La ventana principal (`JFrmVentanaPrincipal`) te permitirá navegar a las diferentes funcionalidades del sistema.
2.  **Gestión de Películas:**
    * Para agregar una nueva película, haz clic en el botón "Nuevo" en la ventana de gestión de películas, introduce el título y el año, y guarda.
    * Para modificar una película, selecciona una de la tabla, edita los campos y haz clic en "Guardar Cambios".
    * Para eliminar, selecciona una película y haz clic en "Eliminar".
    * Para buscar una película por su ID, introduce el ID en el campo correspondiente y presiona "Buscar".
3.  **Gestión de Géneros de Películas:** Dentro de la interfaz de gestión de películas, podrás asignar y desasociar géneros a una película seleccionada.
4.  **Generación de Reportes:** Busca el botón para "Generar Reporte" (probablemente en la `JFrmVentanaPrincipal` o en el diálogo de películas) para obtener un informe de todas las películas en la base de datos.

## Contribución (Opcional)

Si deseas contribuir a este proyecto, por favor, sigue los siguientes pasos:

1.  Haz un "fork" del repositorio.
2.  Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3.  Realiza tus cambios y asegúrate de que el código compile y funcione correctamente.
4.  Realiza "commit" de tus cambios (`git commit -am 'Add new feature'`).
5.  Sube tu rama (`git push origin feature/nueva-caracteristica`).
6.  Abre un "Pull Request" describiendo tus cambios.

## Licencia

Este proyecto está bajo la Licencia MIT. Esto significa que eres libre de usar, copiar, modificar, fusionar, publicar, distribuir, sublicenciar y/o vender copias del software, siempre que incluyas el aviso de derechos de autor y el aviso de licencia.

## Contacto

Si tienes alguna pregunta o sugerencia sobre el proyecto, no dudes en contactarme:

* **Autor:** Javier
* **Correo Electrónico:** [mt8966902@gmail.com]
