# Проект по автоматизации тестирования мобильного приложения.
Тесты реализованы для приложения Ticketer. 

> Мобильный контролер. Приложение - это альтернатива установке валидаторов и турникетов: сотрудники скачивают на свой смартфон приложение и работают через него.

## Содержание:

* <a href="#tools">Описание</a>
* <a href="#cases">Реализованные тесты</a>
* <a href="#console">Запуск тестов</a>
* <a href="#allure">Отчеты в Allure</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
* <a href="#telegram">Уведомления в Telegram с использованием бота</a>
*  <a href="#browserstack">Пример прогона теста в Browserstack</a>

<a id="tools"></a>
## Описание

Шаблон проектирования - Page Object.
Предусмотрены разные конфигурационные файлы в зависимости от типа запуска: локально, удаленно.
Использование библиотеки Owner.
Для написания автоматизированных тестов используются фреймворк Appium в дополнении к Selenide.
Для запуска тестов на удаленных устройствах используется Browserstack.

### Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/intellij-original.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/java-original.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/github-original.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/junit-original.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/gradle-original.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.png" width="50" height="50" alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.png" width="50" height="50" alt="Selenoid"/></a>
<a href="https://rest-assured.io/"><img src="images/logo/RestAssured.png" width="50" height="50" alt="RestAssured"/></a>
<a href="https://www.browserstack.com/"><img src="images/logo/browserstack-original.svg" width="50" height="50" alt="Browserstack"/></a>
<a href="https://appium.io/"><img src="images/logo/Appium.png" width="50" height="50" alt="Appium"/></a>
<a href="https://developer.android.com/studio"><img src="images/logo/AndroidStudio.png" width="50" height="50" alt="Android Studio"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/jenkins-original.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://github.com/allure-framework/"><img src="images/logo/AllureReports.png" width="50" height="50" alt="Allure Report"/></a>
<a href="https://qameta.io/"><img src="images/logo/AllureTestOps.svg" width="50" height="50" alt="Allure TestOps"/></a> 
<a href="https://telegram.org/"><img src="images/logo/Telegram.png" width="50" height="50" alt="Telegram"/></a>
</p>


<a id="cases"></a>

## Реализованные тесты

* Тесты страницы настроек
  * Тестирование сохранение настроек с незаполненным обязательным полем.
  * Тестирование кнопки Проверить обновление.
* Тесты страницы авторизации
  * Тестирование авторизации с неверным логином и паролем
  * Тестирование авторизации с пустыми значениями логина и пароля


<a id="console"></a>

## Запуск тестов

Для запуска локально и удаленно используется следующая команда:

```
./gradlew clean test -DdeviceHost=<diviceHost>
```
**diviceHost** определяет среду запуска тестов. Принимаемые значение: 
* *emulation* - для локального запуска тестов
* *browserstack* - для удаленного запуска на Browserstack

Дополнительные свойства извлекаются из соответствующих файлов .properties.

### Запуск в Jenkins

Для запуска проекта через Jenkins была создана <a target="_blank" href="https://jenkins.autotests.cloud/job/C29-bochkareva_a-ticketer-mobile-tests/">**задача**</a>. Для запуска используете кнопку "Собрать сейчас".
После выполнения сборки, результаты тестов станут доступны в Allure Report и Allure TestOps.
Тесты будут запущены удаленно на Browserstack.

![Jenkins_build](/images/screens/jenkins.jpg)

<a id="allure"></a>

## Отчеты в <a target="_blank" href="https://jenkins.autotests.cloud/job/C29-bochkareva_a-ticketer-mobile-tests/allure/">**Allure**</a>

На главной странице Allure отчета возможно узнать основную информацию о сброке и тенденцию выполнения тестов за все запуски.

![allure](/images/screens/allure.jpg)

На странице Suites отображается список тестов с полной информацией (шаги, артефакты, продолжительность выполнения).

![allure](/images/screens/allure-suites.jpg)

Дополнительно реализованы тестовые артефакты:
* Скриншот
* Page Source
* Видео прохождения теста в Browserstack  
> Пример видео представлен ниже

![allure](/images/screens/allure_attach.jpg)

<a id="testops"></a>

## Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/4499/dashboards">**Allure TestOps**</a>

![allure](/images/screens/allure_testops.jpg)

Написанный код теста импортируются в тест-кейсы проекта.

![allure](/images/screens/allure_testops_testcase.jpg)

<a id="telegram"></a>

## Уведомления в Telegram с использованием бота

После завершения сборки Telegram бот автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

![allure](/images/screens/telegram_bot.jpg)

<a id="browserstack"></a>
## Пример прогона теста в Browserstack

![This is an image](/images/screens/video.gif)
