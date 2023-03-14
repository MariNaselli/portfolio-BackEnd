# Imagen base de Java
FROM openjdk:17-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copia el archivo .jar generado por Maven en la carpeta /app
COPY target/miportfolio-0.0.1-SNAPSHOT.jar /app

# Exponer el puerto en el que se ejecuta tu aplicación
EXPOSE 9090

# Comando para ejecutar la aplicación al iniciar el contenedor
CMD ["java", "-jar", "miportfolio-0.0.1-SNAPSHOT.jar"]