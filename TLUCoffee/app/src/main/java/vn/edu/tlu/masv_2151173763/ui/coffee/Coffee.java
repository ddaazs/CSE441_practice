package vn.edu.tlu.masv_2151173763.ui.coffee;

public class Coffee {
    private int MaMon;
    private String name;
    private String price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Coffee(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}

