
import java.util.*;

public class Main {

    // Пусть дан произвольный список целых чисел
    public static void main(String[] args) {
        Main task1 = new Main();
        List<Integer> taskList = new ArrayList<>(List.of(task1.arrayRndIntegers(2)));
        System.out.println(taskList);
        //Метод removeNegativeValue
        List<Integer> taskList1 = new ArrayList<>(taskList);
        task1.removeNegativeValue(taskList1);
        System.out.println(taskList1);
        //Метод getMin
        List<Integer> taskList2 = new ArrayList<>(taskList);
        System.out.println(task1.getMin(taskList2));
        //Метод getMax
        List<Integer> taskList3 = new ArrayList<>(taskList);
        System.out.println(task1.getMax(taskList3));
        //Метод getAverage
        List<Integer> taskList4 = new ArrayList<>(taskList);
        System.out.println(task1.getAverage(taskList4));
    }

    public Integer[] arrayRndIntegers(int size) {
        Integer[] someArray = new Integer[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            int flag = rnd.nextInt(2) == 0 ? -1 : 1;
            someArray[i] = rnd.nextInt(101) * flag;
        }
        return someArray;
    }


    // Нужно удалить из него четные числа
    public List<Integer> removeNegativeValue(List<Integer> list) {
        Iterator<Integer> i = list.iterator();
        while (i.hasNext()) {
            if (i.next() < 0) i.remove();
        }
        return list;
    }

    // Найти минимальное значение
    public Integer getMin(List<Integer> list) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(list);
        return queue.peek();
    }

    // Найти максимальное значение
    public Integer getMax(List<Integer> list) {
//        Collections.max(list);
        list.sort(Comparator.reverseOrder());
        return list.get(0);
    }

    // Найти среднее значение
    public Double getAverage(List<Integer> list) {
        int sum = 0;
        for (int item : list) {
            sum += item;
        }
        return sum / (double) list.size();
    }
}
