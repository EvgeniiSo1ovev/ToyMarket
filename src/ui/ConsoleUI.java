package ui;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.work = true;
        this.menu = new Menu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private Presenter getPresenter() {
        return this.presenter;
    }

    private Menu getMenu() {
        return this.menu;
    }

    @Override
    public void start() {
        while (this.work) {
            this.mainRequests();
        }
    }

    private void mainRequests() {
        print(this.getMenu().printMainCommands());
        String nMenuStr = scan();
        if (isCanBeInt(nMenuStr)) {
            int nMenu = Integer.parseInt(nMenuStr);
            if (0 < nMenu && nMenu <= this.getMenu().getSizeMainCommands()) {
                this.getMenu().executeMainCommands(nMenu);
            } else {
                print("Введен неверный пункт меню.");
            }
        } else {
            print("Введено что-то отличное от пунктов меню.");
        }
    }

    private boolean isCanBeInt(String nMenuStr) {
        return nMenuStr.matches("[0-9]+");
    }

    private String scan() {
        return this.scanner.nextLine();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public boolean put() {
        print("Введите id игрушки:");
        return this.getPresenter().put();
    }

    public boolean get() {
        try {
            print(this.getPresenter().get());
            return true;
        } catch (RuntimeException e) {
            print(e.getMessage());
            return false;
        }
    }

    public boolean saveResult() {
        try {
            print("Введите имя файла для сохранения:");
            return this.getPresenter().saveResults(scan());
        } catch (RuntimeException e) {
            print(e.getMessage());
            return false;
        }
    }

    public boolean quit() {
        this.work = false;
        return true;
    }
}
