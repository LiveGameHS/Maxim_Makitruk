
public class App {
    public static void main(String[] args) throws Exception {
        Actions test = new Actions();
        test.LoginToMainPage();
        test.Add_New_Record();
        test.Add_New_Currency();
        if(test.check_if_changes_are_visible()){
            test.removeRow();
        }
    }
}
