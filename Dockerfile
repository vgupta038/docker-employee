FROM amazoncorretto:8-alpine-jdk
WORKDIR /app
COPY target/*.jar employee.jar
ENTRYPOINT ["java", "-jar", "employee.jar"]