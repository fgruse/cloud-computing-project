FROM hirokimatsumoto/alpine-openjdk-11

VOLUME /tmp

EXPOSE 8989

COPY build/libs/*.jar data-service.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/data-service.jar"]