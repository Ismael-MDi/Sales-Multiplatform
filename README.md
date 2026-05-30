# Sistema de Gestión de Ventas Multiplataforma

## Descripción del Proyecto
Este proyecto es un sistema de gestión diseñado para administrar un catálogo de productos y una cartera de clientes. Fue desarrollado utilizando Kotlin Multiplatform (KMP) y Compose Multiplatform, lo que permite que el mismo código fuente de la lógica y la interfaz visual funcione de manera idéntica tanto en dispositivos móviles (Android) como en navegadores web.

## Configuración de la Dirección IP
Para que la aplicación se conecte correctamente a los datos, es estrictamente necesario configurar la dirección IP del servidor o de la red local. 

El archivo que debe modificar se encuentra en la siguiente ruta:
`composeApp/src/commonMain/kotlin/edu/itvo/kmp1/di/AppComponent.kt`

Dentro de ese archivo, busque la variable `baseUrl` y reemplace la IP y el puerto por los que correspondan a su entorno de pruebas o producción:
`private val baseUrl = "http://192.168.1.206:3000"`

## Sincronización del Proyecto
Antes de ejecutar la aplicación por primera vez, es obligatorio sincronizar los archivos de configuración para evitar errores de memoria caché. 
1. Vaya al menú superior en Android Studio.
2. Seleccione la pestaña "File".
3. Haga clic en "Sync Project with Gradle Files" (o presione el icono de sincronización de Gradle).

## Instrucciones de Ejecución 

Todo el proyecto se puede ejecutar directamente desde la interfaz gráfica de Android Studio, utilizando el menú desplegable de configuraciones ubicado en la barra superior, junto al botón de reproducción (Run).

### Ejecución en Android:
1. Abra el Device Manager e inicie su emulador.
2. En el menú de configuraciones de ejecución, seleccione el módulo principal de la aplicación (generalmente "composeApp").
3. Presione el botón verde de "Run".

### Ejecución en Web:
1. En el mismo menú de configuraciones de ejecución, cambie el módulo seleccionado a la tarea web preconfigurada (por ejemplo, "jsBrowserDevelopmentRun").
2. Presione el botón verde de "Run".
3. Android Studio compilará el código y abrirá la aplicación automáticamente en su navegador web predeterminado.
