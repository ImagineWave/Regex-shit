package practice2;

public class Place implements Comparable<Place>{
    int code1;
    int code2;
    int code3;
    int code4;
    String name;
    String status;

    public Place(int code1, int code2, int code3, int code4, String status, String name) {
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
        this.code4 = code4;
        this.status = status;
        this.name = name;
    }

    public int getCode1() {
        return code1;
    }

    public int getCode2() {
        return code2;
    }

    public int getCode3() {
        return code3;
    }

    public int getCode4() {
        return code4;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(code1);
        sb.append(" ");
        sb.append(code2);
        sb.append(" ");
        sb.append(code3);
        sb.append(" ");
        sb.append(code4);
        sb.append(" status:");
        sb.append(status);
        sb.append(" name:");
        sb.append(name);
        return sb.toString();
    }

    @Override
    public int compareTo(Place place) {

        return name.compareTo(place.getName());
    }
}
