package org.example;
//Заказы разметсил одним простеньким классом, но очевидно, что можно было бы
// так же создать абстрактный класс Order и к нему прилепить кучу дочерних категорий для заказов
//Например Телефоны, Пк/ноутбуки, Машины, Музыкальные инструменты и т.п.
public class Order {
    private int price;
    private String productName;
    private int sum;

    public int getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public int getSum() {
        return sum;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Позиция:" +
                "Наименование товара: " + productName +
                "- Цена за штуку: " + price +
                "- Остаток на складе: " + sum;
    }

    public Order(int price, String productName, int sum) {
        this.price = price;
        this.productName = productName;
        this.sum = sum;
    }
}
