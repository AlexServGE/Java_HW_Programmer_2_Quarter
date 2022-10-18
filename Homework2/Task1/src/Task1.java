import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class Task1 {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    public static void main(String[] args) throws IOException {
        Task1 tk = new Task1();
        Logger log = Logger.getLogger(Task1.class.getName());
        String query = "select * from students";
        String[] name = {"Name", "Surname", "Age"};
        String[] value = {"Ivan", "Ivanov", "33"};
        log.info(tk.updateQueryByArrays(query, name, value));
        log.info(tk.updateQueryByJson(query));

    }

    public static String updateQueryByArrays(String q, String[] paramName, String[] paramValue) {
        StringBuilder queryToAdd = new StringBuilder();
        queryToAdd.append(q);
        queryToAdd.append(" WHERE ");
        int i = 0;
        for (String item : paramName) {
            queryToAdd.append(String.format("%s = %s", item, paramValue[i++]));
            queryToAdd = i != paramName.length ? queryToAdd.append(" AND ") : queryToAdd.append("");
        }
        return queryToAdd.toString();
    }

    public static String updateQueryByJson(String q) throws IOException {
        FileReader fr = new FileReader("query.json");
        BufferedReader bfr = new BufferedReader(fr);
        String rawContent = bfr.readLine();
        rawContent = rawContent.replace("{", "");
        rawContent = rawContent.replace("}", "");
        String[] wipContent = rawContent.split(",");
        String[] name = new String[3];
        String[] value = new String[3];
        int i = 0;
        for (String item : wipContent) {
            String[] nameValue = item.split(":");
            name[i] = nameValue[0];
            value[i++] = nameValue[1];
        }
        String request = updateQueryByArrays(q,name,value);
        fr.close();
        return request;
    }
}