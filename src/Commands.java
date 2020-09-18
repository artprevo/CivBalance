public abstract class Commands implements CommandInterface{

    private String commandName;
    private int     commandNb;

    public Commands(){
        this.initializeCommand();
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
