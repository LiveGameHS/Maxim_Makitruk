import java.util.*;
import java.util.stream.Collectors;

public class Task5 {
    private static String Sort_Names_In_Alphabet(String str) {
        String[] full_names = str.split(";");
        List<String> list = new ArrayList<>();
        Arrays.stream(full_names).forEach(t -> {
            String[] str_2 = t.split(":");
            list.add("(" + str_2[1].toUpperCase() + ", " + str_2[0].toUpperCase() + ")");
        });
        return list.stream().sorted().collect(Collectors.joining(""));
    }



    public static void main(String[] args) throws Exception {
        String s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        System.out.println(Sort_Names_In_Alphabet(s));
    }
}
