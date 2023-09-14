package toyMarketApi.toys;

import toyMarketApi.toy.Toy;

import java.util.PriorityQueue;

public interface ToysInterface<E extends Toy> {

    PriorityQueue<E> getToys();

    boolean addToy(E toy);

    E getToy();
}
