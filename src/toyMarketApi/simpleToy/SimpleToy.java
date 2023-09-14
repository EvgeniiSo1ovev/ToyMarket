package toyMarketApi.simpleToy;

import toyMarketApi.toy.Toy;

public class SimpleToy implements Toy {
    private int id;
    private String name;
    private int frequency;

    public SimpleToy(int id, String name, int frequency){
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }
    public int getId(){
        return this.id;
    };

    public String getName(){
        return this.name;
    };

    public int getFrequency(){
        return this.frequency;
    };
}
