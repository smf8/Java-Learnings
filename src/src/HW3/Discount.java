package HW3;

public class Discount {
    private int id;
    private int percentage;
    private Order order;

    public Discount(int id, int percentage) {
        this.id = id;
        this.percentage = percentage;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder(){
        return order;
    }

    public int getPercentage() {
        return percentage;
    }
}
