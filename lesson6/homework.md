# Домашняя задача 6

На вход поступает xml, в виде строки, содержащая список проектов. По каждому проекту известно уникальное 
название, описание, список менеджеров и подчененых им специалистов. 
Требуется реализовать класс, который преобразует xml такого формата в xml сожержающий информацию по людям, 
в каких проектах они принимали участие, их роль и менеджера при наличие. Имена людей считаем уникальными. 
Преобразования делаем с помощью JAXB.

Пример входных данных:
````xml
<projects>
    <project>
        <title>Проект 1</title>
        <description>Описание 1</description>
        <managers>
            <manager name="Человек 1">
                <specialists>
                    <specialist name="Человек 3"/>
                    <specialist name="Человек 4"/>
                </specialists>
            </manager>
            <manager name="Человек 2">
                <specialists>
                    <specialist name="Человек 5"/>
                    <specialist name="Человек 6"/>
                </specialists>
            </manager>
        </managers>
    </project>
    <project>
        <title>Проект 2</title>
        <description>Описание 2</description>
        <managers>
            <manager name="Человек 3">
                <specialists>
                    <specialist name="Человек 5"/>
                    <specialist name="Человек 6"/>
                </specialists>
            </manager>
            <manager name="Человек 4">
                <specialists>
                    <specialist name="Человек 7"/>
                </specialists>
            </manager>
        </managers>
    </project>
</projects>
````

Пример выходных данных:
````xml
<people>
    <person>
        <name>Человек 1</name>
        <projects>
            <project title="Проект 1">
                <role>Менеджер</role>
                <manager></manager>
            </project>
        </projects>
    </person>
    <person>
        <name>Человек 2</name>
        <projects>
            <project title="Проект 1">
                <role>Менеджер</role>
                <manager></manager>
            </project>
        </projects>
    </person>
    <person>
        <name>Человек 3</name>
        <projects>
            <project title="Проект 1">
                <role>Специалист</role>
                <manager>Человек 1</manager>
            </project>
            <project title="Проект 2">
                <role>Менеджер</role>
                <manager></manager>
            </project>
        </projects>
    </person>
    <person>
        <name>Человек 4</name>
        <projects>
            <project title="Проект 1">
                <role>Специалист</role>
                <manager>Человек 1</manager>
            </project>
            <project title="Проект 2">
                <role>Менеджер</role>
                <manager></manager>
            </project>
        </projects>
    </person>
    <person>
        <name>Человек 5</name>
        <projects>
            <project title="Проект 1">
                <role>Специалист</role>
                <manager>Человек 2</manager>
            </project>
            <project title="Проект 2">
                <role>Специалист</role>
                <manager>Человек 3</manager>
            </project>
        </projects>
    </person>
    <person>
        <name>Человек 6</name>
        <projects>
            <project title="Проект 1">
                <role>Специалист</role>
                <manager>Человек 2</manager>
            </project>
            <project title="Проект 2">
                <role>Специалист</role>
                <manager>Человек 3</manager>
            </project>
        </projects>
    </person>
    <person>
        <name>Человек 7</name>
        <projects>
            <project title="Проект 2">
                <role>Специалист</role>
                <manager>Человек 4</manager>
            </project>
        </projects>
    </person>
</people>
````

---

Не забываем правила и замечания предыдущих домашних заданий. Код должен быть
понятным и иметь javadoc. Все методы класса и общий сценарий должены
быть покрыты тестами.