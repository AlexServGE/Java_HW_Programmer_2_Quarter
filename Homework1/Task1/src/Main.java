//����������� ������� ���������� ����� � � ������� b. a, b � ����� �����.
//
//������ 1: � = 3, b = 2, �����: 9
//������ 2: � = 2, b = -2, �����: 0.25
//������ 3: � = 3, b = 0, �����: 1

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        String[] userInputs = {"������� �����: ", "������� �������: "};
        float userNumber = InputFloat(iScanner, userInputs[0]);
        int userPower = InputInt(iScanner, userInputs[1]);
        System.out.printf("�����: %.2f", SquareNumber(userNumber, userPower));
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