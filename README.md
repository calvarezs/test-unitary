# Mingeso-Grupo1
Proyecto para la asignatura de Métodos y Técnicas de Ingeniería de Software. Grupo N°1

# Caracteristicas de la entrega 2

  - Login completo a la aplicación
  - Funcionamiento total de la plataforma de integración continua
  
## Diagramas 
####  *Diagrama de clases*
![Diagrama de clases](/diagrams/ClassDiagram.jpg)

####  *Diagrama de despliege*
![Diagrama de clases](/diagrams/DeploymentDiagram.jpg)

### Tecnología utilizada

##### Tecnologías del Proyecto
El proyecto requiere de las siguientes tecnologías para funcionar:

* [node.js](http://nodejs.org) - Eventos I/O (backend)
* [spring](https://spring.io/)  - Framework (backend)
* [react](https://reactjs.org/)   - Librería JavaScript para interfaces de usuario (frontend)
* [glot.io](https://www.npmjs.com/package/glot-api) - API wrapper en base npm  

Todo el codigo fuente se encuentra en GitHub, el flujo de trabajo se controla utilizando taiga.io y gitkraken.

##### Tecnologías de la Plataforma de Integración continua
* Jenkins - Controlador Central
* SonarQube - Analizador de Código Estático
* Mantis  - Gestión de tareas y control de incidencias
* Testlink - Control de test unitarios
* Artillery - Control de test de carga
* Docker - Encapsulación de modulos de la plataforma IC

### Instalación

La aplicación requiere [Node.js](https://nodejs.org/) v3+ y [Java](https://www.oracle.com/index.html) v8+ para funcionar. 
Asegurarse que el archivo  */backend/src/main/resources/application.properties* corresponda a la base de datos sobre la cual la aplicación será levantada.

```sh
$ cd backend/
$ mvn package 
$ java -jar target/MINGESO-1.0-SNAPSHOT.jar
```

Para levantar el frontend

```sh
$ cd front-end/src
$ npm install --production
$ npm start
```
