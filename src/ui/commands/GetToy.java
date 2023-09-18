package ui.commands;

import ui.ConsoleUI;

public class GetToy extends Command{
    public GetToy(ConsoleUI consoleUI){
        super(consoleUI);
        this.description = "Вытянуть игрушку";
    }

    @Override
    public boolean execute() {
        return this.getConsoleUI().get();
    }
}
