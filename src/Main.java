import java.sql.*;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws SQLException {

        User user = new User();
        login(user);
        menu(user);
        }

    public static void login(User user) {

        String url = "jdbc:mysql://localhost:3306/civbalance?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&autoReconnect=true&useSSL=false";
        String username = null;
        try (Connection myConn = DriverManager.getConnection(url, "root", "dota2010")) {
            Scanner scanner = new Scanner(System.in);
            boolean login = false;
            System.out.println("Welcome to CivBalance, please login : ");
            while (!login) {
                System.out.println("username : ");
                username = scanner.nextLine();
                Statement user_name = myConn.createStatement();
                String sql = "SELECT * FROM civbalance.user WHERE username = " + "'" + username + "'";
                try (ResultSet rs = user_name.executeQuery(sql)) {
                    System.out.println("password : ");
                    while (rs.next()) if (scanner.nextLine().equals(rs.getString("password"))) {
                        login = true;
                        user.setUsername(username);
                        user.setPassword(rs.getString("password"));
                        user.setUser_id(rs.getInt("user_id"));
                    }
                    else
                        System.out.println("Nope, try again");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void menu(User user) {

        boolean start = false;

        myRankings myRankings = new myRankings();
        CivLadderCommand civLadder = new CivLadderCommand();
        DraftCommand draft = new DraftCommand();

        myRankings.initializeCommand();
        civLadder.initializeCommand();
        draft.initializeCommand();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to CivBalance, please choose an option : ");

        while (true)
        {
            if (start)
                System.out.println("Please choose an option : ");
            System.out.printf("%d : %s | %d : %s | %d : %s | %d : %s\n",
                    myRankings.getCommandNb(), myRankings.getCommandName(),
                    civLadder.getCommandNb(), civLadder.getCommandName(),
                    draft.getCommandNb(), draft.getCommandName(),
                    5, "exit");
            switch (scanner.nextInt())
            {
                case 1: // rankings
                    try {
                        myRankings.executeCommand(user);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 2: // Choice of ladder
                    civLadder.executeCommand(user);
                    break;
                case 3: // help to draft
                    draft.executeCommand(user);
                    break;
                case 4: // exit
                    System.out.println("Goodbye my friend");
                    exit(0);
                default:
            }
        start = true;
        }
    }
}