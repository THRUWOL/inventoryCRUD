# Инструкция по запуску
Проект использует java 17 и spring boot 3.2.3

1. Для начала клонируйте репозиторий в удобную для вас папку.
2. Если планируется локальный запуск приложения - необходимо создать базу postgreSQL и в `application.properties` поменять следующие переменные:
```txt
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```
### Запуск приложения через терминал/консоль:
   1. Для начала необходимо выполнить команду `mvn compile`
   2. Затем выполнить `mvn package`.
   3. Сформируется папка `target` в папке с проектом и необходимо будет выполнить команду: `java -jar target/warehouse-0.0.1-SNAPSHOT.jar`.
   4. После чего можно выполнить команду:
        * для локального запуска: `mvn spring-boot:run -Plocal`
        * для запуска приложения в Docker: `mvn spring-boot:run -Pdocker`
### Запуск приложения через IntelliJ IDEA:
   1. Во вкладе maven выполнить следующие операции:
        * Reload All Maven Project 
        * Generate Sources And Update Folders For All Projects
        * Download Sources and/or Documentation
    
   2. Затем выбрать необходимый профиль:
        * local - локальный запуск приложения с использованием вашей базы postgresql
        * docker - приложение развернётся в докере и развернёт там свою базу
  3. Выполнить команды в Lifecycle:
        * mvn clean
        * mvn package 
          
Теперь можно запускать приложение. <br> По умолчанию оно работает на порту `8080`.<br>
Swagger по умолчанию работает по адресу - http://localhost:8080/swagger-ui/index.html#/
