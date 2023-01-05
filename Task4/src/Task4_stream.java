import java.util.Arrays;
public class Task4_stream {
    public static int nuber_of_pairs(int[]  arr, int target_number){
        return (int)Arrays.stream(arr).flatMap(x -> Arrays.stream(arr).filter(y -> y + x == target_number )).count() / 2;
    }
    public static void main(String[] args) throws Exception {
        int[] Given_Numbers={1, 3, 6, 2, 2, 0, 4, 5};
        System.out.println(nuber_of_pairs(Given_Numbers ,5));
    }
}
