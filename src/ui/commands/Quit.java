package ui.commands;

import ui.ConsoleUI;

public class Quit extends Command {
    public Quit(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Выход из приложения";
    }

    @Override
    public boolean execute() {
        return this.getConsoleUI().quit();
    }
}
