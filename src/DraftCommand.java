package commands;

public class DraftCommand extends Commands {

//    Last part of the menu not done, WIP

    public void executeCommand(User user) {
        System.out.println("We are in " + this.getCommandName() + " and it's the option number " + this.getCommandNb());
    }

    @Override
    public void setCommandName() {
        super.setCommandName("draft");
    }

    @Override
    public void setCommandNb() {
        super.setCommandNb(3);
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
