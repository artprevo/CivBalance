import java.sql.*;

public class RequeteSql {

    private final String url = "jdbc:mysql://localhost:3306/civbalance?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private final String user = "root";
    private final String password = "dota2010";

    public ResultSet executeQuery (String requete) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Statement myStat = null;
        try {
            assert myConn != null;
            myStat = myConn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet rs = null;
        try {
            assert myStat != null;
            rs = myStat.executeQuery(requete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    public void executeUpdate (String requete) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Statement myStat;
        try {
            assert myConn != null;
            myStat = myConn.createStatement();
            myStat.executeUpdate(requete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
