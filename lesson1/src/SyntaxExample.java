/**
 * Класс с примерами синтаксиса.
 *
 * @author vkhlybov
 */
public class SyntaxExample {

    /*
    Точка входа в приложением.
     */
    public static void main(String[] options) {
        String s = "123" + "456";
        String s1 = "123456";

        var longNumber = 111111111111111L;
        var floatNumber = (float) 2.4;
        var anotherFloatNumber = 2.4f;

        // начало метода
        System.out.println("Васап");

        int[] someArray = new int[]{1, 2, 3, 4};
        for (int element : someArray) {
            System.out.println(element);
        }

        for (int index = 0; index < someArray.length; index += 2) {
            System.out.println(someArray[index]);
        }
        // обрамляем блоком
        if (someArray.length < 2) {
            System.out.println("Длина меньше 2");
        }
    }
}





