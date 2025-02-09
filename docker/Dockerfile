# Stage 1: Build Environment
FROM gradle:8.12.1-jdk23 AS build-stage
ENV APP_HOME=/usr/src/transacao-api
COPY ./transacao-api ${APP_HOME}
WORKDIR /usr/src/transacao-api
RUN gradle build

# Stage 2: Runtime environment
FROM eclipse-temurin:23-jre-ubi9-minimal AS final-stage
ENV APP_HOME=/usr/src/transacao-api
ENV ARTIFACT_NAME=transacao-api-0.0.1-SNAPSHOT.jar
WORKDIR ${APP_HOME}
COPY --from=build-stage ${APP_HOME}/build/libs/${ARTIFACT_NAME} .
EXPOSE 8080
ENTRYPOINT java -jar ${ARTIFACT_NAME}