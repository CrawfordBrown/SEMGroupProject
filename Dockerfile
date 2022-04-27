FROM openjdk:latest
COPY ./target/CourseWork.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "CourseWork.jar", "db:3306", "30000"]