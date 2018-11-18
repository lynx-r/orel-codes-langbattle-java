## Как запускать

1. Установить Java SE 10+
2. Запустить
 
```
./gradlew clean build
./build/libs/langbattle-1.0.jar
```

Если через gradlew не получится, тогда установить [gradle](https://gradle.org/install/)

3. Запросы принимаются по адресу `http://localhost:8080/`

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
    "first_name": "Rand Name 8e29f97d26fb9c33ac642fadcf435615",
    "last_name": "Rand Last Name 6303ce184a41418f20f330af67d760f8",
    "say": "Java is the best",
    "current_time": "2018-11-18 14:05:24 +0300"
}
```

Так же есть ветка с бинарниками :) #bin

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
