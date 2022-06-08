import java.util.Comparator;

public class SortTang implements Comparator<ClassProduct> {

    @Override
    public int compare(ClassProduct o1, ClassProduct o2) {
        if(o1.getPrice() > o1.getPrice()){
            return 1;
        }else return -1;
    }
}
