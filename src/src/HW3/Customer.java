package HW3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    int id;
    String name;
    int balance;
    HashMap<Order, Boolean> orders = new HashMap<>();

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addOrder(Order order) {
        orders.put(order, false);
    }

    public ArrayList<Order> getTotalOrders() {
        ArrayList<Order> res = new ArrayList<>(orders.keySet());
        return res;
    }

    public ArrayList<Order> getPendingOrders() {
        ArrayList<Order> res = new ArrayList<>();
        for (Map.Entry m : orders.entrySet()) {
            Order currentOrder = (Order) m.getKey();
            boolean submited = (boolean) m.getValue();
            if (!submited) {
                res.add(currentOrder);
            }
        }
        return res;
    }

    public ArrayList<Order> getSubmitedOrders() {
        ArrayList<Order> res = new ArrayList<>();
        for (Map.Entry m : orders.entrySet()) {
            Order currentOrder = (Order) m.getKey();
            boolean submited = (boolean) m.getValue();
            if (submited) {
                res.add(currentOrder);
            }
        }
        return res;
    }

    public void submitOrder(Order order, Shop shop) {
        // submit only if goods are available for the amount of request and customers balance is more than the order's total price
        // when order's goods are available in several repositories. order must be taken from the repository with a lower ID
        if (balance >= order.calculatePrice()) {
            boolean flag = true;
            for (Map.Entry m : order.getItems().entrySet()) {
                Good g = (Good) m.getKey();
                if (!shop.repositories.get(0).isGoodAvailable(g)) {
                    flag = false;
                }
            }
            if (flag) {
                balance -= order.calculatePrice();
                for (Map.Entry m : order.getItems().entrySet()) {
                    Good g = (Good) m.getKey();
                    shop.repositories.get(0).removeGood(g, (Integer) m.getValue());
                }
            }
            orders.put(order, true);
        }
    }
}
