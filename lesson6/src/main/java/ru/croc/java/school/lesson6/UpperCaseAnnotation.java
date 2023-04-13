package ru.croc.java.school.lesson6;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * При конвертации через {@link StringConverter}, строка
 * приводится к верхнему регистру.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface UpperCaseAnnotation {

    /**
     * Сколько символова строки приведется к верхнему регистру.
     * @return кол-во симоволов
     */
    int length() default 1;

}
