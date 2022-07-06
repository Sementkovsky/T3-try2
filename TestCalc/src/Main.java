import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException{


        //Запрашиваем данные у пользователя
        System.out.println("Введите первое число - пробел - знак арифметической операции - пробел - второе" +
                " число. \nИспользуйте римские или арабские цифры. Но для обоих чисел должен использоваться" +
                " один и тот же способ.\n" +
                "Числа должны быть в диапазоне от 1 до 10 включительно. Знак операции: +, -, *, / ");
        Scanner sc = new Scanner(System.in);
        String inputStatement = sc.nextLine();

        String finalAnswer = calc(inputStatement);
        System.out.println(finalAnswer);

    }

    public static String calc(String input) throws IOException{

        //Это массив, перечисляющий все римские цифры, допустимые для ввода (1 - 10)
        String[] romanNumbersList = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        boolean rome1 = false;   //Задаем начальные значения переменных режима римских чисел
        boolean rome2 = false;
        boolean romeMode;
        int op1 = 0;
        int op2 = 0;


        //Проверяем что введено именно ТРИ слова
        String[] words = input.split(" ");
        if (words.length != 3) {
            throw new IOException(); //Выбрасываем исключение, т.к. введено больше или меньше трех слов
        }
        //Проверяем, что второе слово - это один из четырех знаков арифметики
        if (!words[1].equals("+") & !words[1].equals("-") & !words[1].equals("*") & !words[1].equals("/")) {
            throw new IOException(); //Выбрасываем исключение, т.к. второе слово не является одним из четырех знаков
        }

        for (int i = 0; i <= 9; i++) {  //Ищем первое римское число
            if (words[0].equals(romanNumbersList[i])) {
                rome1 = true;
                op1 = i + 1;
            }
            if (words[2].equals(romanNumbersList[i])) {  //Ищем второе римское число
                rome2 = true;
                op2 = i + 1;
            }
        }
        if (rome1 != rome2) {  //Бросаем исключение в случае, если одно число - римское, а другое - нет
            throw new IOException();
        } else {
            romeMode = rome1;  //Определяем значение romeMode. True - значит оба числа римские.
        }
        if (!romeMode) {                                //Проверяем, находятся ли введенные числа в заданном диапазоне
            if (Integer.parseInt(words[0]) < 1 ||
                    Integer.parseInt(words[0]) > 10     //Если это не целые арабские цифры (или вообще не цифры), здесь выбросится исключение
                    || Integer.parseInt(words[2]) < 1
                    || Integer.parseInt(words[2]) > 10) {
                throw new IOException();               //Бросаем исключение, если они вне диапазона
            } else
                {
                op1 = Integer.parseInt(words[0]);      //Получаем два операнда
                op2 = Integer.parseInt(words[2]);
                }
        }

        Math4 obj2 = new Math4();    //Здесь вычисляем результат арифметической операции
        int result = obj2.Calculate(op1, op2, words[1].charAt(0));

        if(!romeMode) {
            return String.valueOf(result); //Возвращаем результат, если цифры арабские

        } else
            {
            ConvertToRoman obj3 = new ConvertToRoman();
            return obj3.Convert(result);  //Если числа - римские, конвертирем и выводим
            }

    }
}
