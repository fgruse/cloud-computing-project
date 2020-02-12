FROM hirokimatsumoto/alpine-openjdk-11

VOLUME /tmp

EXPOSE 8080

COPY build/libs/*.jar config-server.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/config-server.jar"]