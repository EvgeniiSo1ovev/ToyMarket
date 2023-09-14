package toyMarketApi;

import presenter.Presenter;
import toyMarketApi.simpleToy.SimpleToy;
import toyMarketApi.toy.Toy;
import toyMarketApi.toys.Toys;

import java.util.ArrayList;
import java.util.List;


public class Service {
    private List<Toy> gettingToys;
    private Toys<Toy> toys;

    public Service() {
        this(new Toys<>());
    }

    public Service(Toys<Toy> toys) {
        this.gettingToys = new ArrayList<>();
        this.toys = toys;
    }

    public boolean put(int id, String name, int frequency) {

        return true;
    }

    public Toy get(){
        Toy result = new SimpleToy();
        return result;
    }
}
