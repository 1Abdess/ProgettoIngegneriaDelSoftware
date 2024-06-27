# Sto usando JAVA 22 (più veloce a compilare), uso la jdk più famosa
FROM openjdk:22-jdk-slim

# Imposta il direttorio di lavoro
WORKDIR /app

# Copia il file .jar generato nella directory di lavoro
COPY ./BackEndProgetto-0.0.1-SNAPSHOT.jar app.jar

# espongo la porta di utilizzo
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]

