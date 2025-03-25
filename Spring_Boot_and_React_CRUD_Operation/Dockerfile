FROM openjdk:21
COPY target/sb_with_db.jar /do/app/
WORKDIR /do/app
ENTRYPOINT ["java", "-jar", "sb_with_db.jar"]
