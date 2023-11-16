FROM openjdk:17-jdk-alpine
COPY out/artifacts/api_jar/api.jar java-app.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]