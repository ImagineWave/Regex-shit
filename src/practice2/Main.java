package practice2;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        OktmoData d = new OktmoData();
        d.readFile("oktmo.csv");
        List<Place> outputByName = d.findByName("Санкт-Петербург");
        List<Place> outputByCode1 = d.findBy1(80);
        List<Place> outputByStatus = d.findByStatus("");
        System.out.println(d.getPlaces().size());
        outputByName.stream().forEach(System.out::println);



    }
}
