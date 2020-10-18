# bankapp
Приложение Spring Boot.
Java 8
БД H-2 (URL: http://localhost:8080/h2-console)
Данное приложение имеет 6 Rest методов:
1."ip:port/createaccount" POST (стандартный localhost:8080)
Принимает в себя сообщение формата JSON.

{
    "numberOfAccount": номер счета,
    "cash": первоначальное количество
}
Пример:
{
    "numberOfAccount": 4321423143222225,
    "cash": 1 
}

{
    "numberOfAccount": 4321423143222226,
    "cash": 4.25 
}

В ответ возращается сообщение либо аккаунт создан, либо такой номер счета уже есть в БД и аккаунт не создается.

2."ip:port/allaccinfo" POST 
На запрос отдает информацию из базы данных обо всех аккаунтах

Пример ответа:

[
    {
        "id": 1,
        "numberOfAccount": 4321423143222225,
        "cash": 104.77
    },
    {
        "id": 2,
        "numberOfAccount": 4321423143222226,
        "cash": 55.05
    }
]

3. "ip:port/accinfo" POST
На запрос возращает конкретный аккаунт.
Принимает сообщение JSON :

{
"accNumber":4321423143222225
}

Ответ идентичный второму методу.

4. "ip:port/deposit" POST
Запрос на пополнения счета. Принимает сообщения JSON. Пример:

{
    "amountOfMoneyToDeposit": 45.33,
    "depositAccNumber": 4321423143222225
}

В ответ выдает информацию о пополнении. Пример ответа:

Вы пополнили свой счет на 45.33. Total sum: 104.77

5. "ip:port/withdrawal" POST
Запрос на снятие средств со счета. Принимает сообщение формата JSON. Пример:

{
    "accNumber": 4321423143222225,
    "withdrawalCash": 30
}

В качестве ответа может прийти сообщении об успешном снятии средств пример:

На вашем счету: 49.58
Операция прошла успешно вы сняли: 30.0
Остаток на счету: 19.58

Либо сообщение что данную операцию выполнить не возможно.

На вашем счету: 19.58
Не хватает средств для операции

6. "ip:port/transfer" POST
Запрос на перевод на другой счет. Принимает сообщение формата JSON. Пример

{
    "accNumber": 4321423143222225 ,
    "transferCash": 25.4,
    "transferAccNumber": 4321423143222226 
}

В ответ может прийти сообщение о успешной операции:

На вашем счету: 69.51
Операция выполнена успешно. Вы перевели: 25.4 на счет 4321423143222226
Остаток на вашем счету: 44.11

Или не ответ с неудачным исходом операции:

На вашем счету: 18.71
Не хватает средств на операцию

Для пополнения/снятия/первода реализована проверка на то существует ли счет. При не существование прийдет соотвественный ответ.

Что можно было сделать еще, но не сделано.
1. Привязать аккаунты к таблице клиентов. Связь на мой взгляд должна быть OnetoMany(человек имеет несколько, счетов).
2. Привязать счета к конкретным валютам. В случае перевода на счета с другой валютой конвертировать их по курсу.
(Для конвертации например использовать еще одну таблицу базы данных и запрашивать нужное отношение валют)
3. Валидация пользователей.
4. Добавить таблицу транзакций, то есть после каждой транзакции удачной или нет, записывался лог операций.
В условии этого не было написано и из-за отсутствия времени у меня это не реализовано.
