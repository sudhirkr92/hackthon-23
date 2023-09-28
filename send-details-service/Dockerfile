# Stage 1: Build Stage
#FROM eclipse-temurin:8-jdk-jammy as BUILD
FROM sudhirkr92/java-soapui-base
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install
#FROM eclipse-temurin:8-jre-jammy
WORKDIR /opt/app
EXPOSE 8088 8085
COPY ./target/*.jar /opt/app/*.jar
# Start SOAP UI MockService and your application
# COPY ./soapui/*.tar.gz /opt
# RUN cd /opt && tar -xvf /opt/*.tar.gz && rm /opt/*.tar.gz
COPY ./soapui/SendDetailsBackend-soapui-project.xml /opt/app/SendDetailsBackend-soapui-project.xml
CMD /opt/SoapUI-5.2.0/bin/mockservicerunner.sh -p 8088 /opt/app/SendDetailsBackend-soapui-project.xml & java -jar /opt/app/*.jar
# ENTRYPOINT ["java", "-jar", "/opt/app/*.jar" ]
