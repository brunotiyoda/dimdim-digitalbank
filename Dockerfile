FROM openjdk:11
COPY ./build/libs/dimdim-0.0.1-SNAPSHOT.jar /app/dimdim-digitalbank.jar
WORKDIR /src
CMD ["java","-jar","/app/app.jar"]
EXPOSE 8080