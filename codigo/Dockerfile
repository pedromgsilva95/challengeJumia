FROM maven:3-jdk-11
COPY . /challenge
WORKDIR /challenge
RUN mvn clean package
COPY sample.db sample.db
ENTRYPOINT ["mvn","spring-boot:run"]