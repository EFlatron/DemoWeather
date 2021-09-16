FROM maven:3.8.1-jdk-11 AS build

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build /home/app/target/App.jar /home/App.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/App.jar"]

#FROM tomcat:9
#COPY --from=build /home/app/target/App.war /usr/local/tomcat/webapps/ROOT.war
#EXPOSE 8080
#
#ENTRYPOINT ["catalina.sh", "run"]
#
#FROM openjdk:11-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]
#
#FROM adoptopenjdk/openjdk11:alpine-jre
#ARG JAR_FILE=target/*.jar
#WORKDIR /opt/app
#COPY ${JAR_FILE} app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","app.jar"]