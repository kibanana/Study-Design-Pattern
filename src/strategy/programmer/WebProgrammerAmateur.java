package strategy.programmer;

public class WebProgrammerAmateur extends Programmer {
    public WebProgrammerAmateur() {
        ClientSide c = new WebClientSideAdvanced();
        ServerSide s = new WebServerSide();
        setClient(c);
        setServer(s);
    }

    @Override
    public String getAllSkills() {
        return getClientProgrammingSkills() + " / " + getServerProgrammingSkills();
    }
}
