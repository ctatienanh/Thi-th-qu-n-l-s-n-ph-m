import java.util.Comparator;

public class SortGiam implements Comparator<ClassProduct> {
    @Override
    public int compare(ClassProduct o1, ClassProduct o2) {
        if (o1.getPrice()< o2.getPrice()){
            return 1;
        }else return -1;
    }
}
