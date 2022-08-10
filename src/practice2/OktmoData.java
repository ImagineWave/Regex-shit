package practice2;

import com.sun.org.apache.bcel.internal.util.ClassSet;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OktmoData {
    private List<Place> places = new ArrayList<>();

    public void readFile(String filename) {
        places.clear();
        Path p = Paths.get(filename);
        try {
            List<String> lines = Files.readAllLines(p, Charset.forName("cp1251"));
            for (String s: lines) {
                readLine(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
//"01";"512";"000";"146";"9";"2";"п Калиновка";;;"493";"3";12.08.2021;01.01.2022
    //private static final Pattern RE=Pattern.compile("\"(\\d+)\";\"(\\d+)\";\"(\\d+)\";\"(\\d+)\"");
    private static final Pattern RE=Pattern.compile("(\\d+)\";\"(\\d+)\";\"(\\d+)\";\"(\\d+)\";\"\\d\";\"\\d\";\"([А-Яа-я\\s]+) ([А-Яа-я\\s]+)");
    //"(\d+)";"(\d+)";"(\d+)";"(\d+)";"\d";"\d";"([А-Яа-я\s]) ([А-Яа-я\s]+)
    private void readLine(String s) {
        Matcher m = RE.matcher(s);
        if (m.find()) {
            places.add(new Place(
                    Integer.parseInt(m.group(1)),
                    Integer.parseInt(m.group(2)),
                    Integer.parseInt(m.group(3)),
                    Integer.parseInt(m.group(4)),

                    m.group(5),
                    m.group(6)
                    ));
        }
    }
    public List<Place> findByName(String name){
         //places.stream().findFirst(k -> name)
        return places.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
    }
    public List<Place> findBy1(int code1){
        return places.stream().filter(p -> p.getCode1() == code1 ).collect(Collectors.toList());
    }
    public List<Place> findByStatus(String status){
        return places.stream().filter(p -> p.getStatus().equals(status) ).collect(Collectors.toList());
    }
    public List<Place> getPlaces() {
        return places;
    }
}
