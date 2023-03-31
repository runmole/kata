import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите выражение: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        calc(input);                        //вызваем метод calc
        System.out.print(calc(input));      // результат вычислений
    }
    public static String calc(String input) {
        String[] array = input.split(" ");
        int requals = 0;
        String equals = null; // int const = 3 // a + b =
        if (array.length != 3) {
            try {
                throw new IOException();             //исключение
            } catch (IOException e) {                  // ловим исключение
                System.out.println("Неверный формат ввода: произвести вычисления можно только между двумя числами");
                System.exit(0);                    // останавливаем программу
            }
        } else {
            String num1 = array[0];
            String num2 = array[1];
            String num3 = array[2];
            String[] checkList = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            boolean check1 = Arrays.asList(checkList).contains(num1);
            boolean check2 = Arrays.asList(checkList).contains(num3);
            String[] checkList2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            boolean check3 = Arrays.asList(checkList2).contains(num1);
            boolean check4 = Arrays.asList(checkList2).contains(num3);
            if (check1 == check3 || check2 == check4 || check1 != check2) {
                try {
                    throw new IOException();             //исключение
                } catch (IOException e) {                  // ловим исключение
                    System.out.println("Калькулятор работает только c целыми арабскими или римскими числами одновременно - от 1 до 10");
                    System.exit(0);
                }
            }
            else if  (check1 = check2) {
                int n1 = Roman.valueOf(array[0]).toInt();
                int n3 = Roman.valueOf(array[2]).toInt();

                switch (num2) {
                    case "+":
                        requals = n1 + n3;
                        break;
                    case "-":
                        requals = n1 - n3;
                        break;
                    case "*":
                        requals = n1 * n3;
                        break;
                    case "/":
                        requals = n1 / n3;
                        break;
                    default:
                        try {
                            throw new IOException();             //исключение
                        } catch (IOException e) {                  // ловим исключение
                            System.out.println("Некорректная арифметическая операция");
                            System.exit(0);                    // останавливаем программу
                        }
                }
                if (requals < 1) {
                    try {
                        throw new IOException();             //исключение
                    } catch (IOException e) {                  // ловим исключение
                        System.out.println("Результат не может быть меньше 1");
                        System.exit(0);                    // останавливаем программу
                    }
                }
                equals = Roman.values()[requals - 1].toString();
            }

            else {
                int n1 = Integer.parseInt(num1);                    //преобразуем строку в инт
                int n3 = Integer.parseInt(num3);

                switch (num2) {
                    case "+":
                        requals = n1 + n3;
                        break;
                    case "-":
                        requals = n1 - n3;
                        break;
                    case "*":
                        requals = n1 * n3;
                        break;
                    case "/":
                        requals = n1 / n3;
                        break;
                    default:
                        try {
                            throw new IOException();             //исключение
                        } catch (IOException e) {                  // ловим исключение
                            System.out.println("Некорректная арифметическая операция");
                            System.exit(0);                    // останавливаем программу
                        }
                }
                equals = Integer.toString(requals);
            }
        }
        return equals;
    }

    // не осуждайте...
    enum Roman {
        I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10),
        XI(11), XII(12), XIII(13), XIV(14), XV(15), XVI(16), XVII(17), XVIII(18), XIX(19), XX(20),
        XXI(21), XXII(22), XXIII(23), XXIV(24), XXV(25), XXVI(26), XXVII(27), XXVIII(28), XXIX(29), XXX(30),
        XXXI(31), XXXII(32), XXXIII(33), XXXIV(34), XXXV(35), XXXVI(36), XXXVII(37), XXXVIII(38), XXXIX(39), XL(40),
        XLI(41), XLII(42), XLIII(43), XLIV(44), XLV(45), XLVI(46), XLVII(47), XLVIII(48), XLIX(49), L(50),
        LI(51), LII(52), LIII(53), LIV(54), LV(55), LVI(56), LVII(57), LVIII(58), LIX(59), LX(60),
        LXI(61), LXII(62), LXIII(63), LXIV(64), LXV(65), LXVI(66), LXVII(67), LXVIII(68), LXIX(69), LXX(70),
        LXXI(71), LXXII(72), LXXIII(73), LXXIV(74), LXXV(75), LXXVI(76), LXXVII(77), LXXVIII(78), LXXIX(79), LXXX(80),
        LXXXI(81), LXXXII(82), LXXXIII(83), LXXXIV(84), LXXXV(85), LXXXVI(86), LXXXVII(87), LXXXVIII(88), LXXXIX(89), XC(90),
        XCI(91), XCII(92), XCIII(93), XCIV(94), XCV(95), XCVI(96), XCVII(97), XCVIII(98), XCIX(99), C(100);
        private final int value;

        private Roman(int value) {

            this.value = value;
        }

        public int toInt() {
            return value;
        }
    }
}