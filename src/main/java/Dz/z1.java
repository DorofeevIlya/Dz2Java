//1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
package Dz;
import java.util.HashMap;
import java.util.Map;
public class z1 {
    public static String parserJSON(String strJSON){
        String[] strArray;
        StringBuilder sb = new StringBuilder();
        strJSON = strJSON.trim();
        strJSON = strJSON.substring(1,strJSON.length()-1);
        strJSON = strJSON.replaceAll("\"","'");
        strJSON = strJSON.replaceAll(":","=");
        strArray = strJSON.split(",");
        for (int i = 0; i < strArray.length; i++) {
            if (!strArray[i].contains("null")){
                sb.append(strArray[i].trim());
                if (i < strArray.length-1) {
                    sb.append(" and ");
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String strSQL = "select * from students where ";
        String strJSON = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String parsJSON = parserJSON(strJSON);
        System.out.println(strSQL + parsJSON + ";");
    }
}
