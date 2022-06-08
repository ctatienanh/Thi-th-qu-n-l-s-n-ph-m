import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
   static ArrayList<ClassProduct> classProducts = ReaderAndWriter.Reader();
    static Scanner scanner = new Scanner(System.in);
    private static final String regexChoice = "[0-9]+";
    private static final String regexprice = "[A-Ba-b0-9]+";


    public static String Choice() {
        while (true) {
            String choice = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexChoice);
            Matcher matcher = pattern.matcher(choice);
            if (matcher.matches()) {
                return choice;
            }
            System.out.println("Chỉ Nhập kí tự dạng số ");
        }
    }

    public static String id(){
        while (true){
            String id =scanner.nextLine();
            for (int i = 0; i < classProducts.size() ; i++) {
                if (classProducts.get(i).getId().equals(id)){
                    System.out.println("Đã có id này ");
                    id();
                }
            }
            return id;
        }
    }
}
