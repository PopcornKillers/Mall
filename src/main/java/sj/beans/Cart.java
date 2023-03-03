package sj.beans;

public class Cart {
    private int id;
    private String good;
    private int num;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
