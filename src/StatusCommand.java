public class StatusCommand extends Commands implements CommandInterface {
    public void executeCommand() {
        System.out.println("We are in " + this.getCommandName() + " and it's the option number " + this.getCommandNb());
    }

    @Override
    public void setCommandName() {
        super.setCommandName("status");
    }

    @Override
    public void setCommandNb() {
        super.setCommandNb(1);
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
