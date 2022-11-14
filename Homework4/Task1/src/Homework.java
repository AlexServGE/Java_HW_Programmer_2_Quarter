import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Homework {

    //Даны два Deque представляющие два целых числа. Цифры хранятся в обратном порядке,
    // и каждый из их узлов содержит одну цифру.
    public static void main(String[] args) {
        Homework hw = new Homework();
        hw.mul(new ArrayDeque<>(Arrays.asList(5, 2)), new ArrayDeque<>(Arrays.asList(4)));
        // result [0,0,1]
        hw.sum(new ArrayDeque<>(Arrays.asList(5, -2)), new ArrayDeque<>(Arrays.asList(5)));
        // result [0,-2]
        System.out.println(hw.normalSum(new ArrayDeque<>(Arrays.asList(5, 9,9)), new ArrayDeque<>(Arrays.asList(5))));
        // result [0,0,0,1]
    }

    // Умножьте два числа и верните произведение в виде связанного списка.
    public Deque<Integer> mul(Deque<Integer> d1, Deque<Integer> d2) {
//        Integer firstNumSize = d1.size();
//        Integer secondNumSize = d1.size();
//        Integer totalIterations = firstNumSize > secondNumSize? firstNumSize:secondNumSize;
//        for
        return new ArrayDeque<>();
    }

    // Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными
    public Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
//        Deque<Integer> result = new ArrayDeque<>();
//        Integer firstNumSize = d1.size();
//        Integer secondNumSize = d2.size();
//        Integer totalIterations = firstNumSize > secondNumSize? firstNumSize:secondNumSize;
//        for (int i = 0; i < totalIterations; i++){
//            Integer sum = d1.pollLast() + d2.pollLast();
//            System.out.println(sum);
//            result.add(sum);
//        }
//        System.out.println(result);
        return new ArrayDeque<>();
    }

    public Deque<Integer> normalSum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new ArrayDeque<>();
        Integer sum = 0;
        while (d1.size() > 0 && d2.size() > 0) {
            sum += d1.pollFirst() + d2.pollFirst();
            sum = tenDigit(sum, result);
        }
        while (d1.size() > 0) {
            sum +=  d1.pollFirst();
            sum = tenDigit(sum, result);
        }
        while (d2.size() > 0) {
            sum += d2.pollFirst();
            sum = tenDigit(sum, result);
        }
        if (sum > 0) result.add(1);
        return result;


    }

    public Integer tenDigit(Integer Digit, Deque<Integer> result) {
        if (Digit - 10 >= 0) {
            result.add(Digit - 10);
            return 1;
        } else {
            result.add(Digit);
            return 0;
        }
    }
}
