import java.sql.*;
import java.util.Scanner;

public class StatusCommand extends Commands {

    public void executeCommand(User user) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/civbalance?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&autoReconnect=true&useSSL=false";
        try (Connection myConn = DriverManager.getConnection(url, "root", "dota2010")) {
            Statement myStat = myConn.createStatement();
            StringBuilder requete = new StringBuilder("");
            requete.append("select name from ranking natural join civ where user_id = ")
                    .append(user.getUser_id());
            ResultSet rs = myStat.executeQuery(requete.toString());
            while (rs.next()) {
                    System.out.println(rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void menu(User user, boolean tierListDone) {

        if (tierListDone)
            System.out.println(user.getUsername() + "you did make a tierList, please choose an option : ");
        else
            rank_a_civ(user);
        boolean var = false;
        while (!var) {
            System.out.println("1 : show all civs | 2 : show all with details | 3 : return");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    var = true;
                    break;
            }
        }
    }

    public void rank_a_civ(User user) {
        String url = "jdbc:mysql://localhost:3306/civbalance?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&autoReconnect=true&useSSL=false";
        try (Connection myConn = DriverManager.getConnection(url, "root", "dota2010")) {
            Statement myStat = myConn.createStatement();
            String sql = "SELECT * FROM civbalance.civ";
            ResultSet rs = myStat.executeQuery(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
