# Usamos Java 17 para tu Mac M1
FROM eclipse-temurin:17-jdk

# Directorio de trabajo
WORKDIR /app

# Copiamos el archivo que acabas de generar
# Usamos el nombre exacto que aparece en tu captura
COPY target/puenteUsuarios-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto de Spring Boot
EXPOSE 8082

# Arrancamos la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]