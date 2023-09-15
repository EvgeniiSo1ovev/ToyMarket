package toyMarketApi;

import presenter.Presenter;
import toyMarketApi.handler.FileHandler;
import toyMarketApi.simpleToy.SimpleToy;
import toyMarketApi.toy.Toy;
import toyMarketApi.toys.Toys;

import java.util.LinkedList;


public class Service {
    private LinkedList<Toy> gettingToys;
    private Toys<Toy> toys;
    private Toys<Toy> tempToys;

    public Service() {
        this(new Toys<>());
    }

    public Service(Toys<Toy> toys) {
        this.gettingToys = new LinkedList<>();
        this.toys = toys;
        this.tempToys = new Toys<>(toys);
    }

    public LinkedList<Toy> getGettingToys() {
        return this.gettingToys;
    }

    public Toys<Toy> getToys() {
        return this.toys;
    }

    public Toys<Toy> getTempToys() {
        return this.tempToys;
    }

    public boolean put(int id, String name, int frequency) {
        Toy newSimpleToy = new SimpleToy(id, name, frequency);
        return putInToys(newSimpleToy) && putInTempToys(new SimpleToy((SimpleToy) newSimpleToy));
    }

    private boolean put(Toys<Toy> Toys, Toy toy) {
        return Toys.addToy(toy);
    }

    private boolean putInToys(Toy toy) {
        return this.put(this.getToys(), toy);
    }

    private boolean putInTempToys(Toy toy) {
        return this.put(this.getTempToys(), toy);
    }

    private boolean copyTempToys() {
        this.tempToys = new Toys<>(this.getToys());
        return true;
    }

    private Toy getToy() throws RuntimeException {
        if (this.getTempToys().isEmpty()) {
            if (!copyTempToys()) {
                throw new RuntimeException("Ошибка заполнения новой очереди.\n" +
                        "Дальнейшее получение игрушек невозможно.");
            }
        }
        Toy result = this.getTempToys().getToy();
        Toy tempToy = new SimpleToy((SimpleToy) result);
        if (tempToy.setLowFrequency()) {
            this.putInTempToys(tempToy);
        }
        return result;
    }

    public String get() throws RuntimeException {
        Toy gettingToy = this.getToy();
        this.getGettingToys().add(gettingToy);
        return gettingToy.print();
    }

    public boolean saveResult(String fileName) throws RuntimeException {
        try {
            return new FileHandler().save(this.gettingToysString(), fileName);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private String gettingToysString() {
        StringBuilder result = new StringBuilder();
        LinkedList<Toy> gettingToys = this.getGettingToys();
        for (Toy gettingToy : gettingToys) {
            result.append(gettingToy.print());
        }
        return result.toString();
    }
}
