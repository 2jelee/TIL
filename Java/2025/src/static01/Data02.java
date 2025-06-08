package static01;

public class Data02 {
    public String name;

    public Data02(String name, Counter counter){
        this.name = name;
        counter.count++;
    }
}
