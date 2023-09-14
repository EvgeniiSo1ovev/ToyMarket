package toyMarketApi.toys.comparators;

import toyMarketApi.toy.Toy;

import java.util.Comparator;

public class toyComparator<E extends Toy> implements Comparator<E> {
    @Override
    public int compare(E t1, E t2) {
        return t1.getFrequency() > t2.getFrequency() ? 1 : -1;
    }
}
