FROM hirokimatsumoto/alpine-openjdk-11

VOLUME /tmp

EXPOSE 8083

COPY build/libs/*.jar db-service.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/db-service.jar"]