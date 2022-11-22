import java.util.*;
import java.util.logging.Logger;

public class Homework {

    // 1) Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    // 2) Создать множество ноутбуков.
    // 3) Написать мапу, которая будет содержать критерий (или критерии) фильтрации и выведет
    //      ноутбуки, отвечающие фильтру.
    //      Пример: 1 - ОЗУ, 2 - Объем ЖД, 3 - Операционная система, 4 - Цвет
    // 4) Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
    public static void main(String[] args) {
        Homework hw = new Homework();
        Logger log = Logger.getAnonymousLogger();
        Notebook myNotebook = hw.createNotebook("16", "1000", "Windows", "Black");
        log.info(myNotebook.toString());
        List<Notebook> myCollection = hw.initListNotebooks(20);
        System.out.println(myCollection);
        Map<String, String> myFilter = new LinkedHashMap<>();
        myFilter.put("RAM", "16");
        myFilter.put("HDD", "300");
        List<Notebook> filteredCollection = hw.filter(myFilter, myCollection, new LinkedList<>(), new ArrayList<>());
        System.out.println(filteredCollection);
    }

    public Notebook createNotebook(String notebookRAMgb, String notebookHDDgb, String notebookOS, String notebookColor) {
        return new Notebook(notebookRAMgb, notebookHDDgb, notebookOS, notebookColor);
    }

    public List<Notebook> initListNotebooks(Integer numberOfNewNotebooks) {
        List<Notebook> notebookWarehouse = new ArrayList<>(20);
        for (int i = 0; i < numberOfNewNotebooks; i++) {
            Notebook notebook = new Notebook();
            notebookWarehouse.add(notebook);
        }
        return notebookWarehouse;
    }

    public List<Notebook> filter(Map<String, String> criteria, List<Notebook> warehouse, LinkedList<String> keyList, List<Notebook> warehouseFiltered) {
        if (keyList.isEmpty()) {
            keyList.addAll(criteria.keySet());
        }
        String criterionName = keyList.poll();
        String criterionValue = criteria.get(criterionName);
        for (int i = 0; i < warehouse.size(); i++) {
            if ((warehouse.get(i).allParameters.get(criterionName)).equals(criterionValue)) {
                warehouseFiltered.add(warehouse.get(i));
            }
        }
        criteria.remove(criterionName);
        if (criteria.isEmpty()){
            return warehouseFiltered;
        }
        return filter(criteria, warehouseFiltered, keyList, new ArrayList<>());
    }
}
