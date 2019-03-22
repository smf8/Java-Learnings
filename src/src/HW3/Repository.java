package HW3;

import java.util.HashMap;

public class Repository {
    int id;
    int capacity;
    int usedCapacity;
    HashMap<Good, Integer> goodsAvailable = new HashMap<>();
    public Repository(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
    public boolean isGoodAvailable(Good g){
        return goodsAvailable.containsKey(g) && goodsAvailable.get(g) > 0;
    }
    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFreeCapacity() {
        return capacity - usedCapacity;
    }
    public HashMap<Good,Integer> getGoods(){
        return goodsAvailable;
    }
    public void addGood(Good g, int amount){
        if (goodsAvailable.containsKey(g)){
            goodsAvailable.put(g, goodsAvailable.get(g) + amount);
        }else{
            goodsAvailable.put(g, amount);
        }
        usedCapacity += amount;
    }

    public void removeGood(Good good, int amount){
        int available = goodsAvailable.get(good);
        if (amount > available){
            goodsAvailable.remove(good);
        }else{
            goodsAvailable.put(good, goodsAvailable.get(good) - amount);
        }
        usedCapacity -= amount;
    }
}
