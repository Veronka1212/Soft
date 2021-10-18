package by.epam.task.soft;

import java.util.Objects;

public class Games {

    private String name;
    private int size;
    private int price;

    public Games(String name, int size, int price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public Games() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Games games = (Games) o;
        return size == games.size && price == games.price && Objects.equals(name, games.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, price);
    }

    @Override
    public String toString() {
        return "Games{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
