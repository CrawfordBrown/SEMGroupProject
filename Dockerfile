FROM openjdk:latest
COPY ./target/CoursworkGroupWork.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "CoursworkGroupWork.jar", "db:3306", "30000"]