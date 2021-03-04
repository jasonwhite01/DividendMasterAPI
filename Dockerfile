FROM openjdk:13
#RUN /usr/local/bin/mvn package -DskipTests
WORKDIR /
ADD target/DividendMaster-0.0.1-SNAPSHOT.jar //
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/DividendMaster-0.0.1-SNAPSHOT.jar"]


#
# Build stage
#
#FROM maven:3.6.0-jdk-11-slim AS build
#COPY src /src
#COPY pom.xml .
#RUN mvn clean package -DskipTests 

#
# Package stage
#
#FROM openjdk:11-jre-slim
#COPY --from=build /target/DividendMaster-0.0.1-SNAPSHOT.jar /usr/local/lib/DividendMaster.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/usr/local/lib/DividendMaster.jar"]
