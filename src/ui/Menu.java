package ui;

import ui.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> mainCommands;

    public Menu(ConsoleUI consoleUI) {
        this.mainCommands = new ArrayList<>();
    }

    public int getSizeMainCommands() {
        return this.mainCommands.size();
    }

    public boolean executeMainCommands(int nMenu) {
        return mainCommands.get(nMenu - 1).execute();
    }
}
