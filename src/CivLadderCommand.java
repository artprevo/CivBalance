public class CivLadderCommand extends Commands implements CommandInterface {
    public void executeCommand() {
        System.out.println("We are in " + this.getCommandName() + " and it's the option number " + this.getCommandNb());
    }

    @Override
    public void setCommandName() {
        super.setCommandName("civ_ladder");
    }

    @Override
    public void setCommandNb() {
        super.setCommandNb(3);
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
