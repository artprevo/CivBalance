package commands;

import model.Civ;

import java.util.*;

public class CivLadderCommand extends Commands {

    public void executeCommand(User user) {
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
        super.setCommandName("civ_ladder");
    }

    @Override
    public void setCommandNb() {
        super.setCommandNb(2);
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
