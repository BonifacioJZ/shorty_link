FROM tomcat:10-jdk17-openjdk-bullseye
COPY ./build/libs/shorty_link-0.0.1-SNAPSHOT.war /usr/tomcat/webapps/shorty_link.war

EXPOSE 8080
CMD chmod +x /usr/local/tomcat/bin/catalina.sh
CMD ["catalina.sh", "run"]