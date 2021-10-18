package by.epam.task.soft;

import by.epam.task.build.Soft;

import java.util.List;
import java.util.Objects;

public class DataFromXML {

    private String type;
    private String name;
    private int size;
    private int price;

    public DataFromXML() {
    }

    public DataFromXML(String type, String name, int size, int price) {
        this.type = type;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataFromXML doMparser = (DataFromXML) o;
        return size == doMparser.size && price == doMparser.price && Objects.equals(type, doMparser.type) && Objects.equals(name, doMparser.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, size, price);
    }

    @Override
    public String toString() {
        return "DOMparser{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public static Soft setNewComputer(List<DataFromXML> list, Soft computer) {

        for (DataFromXML d : list) {
            switch (d.getType()) {
                case "OS":
                    computer.os.setName(d.getName());
                    computer.os.setSize(d.getSize());
                    computer.os.setPrice(d.getPrice());
                    break;
                case "driver":
                    computer.driver.setName(d.getName());
                    computer.driver.setSize(d.getSize());
                    computer.driver.setPrice(d.getPrice());
                    break;
                case "antivirus":
                    computer.antivirus.setName(d.getName());
                    computer.antivirus.setSize(d.getSize());
                    computer.antivirus.setPrice(d.getPrice());
                    break;
                case "browser":
                    computer.browser.setName(d.getName());
                    computer.browser.setSize(d.getSize());
                    computer.browser.setPrice(d.getPrice());
                    break;
                case "games":
                    computer.games.setName(d.getName());
                    computer.games.setSize(d.getSize());
                    computer.games.setPrice(d.getPrice());
                    break;
                case "IDE":
                    computer.ide.setName(d.getName());
                    computer.ide.setSize(d.getSize());
                    computer.ide.setPrice(d.getPrice());
                    break;
                case "office":
                    computer.office.setName(d.getName());
                    computer.office.setSize(d.getSize());
                    computer.office.setPrice(d.getPrice());
                    break;
            }
        }
        return computer;
    }
}
