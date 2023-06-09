FROM openjdk:17
#COPY --from=build /app/target/verba-proxy-0.0.1.jar /verba-proxy-0.0.1.jar
ADD target/Find-a-pro-0.0.1-SNAPSHOT.jar Find-a-pro-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Find-a-pro-0.0.1-SNAPSHOT.jar"]
