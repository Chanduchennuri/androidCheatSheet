package com.example.bare;

public class Order {
    private static String priceFormat = "#,###.00";
    private static String unit = "$";

    private String name;
    private String desc;
    private int avatarResId;
    private double price;
    private int total;

    public Order(String name, String desc, int avatarResId, double price) {
        this(name, desc, avatarResId, price, 0);
    }

    private Order(String name, String desc, int avatarResId, double price, int total) {
        this.name = name;
        this.desc = desc;
        this.avatarResId = avatarResId;
        this.price = price;
        this.total = total;
    }

    public static String getPriceFormat() {
        return priceFormat;
    }

    public static void setPriceFormat(String priceFormat) {
        Order.priceFormat = priceFormat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAvatarResId() {
        return avatarResId;
    }

    public void setAvatarResId(int avatarResId) {
        this.avatarResId = avatarResId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        Order.unit = unit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
