package by.epam.task.soft;

import java.util.Objects;

public class Antivirus {

    private String name;
    private int size;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Antivirus antivirus = (Antivirus) o;
        return size == antivirus.size && price == antivirus.price && Objects.equals(name, antivirus.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, price);
    }

    @Override
    public String toString() {
        return "Antivirus{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }


    public Antivirus(String name, int size, int price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public Antivirus() {
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

}
