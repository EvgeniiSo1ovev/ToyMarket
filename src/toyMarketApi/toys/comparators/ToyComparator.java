package toyMarketApi.toys.comparators;

import toyMarketApi.toy.Toy;

import java.util.Comparator;
import java.util.Random;

public class ToyComparator<E extends Toy> implements Comparator<E> {
    @Override
    public int compare(E t1, E t2) {
        int result = t1.getFrequency() < t2.getFrequency() ? 1 : -1;
        if (result == -1 && t1.getFrequency() == t2.getFrequency()) {
            Random random = new Random();
            if (random.nextBoolean()) {
                result = 1;
            }
        }
        return result;
    }
}
