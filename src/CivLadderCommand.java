import java.util.*;

public class CivLadderCommand extends Commands implements CommandInterface {

//    Allow user to chose different options from a menu, each going to sort the civ list based on a specific field
    public void executeCommand(List<Civ> civList) {
        System.out.println("Please choose how to order civs : ");
        boolean var = false;
        while (!var) {
            System.out.println("1 : by global_score | 2 : by culture | 3 : by war | 4 : by sim | 5 : by naval | 6 : add a map | 7 : return");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1 -> { // globalScore
                    System.out.println("By global score : ");
                    civList.sort(new Comparator<Civ>() {
                        @Override
                        public int compare(Civ o1, Civ o2) {
                            return Integer.compare(o2.getGlobalScore(), o1.getGlobalScore());
                        }
                    });
                    for (int i = 1; i <= civList.size(); i++) {
                        System.out.println(i + ". " + civList.get(i - 1).getCivName() + " with a score of " + civList.get(i - 1).getGlobalScore());
                    }
                }
                case 2 -> { // cultureScore
                    System.out.println("By culture score : ");
                    civList.sort(new Comparator<Civ>() {
                        @Override
                        public int compare(Civ o1, Civ o2) {
                            return Integer.compare(o2.getCultureScore(), o1.getCultureScore());
                        }
                    });
                    for (int i = 1; i <= civList.size(); i++) {
                        System.out.println(i + ". " + civList.get(i - 1).getCivName() + " with a score of " + civList.get(i - 1).getCultureScore());
                    }
                }
                case 3 -> { // warScore
                    System.out.println("By war score : ");
                    civList.sort(new Comparator<Civ>() {
                        @Override
                        public int compare(Civ o1, Civ o2) {
                            return Integer.compare(o2.getWarScore(), o1.getWarScore());
                        }
                    });
                    for (int i = 1; i <= civList.size(); i++) {
                        System.out.println(i + ". " + civList.get(i - 1).getCivName() + " with a score of " + civList.get(i - 1).getWarScore());
                    }
                }
                case 4 -> { // simScore
                    System.out.println("By sim score : ");
                    civList.sort(new Comparator<Civ>() {
                        @Override
                        public int compare(Civ o1, Civ o2) {
                            return Integer.compare(o2.getSimScore(), o1.getSimScore());
                        }
                    });
                    for (int i = 1; i <= civList.size(); i++) {
                        System.out.println(i + ". " + civList.get(i - 1).getCivName() + " with a score of " + civList.get(i - 1).getSimScore());
                    }
                }
                case 5 -> { // navalScore
                    System.out.println("By naval score : ");
                    civList.sort(new Comparator<Civ>() {
                        @Override
                        public int compare(Civ o1, Civ o2) {
                            return Integer.compare(o2.getNavalScore(), o1.getNavalScore());
                        }
                    });
                    for (int i = 1; i <= civList.size(); i++) {
                        System.out.println(i + ". " + civList.get(i - 1).getCivName() + " with a score of " + civList.get(i - 1).getNavalScore());
                    }
                }
                case 6 -> addModifier(civList);
                case 7 -> var = true;
                default -> System.out.println("You think you smart, type again fucker :");
            }
        }
    }

//    Change the value of fields in every Civ Object, user choose which map and it changes values
    public void addModifier(List<Civ> civList) {
        System.out.println("Please choose a map : ");
        System.out.println("1 : Pangea | 2 : Continents | 3 : 7 seas | 4 : Intern Sea | 5 : return");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1: // Pangea
                for (Civ civ : civList) {
                    civ.setCultureScore(civ.getCultureScore() * 2);
                    civ.setWarScore(civ.getWarScore() * 2);
                }
                break;
            case 2: // Continents
                for (Civ civ : civList) {
                    civ.setWarScore(civ.getWarScore() * 2);
                    civ.setNavalScore(civ.getNavalScore() * 2);
                }
                break;
            case 3: // 7 seas
                for (Civ civ : civList) {
                    civ.setSimScore(civ.getSimScore() * 2);
                    civ.setCultureScore(civ.getCultureScore() * 2);
                }
                break;
            case 4: // Intern Sea
                for (Civ civ : civList) {
                    civ.setSimScore(civ.getSimScore() * 2);
                    civ.setWarScore(civ.getWarScore() * 2);
                }
                break;
            default :
                break;
        }
    }

//    just getters and setters
    @Override
    public void setCommandName() {
        super.setCommandName("civ_ladder");
    }

    @Override
    public void setCommandNb() {
        super.setCommandNb(3);
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
