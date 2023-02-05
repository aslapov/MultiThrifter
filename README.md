# MultiThrifter
## Android-Приложение для учета расходов и доходов в разной валюте

## Экраны:
- **Меню учета расходов**
    - **Экран отображения списка расходов** - _выбор месяца, выбор счета(ов), отображение списка расходов, редактирование расхода_
    - **Экран редактирования расхода** - _редактирование расхода, удаление расхода_
    - **Экран категорий расходов** - _отображение категорий_
        - **Экран добавления категории** - _добавление категории_
        - **Экран редактирования категории** - _редактирование категории, удаление категории_
    - **Экран отчета месячных расходов** - _выбор месяца, выбор счета(ов), круговая диаграмма сумм категорий расходов, список сумм категорий расходов_
        - **Экран месячных расходов определенной категории** - _фильтр по дате или по сумме, редактирование расхода_
    - **Экран выбора счета(ов) для отчета расходов** - _выбор валюты для отчета, выбор счета(ов)_
- **Меню учета доходов** - _Все те же экраны, что для расходов, только для доходов_
- **Меню имеющихся счетов и переводов**
    - **Экран счетов** - _список счетов, их сумм и общего баланса в валютах и в определенной валюте; добавление и редактирование счета_
    - **Экран добавления счета**
    - **Экран редактирования счета** - _редактирование счета, удаление счета_
    - **Экран переводов** - _Выбор счета снятия и счета получения_
    - **Диалог конвертации валют при переводе**


## Стек технологий:
- Kotlin
- UI на Jetpack Compose
- Single Activity Application паттерн
- Clean Architecture подход с использованием MVVM (ViewModel + StateFlow)
- Dagger2 и многомодульность
- Kotlin Coroutines
- Retrofit + Kotlin Serialization - сеть
- Room - БД
- ...

_Для сетевого взаимодействия используется открытое API курсов валют - <code>[currencybeacon](https://currencybeacon.com/)</code>_

