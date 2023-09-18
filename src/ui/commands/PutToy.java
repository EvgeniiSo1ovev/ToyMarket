package ui.commands;

import ui.ConsoleUI;

public class PutToy extends Command {
    public PutToy(ConsoleUI consoleUI){
        super(consoleUI);
        this.description = "Добавить игрушку";
    }

    @Override
    public boolean execute() {
        return this.getConsoleUI().put();
    }
}
