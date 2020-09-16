public class Civ {
    private String civName;
    private String leaderName;
    private int cultureScore;
    private int simScore;
    private int warScore;
    private int navalScore;
    private int globalScore = (cultureScore + simScore + warScore + navalScore) / 4;

    public int getGlobalScore() {
        return globalScore;
    }

    public int getCultureScore() {
        return cultureScore;
    }

    public void setCultureScore(int cultureScore) {
        this.cultureScore = cultureScore;
    }

    public int getSimScore() {
        return simScore;
    }

    public void setSimScore(int simScore) {
        this.simScore = simScore;
    }

    public int getWarScore() {
        return warScore;
    }

    public void setWarScore(int warScore) {
        this.warScore = warScore;
    }

    public int getNavalScore() {
        return navalScore;
    }

    public void setNavalScore(int navalScore) {
        this.navalScore = navalScore;
    }

    public String getCivName() {
        return civName;
    }

    public void setCivName(String civName) {
        this.civName = civName;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }
}
