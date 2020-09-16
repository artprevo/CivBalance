import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        List<Civ> civList = new ArrayList<Civ>();
        StatusCommand statusCommand = new StatusCommand();
        CivLadderCommand civLadder = new CivLadderCommand();
        AddCivCommand addCiv = new AddCivCommand();
        DraftCommand draft = new DraftCommand();

        statusCommand.initializeCommand();
        civLadder.initializeCommand();
        addCiv.initializeCommand();
        draft.initializeCommand();

        System.out.println("Bienvenue sur CivBalance, veuillez choisir une option:");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            if (choice != 0)
                System.out.println("Veuillez choisir une option:");
            System.out.printf("%d : %s | %d : %s | %d : %s | %d : %s | %d : %s\n",
                    statusCommand.getCommandNb(), statusCommand.getCommandName(),
                    addCiv.getCommandNb(), addCiv.getCommandName(),
                    civLadder.getCommandNb(), civLadder.getCommandName(),
                    draft.getCommandNb(), draft.getCommandName(),
                    5, "exit");
            choice = scanner.nextInt();
            if (choice == 1)
                statusCommand.executeCommand();
            if (choice == 2)
                addCiv.executeCommand();
            if (choice == 3)
                civLadder.executeCommand();
            if (choice == 4)
                draft.executeCommand();
        }
        System.out.println("Goodbye my friend");
    }
}
