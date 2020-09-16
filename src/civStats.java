public class civStats extends Civ{
    private int cultureScore;
    private int simScore;
    private int warScore;
    private int navalScore;

    public civStats (int cultureScore, int sS, int wS, int nS) {
        this.cultureScore = cultureScore;
        simScore = sS;
        warScore = wS;
        navalScore = nS;
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
}
