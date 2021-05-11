FROM registry.gitlab.com/armdev/dockers/plume:8.0.4
MAINTAINER Armen
ENV SERVER_HOME /usr/local/tomee
COPY server.xml ${SERVER_HOME}/conf/server.xml
COPY target/frontend.war ${SERVER_HOME}/webapps/frontend.war
ENTRYPOINT ${SERVER_HOME}/bin/catalina.sh run
EXPOSE 9000
