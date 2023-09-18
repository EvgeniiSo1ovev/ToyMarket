package ui;

import ui.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Menu {
    private List<Command> mainCommands;

    public Menu(ConsoleUI consoleUI) {
        this.mainCommands = new ArrayList<>();
        this.mainCommands.add(new PutToy(consoleUI));
        this.mainCommands.add(new GetToy(consoleUI));
        this.mainCommands.add(new SaveResults(consoleUI));
        this.mainCommands.add(new Quit(consoleUI));
    }

    private List<Command> getMainCommands() {
        return this.mainCommands;
    }

    public int getSizeMainCommands() {
        return this.getMainCommands().size();
    }

    public boolean executeMainCommands(int nMenu) {
        return this.getMainCommands().get(nMenu - 1).execute();
    }

    public String printMainCommands() {
        StringBuilder result = new StringBuilder();
        result.append("Введите что хотите сделать:\n");
        ListIterator<Command> iter = this.getMainCommands().listIterator();
        while (iter.hasNext()) {
            result.append(String.format("%d. ", iter.nextIndex() + 1));
            result.append(iter.next().getDescription()).append("\n");
        }
        return result.toString();
    }
}
