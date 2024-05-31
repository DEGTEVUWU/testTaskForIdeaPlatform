# Тестовое задание для компании Effective Mobile
[![Maintainability](https://api.codeclimate.com/v1/badges/df4c05187ab8814f82a8/maintainability)](https://codeclimate.com/github/DEGTEVUWU/testTaskForEffectiveMobile/maintainability)

## Описание ##

Программа(компонент) для парсинга json-файлов, с информацией по перелётам и нахождения разницы между средней и медианной стоимостью перелёта и для нахождения наименьшего времени в пути.
#### Текст тестового задания указан в конце файла

### Необходимо ###
> [Git installed](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)  
> [Java](https://www.oracle.com/java/technologies/downloads)  
> [Maven](https://maven.apache.org/download.cgi)

### Для установки и содания исполняемого файла ###

```
git clone git@github.com:DEGTEVUWU/testTaskForIdeaPlatform.git
cd testTaskForIdeaPlatform
make restart
```
### Для запуска
``` 
make go
```

Также можно запустить полной командой `java -jar target/testTaskForIdeaPlatform-1.0-SNAPSHOT-jar-with-dependencies.jar ./src/main/resources/tickets.json`, где в используется параметр - путь до нужного файла.   
Вы можете создавать новые файлы известного формата и использовать эту программу на них.   
Рекомендую хранить их по пути `./src/main/resources`.   
В Makefile можно просто изменять название файла.  

### Стек технологий:
**Java**, **Jackson**, **Picocli**, **Lombok**, **Maven**, **Git**

### Текст задания
```
Напишите программу на языке программирования java, которая прочитает файл tickets.json и рассчитает:
- Минимальное время полета между городами Владивосток и Тель-Авив для каждого авиаперевозчика
- Разницу между средней ценой  и медианой для полета между городами Владивосток и Тель-Авив

Программа должна вызываться из командной строки Linux, результаты должны быть представлены в текстовом виде. 
В качестве результата нужно прислать ответы на поставленные вопросы и ссылку на исходный код.
```
[tickets.json](https://disk.yandex.ru/d/oytpde1hp8DBRQ)