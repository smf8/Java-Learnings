package HW3;

import java.util.HashMap;

public class Good {
    int id;
    int price;
    String name;

    public Good(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
