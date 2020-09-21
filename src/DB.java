import java.sql.*;

public class DB {

    public int user_id;
    public int tier_id;
    public int civ_id;
    public int ranking_id;

    public void areweconnected(Connection myConn) throws SQLException {
        Statement myStat = myConn.createStatement();
        String sql = "SELECT * FROM civbalance.civ";
        ResultSet rs = myStat.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("leader"));
        }
    }
}