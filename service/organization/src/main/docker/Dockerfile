FROM java:alpine
VOLUME /tmp
ADD organization-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-XX:MetaspaceSize=128m", "-XX:MaxMetaspaceSize=128m", "-Xms128m","-Xmx384m","-jar","/app.jar"]

