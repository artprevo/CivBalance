import java.sql.ResultSet;
import java.sql.SQLException;

public class Print {

    public void printByUserByTier(int user_id, int tier_id) throws SQLException {
        ResultSet rs = exeQuery("SELECT * FROM civbalance.ranking WHERE user_id = " + user_id + " and tier_id = " + tier_id);
        System.out.println(getTierName(tier_id) + " :" + '\n');
        while (rs.next())
            System.out.println(getCivName(rs.getInt("civ_id")) + " (" + getLeaderName(rs.getInt("civ_id")) + ")");
        System.out.println();
    }

    public void printRankingList(User user) throws SQLException {
        int tier_id = 1;
        while (tier_id <= 7) {
            printByUserByTier(user.getUser_id(), tier_id);
            tier_id++;
        }
    }

    // used for printing purpose
    public String getCivName(int civ_id) throws SQLException {
        ResultSet rs = exeQuery("SELECT name FROM civbalance.civ WHERE civ_id = " + civ_id);
        rs.next();
        return rs.getString("name");
    }

    // used for printing purpose
    public String getLeaderName(int civ_id) throws SQLException {
        ResultSet rs = exeQuery("SELECT leader FROM civbalance.civ WHERE civ_id = " + civ_id);
        rs.next();
        return rs.getString("leader");
    }

    // used for printing purpose
    public String getTierName(int tier_id) throws SQLException {
        ResultSet rs = exeQuery("SELECT name FROM civbalance.tier WHERE tier_id = " + tier_id);
        rs.next();
        return rs.getString("name");
    }

    private ResultSet exeQuery(String requete) {
        RequeteSql RS = new RequeteSql();
        return RS.executeQuery(requete);
    }
}
