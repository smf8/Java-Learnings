import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    /**
     * product class
     */
    static class Product {
        int id;
        int price;
        String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public Product(int id, String name, int price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    int id;
    private int saleCount;
    private int saleAmount;
    private HashMap<Product, Integer> products = new HashMap<>();


    /**
     *
     * @param saleCount sets created vending machines saleCount to saleCount
     * @param saleAmount sets created vending machines saleAmount to saleAmount
     */
    public VendingMachine(int saleCount, int saleAmount) {
        this.saleCount = saleCount;
        this.saleAmount = saleAmount;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public int getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(int saleAmount) {
        this.saleAmount = saleAmount;
    }

    /**
     *
     * @param p - input product
     * @return returns true if the product exists in machine and false if product didn't exist
     */
    public boolean buy(Product p) {
        if (!products.containsKey(p) || products.get(p) < 1) {
            return false;
        } else {
            this.products.put(p, products.get(p) - 1);
            saleAmount += p.getPrice();
            saleCount++;
            return true;
        }
    }

    /**
     *
     * @param p - the product to increase it's quantity
     * @param amount - the amount to increase
     */
    public void addProduct(Product p, int amount) {
        if (products.containsKey(p))
            this.products.put(p, products.get(p) + amount);
        else
            this.products.put(p, amount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int productsCount = sc.nextInt();
        HashMap<Integer, Product> products = new HashMap<>();
        // initializing the map of products
        for (int i = 0; i < productsCount; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            sc.nextLine();
            int price = sc.nextInt();
            Product p = new Product(id, name, price);
            products.put(id, p);
        }
        int machinesCount = sc.nextInt();
        HashMap<Integer, VendingMachine> machines = new HashMap<>();
        // initializing the map of vending machines
        for (int i = 0; i < machinesCount; i++) {
            VendingMachine machine = new VendingMachine(0, 0);
            machine.setId(i + 1);
            int x = sc.nextInt();
            for (int j = 0; j < x; j++) {
                int productID = sc.nextInt();
                machine.addProduct(products.get(productID), 1);
            }
            machines.put(machine.id, machine);
        }
        int sellCount = sc.nextInt();
        for (int i = 0; i < sellCount; i++) {
            int machineID = sc.nextInt();
            VendingMachine machine = machines.get(machineID);
            int productID = sc.nextInt();
            Product product = products.get(productID);
            machine.buy(product);
        }

        for (Map.Entry m : machines.entrySet()) {
            VendingMachine machine = (VendingMachine) m.getValue();
                System.out.println(machine.getId() + ":" + machine.getSaleCount() + "," + machine.getSaleAmount());
        }
    }
}
