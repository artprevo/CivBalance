import java.util.Scanner;

public class AddCivCommand extends Commands implements CommandInterface {
    public Civ executeCommand() {
        String  str;
        Civ new_civ = new Civ();

        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        return new_civ;
    }

    @Override
    public void setCommandName() {
        super.setCommandName("Add_Civ");
    }

    @Override
    public void setCommandNb() {
        super.setCommandNb(2);
    }

    @Override
    public void initializeCommand() {
        this.setCommandName();
        this.setCommandNb();
    }
}
