
public class Task2 {
    public static String first_non_repeting_letter(String str){
        int j=0;
        String letter;
        loop2:for(int i=0;i<str.length();i=i+1) {
            loop1:for(int t=0;t<str.length();t=t+1){
                if(str.substring(i, i+1).toUpperCase().equals(str.substring(t, t+1).toUpperCase()) && t!=i){
                break loop1;     
                }
                if(t==str.length()-1){
                    break loop2;
                }
            } 
        j=i+1;
        }
        if(j==str.length()){
        letter="None";           
        }else {
        letter=str.substring(j,j+1);
        }
        return letter;
    }


    public static void main(String[] args) throws Exception {
        String string="sTRess";
        System.out.println(first_non_repeting_letter(string));
    }
}
