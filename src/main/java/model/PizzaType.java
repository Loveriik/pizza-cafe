package model;

public class PizzaType {
    private int position;
    private String name;
    private double price;

    public int getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
