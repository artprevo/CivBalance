import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[] args) {
        List<Commands> commandsList = new ArrayList<Commands>();
        createCommands(commandsList);
        System.out.println("Bienvenue sur CivBalance, veuillez choisir une option:");
        for (int i = 0; i != 4; i++) {
            System.out.printf("%d:%s ", commandsList.get(i).getCommandNb(), commandsList.get(i).getCommandName());
        }
    }

    public static void createCommands(List<Commands> commandsList) {
        for (int i = 0; i != 4; i++) {
            Commands current = new Commands();
            commandsList.add(current);
        }
        fillCommands(commandsList.get(0), "status", 1);
        fillCommands(commandsList.get(1), "create_civ", 2);
        fillCommands(commandsList.get(2), "civ_ladder", 3);
        fillCommands(commandsList.get(3), "draft", 4);
    }

    public static void fillCommands(Commands current, String name, int nb) {
        current.setCommandName(name);
        current.setCommandNb(nb);
    }

}
