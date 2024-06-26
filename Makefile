.DEFAULT_GOAL := build-run

start:
	mvn compile  exec:java -Dexec.mainClass="Main"
#запускает приложение из главного класса

restart:
	mvn clean install
#пересборка проекта + упаковка в jar-файлы

depend:
	   mvn dependency:tree
#показать все зависимости

spring:
	   mvn spring-boot:run
#запустить спринг-бут приложение

test:
	   mvn test

go:
	java -jar target/testTaskForIdeaPlatform-1.0-SNAPSHOT-jar-with-dependencies.jar ./src/main/resources/tickets.json

.PHONY: build