FROM gradle:jdk8 as builder
COPY --chown=gradle:gradle . /home
WORKDIR /home
RUN gradle build --no-daemon

FROM java:8-jre
COPY --from=builder /home/build/libs/example_back-0.0.1-SNAPSHOT.jar /app/example_back-0.0.1-SNAPSHOT.jar
CMD ["java", "-Xmx200m", "-jar", "build/libs/example_back-0.0.1-SNAPSHOT.jar"]
