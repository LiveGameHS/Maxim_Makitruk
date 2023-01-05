import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Task1 {
    public static List<Integer> getIntegersFromList(List<Object> l){
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<l.size();i++) /*Перебір всіх елементів масива */
        {
            if( l.get(i) instanceof Integer){/*перевірка чи є об'єкт типом int*/
                list.add((int)l.get(i));/*Якщо так , то записуємо у новий список*/
            }
        
        }
        return list;/*Повертаємо новий, відфільтрований список*/
        }
    public static void main(String[] args){
        System.out.println(getIntegersFromList(Arrays.asList(1,3,4,6,"asdf","asss","123",231)));/*Друкуємо отриманий новий список*/      
    }
}