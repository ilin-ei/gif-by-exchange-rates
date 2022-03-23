FROM openjdk:11
COPY ./build/libs/gif-by-exchange-rates-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gif-by-exchange-rates-0.0.1-SNAPSHOT.jar"]