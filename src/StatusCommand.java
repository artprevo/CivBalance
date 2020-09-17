import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatusCommand extends Commands implements CommandInterface {

    public void executeCommand(List<Civ> civList) {
        System.out.println("You registered " + civList.size() + " civilizations, please choose an option : ");
        boolean var = false;
        while (!var) {
            System.out.println("1 : show all civs | 2 : show all with details | 3 : return");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    for (Civ civ : civList) {
                        System.out.println(civ.getCivName() + " ");
                    }
                    break;
                case 2:
                    for (Civ civ : civList) {
                        System.out.printf("%s lead by %s has %d culture_score, %d war_score, %d sim_score, " +
                                        "%d naval_score, and %d of global_score\n",
                                civ.getCivName(), civ.getLeaderName(), civ.getCultureScore(), civ.getWarScore(),
                                civ.getSimScore(), civ.getNavalScore(), civ.getGlobalScore());
                    }
                    break;
                case 3:
                    var = true;
                    break;
            }
        }
    }

//    private void civEdit(List<Civ> civList) {
//        Scanner scanner = new Scanner(System.in);
//        boolean is_ok = false;
//        while (!is_ok) {
//            System.out.println("Type a civ name : ");
//            String str = scanner.nextLine();
//            for (Civ civ : civList) {
//                if (civ.getCivName().equals(str)) {
//                    is_ok = true;
//                    break;
//                }
//            }
//        }
//        System.out.println("Please choose what to change : ");
//        System.out.println("1 : civ_name | 2 : leader_name | 3 : culture_score | 4 : war_score | 5 : sim_score | 6 : naval_score | 7 : return");
//        switch (scanner.nextInt()) {
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//            case 6:
//                break;
//            case 7:
//                break;
//        }
//    }

    @Override
    public void setCommandName() {
        super.setCommandName("status");
    }

    @Override
    public void setCommandNb() {
        super.setCommandNb(1);
    }

    @Override
    public void initializeCommand() {
        this.setCommandName();
        this.setCommandNb();
    }

    @Override
    public String getCommandName() {
        return super.getCommandName();
    }

    @Override
    public int getCommandNb() {
        return super.getCommandNb();
    }

}
