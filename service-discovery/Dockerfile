FROM hirokimatsumoto/alpine-openjdk-11

VOLUME /tmp

EXPOSE 8761

COPY build/libs/*.jar service-discovery.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/service-discovery.jar"]