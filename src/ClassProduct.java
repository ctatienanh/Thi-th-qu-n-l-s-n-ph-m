public class ClassProduct {
    private String id;
    private String name;
    private int price;
    private int amount;
    private String describe;

    public ClassProduct() {
    }

    public ClassProduct(String id, String name, int price, int amount, String describe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.describe = describe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return id+ "," + name +
                "," + price +
                "," + amount +
                "," + describe;
    }
}
