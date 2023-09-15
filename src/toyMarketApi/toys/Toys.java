package toyMarketApi.toys;

import toyMarketApi.toy.Toy;
import toyMarketApi.toys.comparators.ToyComparator;

import java.util.PriorityQueue;

public class Toys<E extends Toy> implements ToysInterface<E> {
    private PriorityQueue<E> toys;

    public Toys() {
        this(new PriorityQueue<>(new ToyComparator<>()));
    }

    public Toys(Toys<E> toys) {
        this(toys.toys);
    }

    public Toys(PriorityQueue<E> toys) {
        this.toys = new PriorityQueue<>(toys);
    }

    @Override
    public PriorityQueue<E> getToys() {
        return this.toys;
    }

    @Override
    public boolean addToy(E toy) {
        return this.getToys().offer(toy);
    }

    @Override
    public E getToy() {
        return this.getToys().poll();
    }

    public boolean isEmpty() {
        return this.getToys().isEmpty();
    }
}
