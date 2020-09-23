package commands;

public abstract class Commands implements CommandInterface {

    private String commandName;
    private int     commandNb;

    public ResultSet exeQuery(String requete) {
        RequeteSql RS = new RequeteSql();
        return RS.executeQuery(requete);
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public int getCommandNb() {
        return commandNb;
    }

    public void setCommandNb(int commandNb) {
        this.commandNb = commandNb;
    }

    public void initializeCommand() {
        this.setCommandName();
        this.setCommandNb();
    }
}
