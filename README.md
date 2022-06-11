# GiphyProject
Приложение для получения gif-изображений в зависимости от разницы курсов валют.

Для запуска приложения необходимо:
1. Выгрузить репозиторий на свой ПК, на котором заранее установлено JRE или JDK;
2. В файле application.properties, который расположен ...\GiphyProject\src\main\resources\application.properties,
заменить значения переменных openexchangerates.app.id и giphy.api.key на свои, которые необходимо получить
с соответствующих сайтов (https://developers.giphy.com/docs/api/#quick-start-guide/ и https://openexchangerates.org/);
3. В папке ...\GiphyProject\build\libs открыть командную строку и запустить в ней команду:
```  
java -jar GiphyProject-1.0-SNAPSHOT.jar
```
4. Для просмотра gif-изображений и выбора сравниваемой с USD валюты необходимо запустить Front-приложение
(https://github.com/RSVarfolomeev/FrontGiphyProject), которое будет взаимодействовать с GiphyProject;
5. End-point, через который идет взаимодействие с Front-приложением:
```
http://localhost:8080/getGifAndCurrency
```

Docker:
---
Для создания образа Docker перейти в корневую папку приложения "GiphyProject", где лежит файл Dockerfile,
открыть командную строку и запустить в ней команду:
```  
docker build -t giphy_project .
```
Запуск контейнера:
```
docker run -d -p 8080:8080 --name=giphyproject giphy_project
```
---
#### Используемый стек технологий:

---

Java 11, Spring Boot, OpenFeign, JUnit, Mockito, Gradle
