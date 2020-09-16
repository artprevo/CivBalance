public class DraftCommand extends Commands implements CommandInterface {
    public void executeCommand() {
        System.out.println("We are in " + this.getCommandName() + " and it's the option number " + this.getCommandNb());
    }

    @Override
    public void setCommandName() {
        super.setCommandName("draft");
    }

    @Override
    public void setCommandNb() {
        super.setCommandNb(4);
    }

    @Override
    public void initializeCommand() {
        this.setCommandName();
        this.setCommandNb();
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
