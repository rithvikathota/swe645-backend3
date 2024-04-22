# FROM openjdk:19-jdk
# ARG JAR_FILE=target/*.jar
# COPY ./target/SWE642Assgn2-0.0.1-SNAPSHOT.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:latest
CMD ["mvn clean install"]
COPY target/SWE642Assgn2-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java","-jar","/app.jar"]