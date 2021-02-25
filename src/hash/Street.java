package hash;

public class Street {
    public int intersectionStart, intersectionEnd, time;
    public String name;
    public Street(String a) {
        String split[] = a.split(" ");
        intersectionStart = Integer.parseInt(split[0]);
        intersectionEnd = Integer.parseInt(split[1]);
        name = split[2];
        time = Integer.parseInt(split[3]);
    }

    @Override
    public String toString() {
        return "Streets{" +
                "intersectionStart=" + intersectionStart +
                ", intersectionEnd=" + intersectionEnd +
                ", time=" + time +
                ", name='" + name + '\'' +
                '}';
    }
}
