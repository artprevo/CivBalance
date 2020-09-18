package commands;

import model.Civ;

import java.util.Scanner;

public class AddCivCommand extends Commands {

//    This method ask user to enter manually every fields of a Civ Object, and return it into the civList
//    declared in Main.java.
    public Civ executeCommand() {
        Civ new_civ = new Civ();
        new_civ.setCivName(getName("civ"));
        new_civ.setLeaderName(getName("leader"));
        new_civ.setCultureScore(getScore("culture"));
        new_civ.setWarScore(getScore("warmonger"));
        new_civ.setSimScore(getScore("simming"));
        new_civ.setNavalScore(getScore("naval"));
        return new_civ;
    }

//    Ask User to declare name for civ object
    public String getName(String type) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls type the " + type + " name : ");
        return scanner.nextLine();
    }

//    same but for score
    public int getScore(String type) {
        int x = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls note this civ " + type + " potential on a scale from 1 to 4 : ");
        while (x > 4 || x <= 0) {
            x = scanner.nextInt();
            if (x > 4 || x <= 0) System.out.println("Nope");
        }
        return x;
    }

//    just getters and setters
    @Override
    public void setCommandName() {
        super.setCommandName("add_Civ");
    }

    @Override
    public void setCommandNb() {
        super.setCommandNb(2);
    }

}
