FROM openjdk:8-jdk-alpine
MAINTAINER experto.com
VOLUME /tpm
EXPOSE 8080
#ARG JAR_FILE=build/libs/bookapp-0.0.1-SNAPSHOT.jar
#ADD $(JAR_FILE) bookapp.jar
ADD build/libs/bookapp-0.0.1-SNAPSHOT.jar bookapp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bookapp.jar"]