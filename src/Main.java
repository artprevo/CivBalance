import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        List<Civ> civList = new ArrayList<Civ>();

        // Just implementing some civs b4 working w/ DB
        civList.add(testCiv("Mongolia", "Genghis Khan", 1, 4, 1, 1));
        civList.add(testCiv("Mayans", "Lady Six Skies", 1, 2, 4, 1));
        civList.add(testCiv("Russia", "Peter", 4, 2, 3, 1));
        civList.add(testCiv("India", "Gandhi", 2, 3, 3, 1));
        civList.add(testCiv("Japan", "Hojo Tokimune", 2, 2, 4, 3));
        civList.add(testCiv("Ethiopia", "Menelik 2", 2, 1, 3, 1));
        civList.add(testCiv("Sweden", "Kristina", 4, 1, 3, 1));
        civList.add(testCiv("Rome", "Trajan", 2, 3, 2, 1));
        civList.add(testCiv("China", "Qin Shi Huangxi", 4, 1, 1, 1));
        civList.add(testCiv("Cree", "Poundmaker", 1, 1, 4, 1));
        civList.add(testCiv("France", "Catherine the Black Queen", 2, 4, 1, 2));
        civList.add(testCiv("Maori", "Kupe", 2, 2, 3, 3));
        civList.add(testCiv("Persia", "Cyrus", 2, 3, 2, 2));
        civList.add(testCiv("Germany", "Frederik", 1, 1, 4, 1));
        civList.add(testCiv("Zulu", "Shaka", 2, 4, 1, 1));
        civList.add(testCiv("Mapuche", "Lautaro", 2, 3, 1, 2));
        civList.add(testCiv("Carthage", "Dido", 1, 1, 4, 3));
        civList.add(testCiv("England", "Victoria", 1, 2, 2, 4));
        civList.add(testCiv("Norway", "Harald", 2, 2, 2, 3));

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

        System.out.println("Welcome to CivBalance, please choose an option : ");

        while (true) {
//            This is the menu
            if (start)
                System.out.println("Please choose an option : ");
            System.out.printf("%d : %s | %d : %s | %d : %s | %d : %s | %d : %s\n",
                    statusCommand.getCommandNb(), statusCommand.getCommandName(),
                    addCiv.getCommandNb(), addCiv.getCommandName(),
                    civLadder.getCommandNb(), civLadder.getCommandName(),
                    draft.getCommandNb(), draft.getCommandName(),
                    5, "exit");
            switch (scanner.nextInt()) {
                case 1: // status
                    statusCommand.executeCommand(civList);
                    break;
                case 2: // add a civ
                    Civ new_civ = addCiv.executeCommand();
                    civList.add(new_civ);
                    break;
                case 3: // Choice of ladder
                    civLadder.executeCommand(civList);
                    break;
                case 4: // help to draft
                    draft.executeCommand();
                    break;
                case 5: // exit
                    System.out.println("Goodbye my friend");
                    exit(0);
                default:
            }
            start = true;
        }
    }

    // function to work without DB for now
    private static Civ testCiv(String civName, String leaderName, int cS, int wS, int sS, int nS) {
        Civ new_civ = new Civ();
        new_civ.setCivName(civName);
        new_civ.setLeaderName(leaderName);
        new_civ.setCultureScore(cS);
        new_civ.setWarScore(wS);
        new_civ.setSimScore(sS);
        new_civ.setNavalScore(nS);
        return new_civ;
    }
}