import java.util.List;
import java.util.Arrays;
public class Task4_for {
    public static int nuber_of_pairs(List<Integer> list, int target_number){
        int pairs=0;
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j=j+1){
                if(list.get(i)+list.get(j)!=target_number){
                    continue;
                }
                pairs=pairs+1;
            }
        }
        return pairs;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(nuber_of_pairs(Arrays.asList(1,3,6,2,2,0,4,5),5));
    }
}
