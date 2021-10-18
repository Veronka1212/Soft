package by.epam.task.build;

import by.epam.task.soft.Antivirus;
import by.epam.task.soft.Browser;
import by.epam.task.soft.Driver;
import by.epam.task.soft.Games;
import by.epam.task.soft.IDE;
import by.epam.task.soft.OS;
import by.epam.task.soft.Office;

public class Soft {

    public OS os;
    public Driver driver;
    public Antivirus antivirus;
    public Browser browser;
    public Games games;
    public IDE ide;
    public Office office;

    public static class Builder {

        public OS os;
        public Driver driver;
        public Antivirus antivirus = new Antivirus("",0, 0);
        public Browser browser = new Browser("",0, 0);
        public Games games = new Games("",0, 0);
        public IDE ide = new IDE("",0, 0);
        public Office office = new Office("",0, 0);

        public Builder(OS os, Driver driver) {
            this.os = os;
            this.driver = driver;
        }

        public Builder antivirus(Antivirus a) {
            antivirus = a;
            return this;
        }

        public Builder browser(Browser b) {
            browser = b;
            return this;
        }

        public Builder games(Games g) {
            games = g;
            return this;
        }

        public Builder ide(IDE i) {
            ide = i;
            return this;
        }

        public Builder office(Office o) {
            office = o;
            return this;
        }

        public Soft build() {
            return new Soft(this);
        }
    }

    private Soft(Builder builder) {
        os = builder.os;
        driver = builder.driver;
        antivirus = builder.antivirus;
        browser = builder.browser;
        games = builder.games;
        ide = builder.ide;
        office = builder.office;
    }
}
