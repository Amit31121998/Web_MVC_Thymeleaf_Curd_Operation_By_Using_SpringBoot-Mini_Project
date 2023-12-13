FROM openjdk:17
EXPOSE 9090
ADD target/spring-boot-mysql.war spring-boot-mysql.war
ENTRYPOINT ["java","-war","/spring-boot-mysql.war"]