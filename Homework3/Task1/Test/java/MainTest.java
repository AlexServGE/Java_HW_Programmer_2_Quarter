import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class MainTest {
    Main tk = new Main();
    List<Integer> initialList;

    @Test
    void removeNegativeValueText() {
        initialList = new ArrayList<>(List.of(-1, -2, 3, 4));
        Assertions.assertEquals(List.of(3, 4), tk.removeNegativeValue(initialList));
    }

    @Test
    void getMinText() {
        initialList = new ArrayList<>(List.of(-1, -2, 3, 4));
        Assertions.assertEquals(-2, tk.getMin(initialList));
    }

    @Test
    void getMaxText() {
        initialList = new ArrayList<>(List.of(-1, -2, 3, 4));
        Assertions.assertEquals(4, tk.getMax(initialList));
    }

    @Test
    void getAverageText() {
        initialList = new ArrayList<>(List.of(3, 4));
        Assertions.assertEquals(3.5, tk.getAverage(initialList));
    }
}