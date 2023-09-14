package ui;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;

    public ConsoleUI(){
        this.scanner = new Scanner(System.in);
        this.work = true;
        this.menu = new Menu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {

    }

    public boolean put() {
        return false;
    }
}
