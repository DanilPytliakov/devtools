# Quick Start:

## Как запускать Gradle-задачи из IDE
1) Откройте View → Tool Windows → Gradle.
2) В дереве задач выберите Tasks → application → run, Tasks → build → build или Tasks → verification → test, запускай двойным кликом.
## Альтернативный способ
Даблкликом Ctrl + Ctrl открываем меню (Run Anything) и вводим gradle run или gradle test — IDEA выполнит команду без терминала.

## Таблица переменных/полей класса MenteeProgress:
| Имя перменной       | Тип    | Описание   |
|---------------------|--------|----------------------|
| menteeName          | String | Имя студента         |
| sprintNumber        | int    | Номер спринта        |
| plannedHoursPerWeek | int    | Запланированные часы |

## Зачем нужен пакет ru.mentee.power. ?
Вышеупомянутый пакет, как и всех пакеты в Java: являются механизмом организации классов, интерфейсов и других типов в функциональные группы (папки),
необходимым для предотвращения конфликтов имен, управления областью видимости (контроля доступа), структурирования кода, а также для удобства поиска и использования библиотек.

## Принцип работы метода readyForSprint() 
Это метод без аргументов возвращает тип boolean: либо true, либо false. Это ответ на вопрос «готов ли студент к спринту?». 
Внутри return plannedHoursPerWeek >= 3; сравнивает запланированные часы с порогом 3.

## Правило веток feature/DVT-X
В Dev Tools оставляем master чистым, работу ведём в ветке feature/DVT-<номер>; это упрощает проверку и дальнейший PR. Подход соответствует lightweight Git Flow.
## Git локальный цикл
Локальный репозиторий (Local Repository): Это место на вашем компьютере, где хранится вся история ваших коммитов (снимков состояния проекта). Команда git commit создает новый коммит, который фиксирует все изменения, находящиеся в индексе, и добавляет его в историю локального репозитория.

## Перед push: git status clean
1) Локальная диагностика перед правками: всегда смотрите git status и вкладку Commit в IDE — картинка должна совпадать. Это предотвращает случайные коммиты.
2) Малый санитарный коммит: изолируйте «чистку» от функциональных изменений. История будет понятнее, откаты — безопаснее.
3) Поддержка .gitignore как живого документа: добавляйте новые паттерны, когда появляется новый инструмент (например, новый репорт‑каталог).
4) Инвариант «status clean перед push»: фиксируем в Runbook и следуем ему. Это критерий допуска к ревью.
5) Симметрия UI/CLI: проверяйте, что Commit Tool Window и git status показывают одно и то же — иначе ищем причину рассинхрона.

## Кодстайл-гайд проекта devtools

Проект следует правилам Google Java Style Guide с адаптацией.
Автоматическая проверка: ./gradlew checkstyleMain

### 1. Именование методов: camelCase

До:    public void add_student(Student s) { }
После: public void addStudent(Student student) { }

Почему: Java Convention требует camelCase для методов.
Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

### 2. Пробелы после if/for/while

До:    if(condition) {
После: if (condition) {

Почему: улучшает читаемость, отделяет ключевое слово от выражения.
Источник: Oracle Code Conventions — Whitespace

### 3. Длина строки: максимум 120 символов

До:    public List getStudentsFromSpecificCityWithVeryLongName...
После: public List getStudentsByCity(String city) {

Почему: длинные строки затрудняют чтение в редакторе и при code review.
Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

### 4. Порядок импортов

До:    import java.util.List; import java.util.ArrayList; import java.io.File;
После: import java.io.File; import java.util.ArrayList; import java.util.List;

Почему: алфавитный порядок упрощает поиск импортов.
Источник: IntelliJ IDEA → Code → Optimize Imports

### 5. Фигурные скобки для if

До:    if (condition) doSomething();
После: if (condition) { doSomething(); }

Почему: скобки обязательны даже для однострочных блоков.
Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used

## Результаты само-ревью DVT-9

### Найденные проблемы

#### 1. Отсутствие CI badge в README
**Файл:** README.md (начало файла)
**Проблема:** Нет бейджа статуса сборки GitHub Actions
**Почему важно:** CI badge показывает статус проекта сразу при открытии README —
это стандарт для open-source проектов и упрощает мониторинг состояния сборки.
**Исправление:** Добавить бейдж в начало README:

![CI](https://github.com/DanilPytliakov/devtools/actions/workflows/ci.yml/badge.svg)


#### 2. Забыт отладочный вывод
**Файл:** src\main\java\ru\mentee\power\devtools\student\StudentList.java (строка 16)
**Проблема:** Оставлен `System.out.println("Debug: student was added")`
**Почему важно:** Отладочный вывод замусоривает логи production-приложения и создаёт впечатление небрежности.
**Исправление:** Удалить строку или заменить на logger (если логирование настроено).

#### 3. Закомментированный код
**Файл:** src\main\java\ru\mentee\power\devtools\student\StudentList.java (строки 21-27)
**Проблема:** Закомментированы 5 строк старой реализации метода
**Почему важно:** Закомментированный код создаёт путаницу: непонятно зачем он сохранён и актуален ли.
Если нужна история изменений — она в Git.
**Исправление:** Удалить закомментированный код. Если нужна старая версия — посмотреть в Git History.