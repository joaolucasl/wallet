FROM openjdk:11.0.7-jre-slim

ENV APPLICATION_USER ktor

RUN useradd -ms /bin/sh $APPLICATION_USER

RUN mkdir /app

RUN chown -R $APPLICATION_USER /app

USER $APPLICATION_USER

COPY ./build/libs/app.jar /app/app.jar

WORKDIR /app

CMD ["java", "-server", "-jar", "app.jar"]