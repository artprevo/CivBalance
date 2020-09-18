package commands;

public interface CommandInterface {
    String getCommandName();
    void setCommandName();
    int getCommandNb();
    void setCommandNb();
    void initializeCommand();
}
