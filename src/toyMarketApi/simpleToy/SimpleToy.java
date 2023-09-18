package toyMarketApi.simpleToy;

import toyMarketApi.toy.Toy;

public class SimpleToy implements Toy {
    private int id;
    private String name;
    private int frequency;

    public SimpleToy(int id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public SimpleToy(SimpleToy simpleToy) {
        this(simpleToy.id, simpleToy.name, simpleToy.frequency);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getFrequency() {
        return this.frequency;
    }

    @Override
    public boolean setLowFrequency() {
        if (this.getFrequency() > 1) {
            this.frequency = this.getFrequency() - 1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String print() {
        return this.getName();
    }
}
