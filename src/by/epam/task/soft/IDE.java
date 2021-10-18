package by.epam.task.soft;

import java.util.Objects;

public class IDE {

    private String name;
    private int size;
    private int price;

    public IDE(String name, int size, int price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public IDE() {
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
    public String toString() {
        return "IDE{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IDE ide = (IDE) o;
        return size == ide.size && price == ide.price && Objects.equals(name, ide.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, price);
    }
}