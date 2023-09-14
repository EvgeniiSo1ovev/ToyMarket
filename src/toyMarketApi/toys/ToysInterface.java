package toyMarketApi.toys;

import toyMarketApi.toy.Toy;

import java.util.List;
import java.util.PriorityQueue;

public interface ToysInterface<E extends Toy> extends Iterable<E> {

    List<E> getToys();

    PriorityQueue<E> getToysPQ();

    <E extends Toy> boolean addToy(E toy);
}
