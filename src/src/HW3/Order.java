package HW3;

import java.util.HashMap;
import java.util.Map;

public class Order {
    int id;
    Customer customer;
    Discount orderDiscount;
    enum Status{
        PENDING,SUBMITTED
    }
    Status status;
    HashMap<Good,Integer> orderList = new HashMap<>();

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        status = Status.PENDING;
        orderDiscount = new Discount(0, 0);
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status s){
        status = s;
    }

    public void addItem(Good g, int amount){
        if (orderList.containsKey(g)){
            orderList.put(g, orderList.get(g) + amount);
        }else{
            orderList.put(g, amount);
        }
    }
    public void removeWholeItem(Good g){
        orderList.remove(g);
    }
    public void removeItem(Good good, int amount){
        if (amount > orderList.get(good)){
            orderList.remove(good);
        }else{
            orderList.put(good, orderList.get(good) - amount);
        }
    }

    public HashMap<Good, Integer> getItems(){
        return orderList;
    }
    public int calculatePrice(){
        int totalPrice = 0;
        for (Map.Entry m: orderList.entrySet()){
                Good good = (Good) m.getKey();
                int itemQuantity = (int) m.getValue();
                totalPrice += good.getPrice() * itemQuantity;
        }
//        System.out.println("ddkjhd :" + orderDiscount.getPercentage());
        totalPrice = totalPrice - (int)(totalPrice * (orderDiscount.getPercentage()/(double)100));
        return totalPrice;
    }
    public void addDiscount(Discount discount){
        orderDiscount = discount;
    }
}
