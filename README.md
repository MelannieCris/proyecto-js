# Proyecto JS - Sistema de Gestión de Eventos

## Descripción

Este repositorio contiene una aplicación web para la gestión de eventos, ventas y promociones. Está dividida en dos partes principales:

- **Backend**: Servicio REST construido con Spring Boot (Maven) que expone las APIs para eventos, zonas, precios, compras, usuarios, pagos y promociones.
- **Frontend**: Aplicación cliente construida con React + TypeScript usando Vite. Consume las APIs del backend y provee la interfaz de usuario.

La estructura principal del repositorio es:

- `backend/` — código Java Spring Boot.
- `frontend/` — aplicación React + TypeScript (Vite).

## Requisitos previos

- Java JDK 11 o superior
- Maven (si no usas los wrappers `mvnw` / `mvnw.cmd`)
- Node.js 18+ y npm (o yarn/pnpm)
- Git (opcional)

## Instalación y ejecución

Sigue estos pasos para poner el proyecto en marcha en tu máquina local.

### Backend

1. Abrir una terminal y situarse en la carpeta del backend:

```bash
cd backend
```

2. Ejecutar con el wrapper Maven (Linux/macOS):

```bash
./mvnw spring-boot:run
```

En Windows usa:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternativamente, compilar y ejecutar el JAR:

```bash
./mvnw package
java -jar target/*.jar
```

3. Configuración: las propiedades de Spring Boot están en `backend/src/main/resources/application.properties`. Ajusta la conexión a la base de datos y otras variables según tu entorno.

4. Ejecutar tests (opcional):

```bash
./mvnw test
```

### Frontend

1. Abrir una terminal y situarse en la carpeta del frontend:

```bash
cd frontend
```

2. Instalar dependencias:

```bash
npm install
```

3. Ejecutar en modo desarrollo (Vite):

```bash
npm run dev
```

4. Construir para producción:

```bash
npm run build
npm run preview   # para previsualizar el build localmente
```

5. Variables de entorno: si la aplicación usa ficheros `.env` o variables para la URL del backend (por ejemplo `VITE_API_URL`), colócalas en un archivo `.env` en la carpeta `frontend/` o exporta las variables antes de ejecutar.

## Puesta en marcha conjunta

1. Levanta primero el backend (puerto por defecto 8080) y luego el frontend (Vite normalmente en el puerto 5173). Asegúrate de que `VITE_API_URL` o la configuración equivalente apunte al backend.

2. Accede a la aplicación desde el navegador en la URL que indique Vite (por ejemplo `http://localhost:5173`).

## Desarrollo y pruebas

- Para depurar el backend, utiliza tu IDE (IntelliJ/VS Code) y ejecuta la clase `BackendApplication`.
- Para el frontend, usa las herramientas de desarrollo del navegador y la funcionalidad de hot-reload de Vite.

## Estructura rápida de carpetas

- `backend/src/main/java/.../controller/` — controladores REST.
- `backend/src/main/resources/application.properties` — configuración delbackend.
- `frontend/src/` — código fuente React.

## Contribuciones

Si quieres contribuir:

1. Haz un fork y crea una rama para tu feature/issue.
2. Abre un Pull Request describiendo los cambios.
