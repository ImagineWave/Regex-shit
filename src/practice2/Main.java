package practice2;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        OktmoData d = new OktmoData();
        d.readFile("oktmo.csv");
        Place place =  d.findByNameCode4nonZero("Уфа");
        System.out.println(d.getPlaces().size());
        Map<String, Integer> map = d.getNamesRating(d.findAllInRegionByPlace(place));

        for (Map.Entry<String, Integer> pair : map.entrySet()){
            System.out.println(pair.getKey()+" "+pair.getValue());
        }




    }

}
