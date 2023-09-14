package toyMarketApi.toys;

import toyMarketApi.toy.Toy;
import toyMarketApi.toys.comparators.toyComparator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Toys<E extends Toy> implements ToysInterface<E> {
    private List<E> toys;
    private PriorityQueue<E> toysPQ;

    public Toys() {
        this.toys = new ArrayList<>();
        this.toysPQ = new PriorityQueue<>(1000, new toyComparator<>());
    }
    public Toys(List<E> toys){

    }

    @Override
    public List<E> getToys() {
        return this.toys;
    }

    @Override
    public PriorityQueue<E> getToysPQ() {
        return this.toysPQ;
    }

    @Override
    public <E extends Toy> boolean addToy(E toy) {
        return ((PriorityQueue<E>) this.getToysPQ()).add(toy);
    }

    @Override
    public void makeToysList() {
        for(E toy: this.toys){

        }
    }

    public E pollToyFromToysPQ(){
        return
    }
    @Override
    public Iterator<E> iterator() {
        return new ToyIterator<>(this.getToys());
    }
}
