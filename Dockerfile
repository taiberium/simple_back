FROM java:8-jre
COPY build/libs/example_back-0.0.1-SNAPSHOT.jar /app/example_back-0.0.1-SNAPSHOT.jar
CMD ["java", "-Xmx200m", "-jar", "app/example_back-0.0.1-SNAPSHOT.jar"]
