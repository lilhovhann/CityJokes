FROM registry.gitlab.com/armdev/dockers/openjdk15

COPY target/backend.jar /opt/backend.jar

ENTRYPOINT ["java", "-jar","/opt/backend.jar"]

EXPOSE 8080



