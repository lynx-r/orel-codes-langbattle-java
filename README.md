## Как запускать

1. Установить Java SE 10+
2. Запустить `./gradlew clean build bootRun` или `gradle clean build`, а затем `java -jar build/libs/langbattle-0.0.1-SNAPSHOT.jar`

Если через gradlew не получится, тогда установить [gradle](https://gradle.org/install/)

3. Запросы надо выполнять по адресу `http://localhost:8080/`

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
    "say": "Java is the best",
    "first_name": "Rand Name jin5fSb7nDOsZC+tz0NWFQ==",
    "last_name": "Rand Last Name YwPOGEpBQY8g8zCvZ9dg+A==",
    "current_time": "2018-11-18 08:49:47 +0300"
}

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

Java 10+, Spring Boot 2
