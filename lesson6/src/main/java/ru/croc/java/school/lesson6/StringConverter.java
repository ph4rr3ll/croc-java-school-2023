package ru.croc.java.school.lesson6;

/**
 * Преобразует строковые значения.
 */
public class StringConverter {

    /**
     * Конвертирует значение параметра в строку.
     *
     * @param convertable конвертируемое значение
     * @return строка
     */
    public String convert(Convertable convertable) {
//        Class<StringConverter> clazz = StringConverter.class;
        String result = convertable.getValue();

        final UpperCaseAnnotation upperCaseAnnotation = convertable.getClass()
                .getAnnotation(UpperCaseAnnotation.class);
        if (upperCaseAnnotation != null) {
            final int length = upperCaseAnnotation.length();
            if (result.length() <= length) {
                result = result.toUpperCase();
            } else {
                result = result.substring(0, length).toUpperCase()
                        + result.substring(length, result.length());
            }

        }
        return result;
    }
}
