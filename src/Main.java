import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {

        StatusCommand statusCommand = new StatusCommand();
        CivLadderCommand civLadder = new CivLadderCommand();
        AddCivCommand addCiv = new AddCivCommand();
        DraftCommand draft = new DraftCommand();

        statusCommand.initializeCommand();
        civLadder.initializeCommand();
        addCiv.initializeCommand();
        draft.initializeCommand();

        Scanner scanner = new Scanner(System.in);
        boolean start = false;
        List<Civ> civList = new ArrayList<Civ>();

        System.out.println("Welcome to CivBalance, please choose an option : ");

        while (true) {
            if (start)
                System.out.println("Please choose an option : ");
            System.out.printf("%d : %s | %d : %s | %d : %s | %d : %s | %d : %s\n",
                    statusCommand.getCommandNb(), statusCommand.getCommandName(),
                    addCiv.getCommandNb(), addCiv.getCommandName(),
                    civLadder.getCommandNb(), civLadder.getCommandName(),
                    draft.getCommandNb(), draft.getCommandName(),
                    5, "exit");
            switch (scanner.nextInt()) {
                case 1:
                    statusCommand.executeCommand(civList);
                    break;
                case 2:
                    Civ new_civ = addCiv.executeCommand();
                    civList.add(new_civ);
                    break;
                case 3:
                    civLadder.executeCommand();
                    break;
                case 4:
                    draft.executeCommand();
                    break;
                case 5:
                    System.out.println("Goodbye my friend");
                    exit(0);
                default:
            }
            start = true;
        }
    }
}