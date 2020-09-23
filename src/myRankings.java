import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.Scanner;

public class myRankings extends Commands implements CommandInterface {

    public void executeCommand(User user) throws SQLException {
        boolean tierListDone = true;
        ResultSet rs  = exeQuery("SELECT * FROM civbalance.civ");
        while (rs.next()) {
            if (already_ranked(user, rs.getInt("civ_id")))
                tierListDone = false;
        }
        menu(user, tierListDone);
    }

    public void menu(User user, boolean tierListDone) throws SQLException {
        if (tierListDone)
            System.out.println(user.getUsername() + " you did finish your tierList, please choose an option : ");
        else
            createTierList(user);
        boolean var = false;
        while (!var) {
            System.out.println("1 : show your ranking | 2 : edit your ranking | 3 : return");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    Print print = new Print();
                    print.printRankingList(user);
                    break;
                case 2:
                    break;
                case 3:
                    var = true;
                    break;
            }
        }
    }

    public void createTierList(User user) throws SQLException {
        RequeteSql RS = new RequeteSql();
        Input input = new Input();
        ResultSet rs = exeQuery("SELECT * FROM civbalance.civ");
       while (rs.next()) {
           if (already_ranked(user, rs.getInt("civ_id"))) {
               System.out.println("Choose a tier for " + rs.getString("name") + " (" + rs.getString("leader") + ") FROM 1 to 7");
               int tierChosen = input.tierInput();
               System.out.println(tierChosen);
               RS.executeUpdate("INSERT INTO `ranking` (civ_id, tier_id, user_id) VALUES (" + rs.getInt("civ_id") + "," + tierChosen + "," + user.getUser_id() + ")");
           }
       }
    }

    // check if a civ has been ranked by this user
    public boolean already_ranked(@NotNull User user, int civ_id) throws SQLException {
        ResultSet rs = exeQuery("SELECT * FROM ranking WHERE user_id = " + user.getUser_id() + " and civ_id = " + civ_id);
        return !rs.next();
    }

    @Override
    public void setCommandName() {
        super.setCommandName("my_rankings");
    }

    @Override
    public void setCommandNb() {
        super.setCommandNb(1);
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
