class Order{


private int id;
private String foodname;
private double price;
private int quantity;

    public Order(int id, String foodname, double price, int quantity) {
        this.id = id;
        this.foodname = foodname;
        this.price = price;
        this.quantity = quantity;
    }

    public Order() {
    }


    public String getFoodname() {
        return foodname;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}