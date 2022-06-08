import java.util.ArrayList;
import java.io.*;

public class ReaderAndWriter {
    static File file = new File("Quanlysp.txt");
    public static void writer(ArrayList<ClassProduct> classProducts){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (ClassProduct x:classProducts) {
                bufferedWriter.write(x.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<ClassProduct> Reader(){
        ArrayList<ClassProduct> classProducts = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String list = bufferedReader.readLine();
            while (list != null){
                String arr [] =list.split(",");
                int price = Integer.parseInt(arr[2]);
                int amount = Integer.parseInt(arr[3]);
                classProducts.add(new ClassProduct(arr[0],arr[1],price,amount,arr[4]));
                list= bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.print("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return classProducts;
    }
}
