package by.epam.task.calc;

import by.epam.task.build.Soft;

public class Calculation {

    public static int overallSize (Soft computer){
        int sum=0;
        sum=sum+computer.os.getSize()+
                computer.driver.getSize()+
                computer.antivirus.getSize()+
                computer.office.getSize()+
                computer.ide.getSize()+
                computer.browser.getSize()+
                computer.games.getSize();
        return sum;
    }

    public static int overallPrice (Soft computer){
        int sum=0;
        sum=sum+computer.os.getPrice()+
                computer.driver.getPrice()+
                computer.antivirus.getPrice()+
                computer.office.getPrice()+
                computer.ide.getPrice()+
                computer.browser.getPrice()+
                computer.games.getPrice();
        return sum;
    }
}
