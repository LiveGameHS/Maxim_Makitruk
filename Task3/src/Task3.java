import java.util.*;
public class Task3 {
    public static int DigitalRoot(Integer big_number){
        List<Integer> nums = new ArrayList<>();
        int result_number=big_number;
        do{
        nums.clear();
        while (result_number != 0) {
            nums.add(result_number % 10);
            result_number /= 10;
          }
        result_number=0;
        for(int j=0;j<nums.size();j=j+1){
            result_number=result_number+nums.get(j);
        }   
        }while(result_number>10);
    return result_number;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(DigitalRoot(493193));
    }
}
