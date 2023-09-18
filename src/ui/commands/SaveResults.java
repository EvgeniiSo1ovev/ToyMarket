package ui.commands;

import ui.ConsoleUI;

public class SaveResults extends Command {
    public SaveResults(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Сохранить результаты розыгрыша";
    }

    @Override
    public boolean execute() {
        return this.getConsoleUI().saveResult();
    }
}
