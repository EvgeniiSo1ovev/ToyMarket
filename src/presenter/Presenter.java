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

    public boolean put(int id, String name, int frequency) {
        return service.put(id, name, frequency);
    }

    public String get() {
        return service.get();
    }
}
