package practice2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        OktmoData d = new OktmoData();
        d.readFile("oktmo.csv");
        List<Place> outputByName = d.findByName("Уфа");
        List<Place> outputByCode1 = d.findBy1(80);
        List<Place> outputByStatus = d.findByStatus("");
        System.out.println(d.getPlaces().size());
        outputByStatus.stream().forEach(System.out::println);


    }
}
