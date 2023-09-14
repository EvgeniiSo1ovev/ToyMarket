package ui.commands;

import ui.ConsoleUI;

public abstract class Command {
    String description;
    private ConsoleUI consoleUI;
    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }
    public String getDescription(){
        return this.description;
    }

    public ConsoleUI getConsoleUI(){
        return this.consoleUI;
    }

    public abstract boolean execute();
}
