FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=build/libs/GiphyProject-1.0-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} giphyproject.jar
ENTRYPOINT ["java", "-jar", "giphyproject.jar"]