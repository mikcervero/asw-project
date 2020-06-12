FROM openjdk:8-jdk 

ADD /build/libs/ricette-seguite.jar ricette-seguite.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx128m", "-Xms128m", "-jar", "ricette-seguite.jar"]
