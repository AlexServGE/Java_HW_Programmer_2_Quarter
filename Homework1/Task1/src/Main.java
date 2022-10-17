//Реализовать функцию возведения числа а в степень b. a, b – целые числа.
//
//Пример 1: а = 3, b = 2, ответ: 9
//Пример 2: а = 2, b = -2, ответ: 0.25
//Пример 3: а = 3, b = 0, ответ: 1

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        String[] userInputs = {"Введите число: ", "Введите степень: "};
        float userNumber = InputFloat(iScanner, userInputs[0]);
        int userPower = InputInt(iScanner, userInputs[1]);
        System.out.printf("Ответ: %.2f", SquareNumber(userNumber, userPower));
    }

    public static float SquareNumber(float someNumber, int power) {
        if (power < 0) {
            power = -power;
            someNumber = 1 / someNumber;
        }
        if (power == 0) {
            return 1;
        }
        return someNumber * SquareNumber(someNumber, power - 1);
    }

    public static int InputInt(Scanner iScanner, String text) {
        System.out.print(text);
        return iScanner.nextInt();
    }

    public static float InputFloat(Scanner iScanner, String text) {
        System.out.print(text);
        return iScanner.nextFloat();
    }

}