package presenter;

import toyMarketApi.Service;
import ui.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    private Service getService() {
        return this.service;
    }

    public boolean put(int id, String name, int frequency) {
        return this.getService().put(id, name, frequency);
    }

    public String get() throws RuntimeException {
        return this.getService().get();
    }

    public boolean saveResults(String fileName) throws RuntimeException {
        return this.getService().saveResult(fileName);
    }
}
