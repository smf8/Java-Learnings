package HW3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Shop {
    String name;
    int income;
    ArrayList<Customer> customers;
    ArrayList<Good> goods;
    ArrayList<Repository> repositories;
    ArrayList<Discount> discounts;
    ArrayList<Order> orders = new ArrayList<>();

    public Shop(String name) {
        this.name = name;
        customers = new ArrayList<>();
        goods = new ArrayList<>();
        repositories = new ArrayList<>();
        discounts = new ArrayList<>();
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    public void addRepository(Repository repository){
        repositories.add(repository);
    }
    public ArrayList<Repository> getRepositories(){
        return repositories;
    }
    public void addGood(Good good){
        goods.add(good);
    }
    public void incrementGood(Good good, int amount){
        // loop through ascending sorted list of repositories and add to the first one with enough space for this amount of good
        repositories.sort(Comparator.comparingInt(r -> r.capacity));
        for (Repository r : repositories){
            if (r.getFreeCapacity() >= amount){
                r.addGood(good, amount);
            }
        }
    }
    public ArrayList<Good> getGoods(){
        return goods;
    }

    public void addDiscount(Discount discount, Customer customer){
        // gives discount d to customer c
//        for (Customer c : customers){
//            if (c.id == customer.id){
//                c.
//            }
//        }
    }
    public HashMap<Good, Integer> getItemsSold(){
        // returns a map of goods with their corresponding number of sells
        return null;
    }
    public void addDiscount(Discount discount){
        discounts.add(discount);
    }

    private Good getGoodByID(int id){
        for (Good g: goods){
            if (id == g.id){
                return g;
            }
        }
        return null;
    }
    private Order getOrderByID(int id){
        for (Order order : orders) {
            if (id == order.id) {
                return order;
            }
        }
        return null;
    }
    private Customer getCustomerByID(int id){
        for(Customer customer : customers){
            if (id == customer.id){
                return customer;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        Shop shop = new Shop("Test");
        while(!line.equals("terminate")){
            String whichPart = sc.next();
            if (line.equals("add")){
                if (whichPart.equals("customer")){
                    Customer c = new Customer(Integer.valueOf(sc.next()), sc.next());
                    shop.customers.add(c);
                }else if (whichPart.equals("good")){
                    int id = Integer.valueOf(sc.next());
                    String name = sc.next();
                    int price = Integer.parseInt(sc.next());
                    int amount = Integer.parseInt(sc.next());
                    Good g = new Good(id, price, name);
                    shop.goods.add(g);
                    shop.repositories.get(0).addGood(g, amount);
                }else if (whichPart.equals("repository")){
                    int id = Integer.valueOf(sc.next());
                    int capacity = Integer.valueOf(sc.next());
                    Repository repository = new Repository(id, capacity);
                    shop.repositories.add(repository);
                }else if (whichPart.equals("order")){
                    int id = Integer.valueOf(sc.next());
                    int userID = Integer.valueOf(sc.next());
                    Order order = new Order(id, shop.getCustomerByID(userID));
                    shop.orders.add(order);
                    Customer currentCustomer = shop.getCustomerByID(userID);
                    currentCustomer.addOrder(order);
                    // what to do with this ?!!!
                }else if (whichPart.equals("balance")){
                    int userID = Integer.valueOf(sc.next());
                    int balance = Integer.valueOf(sc.next());
                    Customer c = shop.getCustomerByID(userID);
                    c.balance += balance;
                }else if (whichPart.equals("item")){
                    int orderID = Integer.parseInt(sc.next());
                    int itemID = Integer.parseInt(sc.next());
                    int itemAmount = Integer.parseInt(sc.next());
                    Order order = shop.getOrderByID(orderID);
                    order.addItem(shop.getGoodByID(itemID), itemAmount);
                }else if (whichPart.equals("discount")){
                    int discountID = Integer.parseInt(sc.next());
                    int discountPercentage = Integer.parseInt(sc.next());
                    Discount discount = new Discount(discountID, discountPercentage);
                    shop.discounts.add(discount);
                }
            }else if (line.equals("remove")){
                if (whichPart.equals("item")){
                    int orderID = Integer.parseInt(sc.next());
                    int itemID = Integer.parseInt(sc.next());
                    Order order = shop.getOrderByID(orderID);
                    order.removeWholeItem(shop.getGoodByID(itemID));
                }
            }else if (line.equals("report")){
                if (whichPart.equals("customers")){
                    for (Customer c : shop.customers){
                        System.out.println(c.id + "," + c.name + "," + c.balance + "," + c.getTotalOrders().size() + ","+ c.getSubmitedOrders().size());
                    }
                }else if (whichPart.equals("repositories")){
                    for (Repository r : shop.repositories){
                        System.out.println(r.id + "," + r.capacity + "," + r.getFreeCapacity());
                    }
                }else if (whichPart.equals("income")){
                    System.out.println(shop.income);
                }
            }else if (line.equals("submit")){
                if (whichPart.equals("order")){
                    int orderID = Integer.parseInt(sc.next());
                    Order aboutToSubmit = shop.getOrderByID(orderID);
                    aboutToSubmit.status = Order.Status.SUBMITTED;
                    shop.customers.get(0).submitOrder(aboutToSubmit, shop);
                    shop.income += aboutToSubmit.calculatePrice();

                }else if (whichPart.equals("discount")){
                    int orderID = Integer.parseInt(sc.next());
                    int discountID = Integer.parseInt(sc.next());
                    Order order = shop.getOrderByID(orderID);
                    order.addDiscount(shop.discounts.get(0));
                }
            }
            line = sc.next();
        }
    }
}
