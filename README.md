## Как запускать

1. Установить Java SE 8+
2. Запустить `./gradlew clean build bootRun` или `gradle clean build`, а затем `java -jar build/libs/json2json-0.0.1-SNAPSHOT.jar`

Если через gradlew не получится, тогда установить [gradle](https://gradle.org/install/)

3. Запросы надо выполнять по адресу `http://localhost:8080/json2json`

Пример запроса:

```
{
 "id": "Rand ID",
 "first_name": "Rand Name",
 "last_name": "Rand Last Name"
}
```

Пример ответа:

```
{
    "id": "Rand ID",
    "first_name": "Rand Name\ufffd)\ufffd}&\ufffd\ufffd3\ufffdd/\ufffd\ufffdCV\u0015",
    "last_name": "Rand Last Namec\u0003\ufffd\u0018JAA\ufffd \ufffd0\ufffdg\ufffd`\ufffd",
    "say": "Java is best",
    "current_time": "2018-11-10 10:21:01 +0300"
}
```

## Контест для Orel Codes

Задача:

Написать программу котороая принимает по HTTP Post запрос в JSON и
по полученному JSON'у гененрирует в ответ JSON

Пример Input'а

```javascript
{
 id: 'Rand ID',
 first_name: 'Rand Name',
 last_name: 'Rand Last Name'
}
```

Output:

```javascript
{
 id: 'Input ID'
 first_name: 'first_name + hash_md5(first_name)',
 last_name: 'last Name + hash_md5(last_name)',
 current_time: 'UTC time',
 say: 'Your language is best'
}
```

В ответе должен быть заголовок

Content-Type: application/json

Формат сurrent_time: %F %T %z (2018-11-01 17:35:15 +0300)

## Стек

Java 8+, Spring Boot 2 (WebFlux)
