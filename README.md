Задача:

Написать программу котороая принимает по HTTP Post запрос в JSON и
по полученному JSON'у гененрирует в ответ JSON

Пример Input'а

```javascript
{
 id: 'Rand ID',
 first_name: 'Rand Name',
 last_name: 'Rand Last Name',
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
