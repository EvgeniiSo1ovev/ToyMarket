package toyMarketApi.toys;

import toyMarketApi.toy.Toy;

import java.util.Iterator;
import java.util.List;

public class ToyIterator<E extends Toy> implements Iterator<E> {
    private int index;
    private List<E> toys;

    public ToyIterator(List<E> toys) {
        this.toys = toys;
    }

    public List<E> getToys() {
        return this.toys;
    }

    @Override
    public boolean hasNext() {
        return index < this.getToys().size();
    }

    @Override
    public E next() {
        return this.getToys().get(index++);
    }
}
