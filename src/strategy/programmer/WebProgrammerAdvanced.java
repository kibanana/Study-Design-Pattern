package strategy.programmer;

public class WebProgrammerAdvanced extends Programmer {
    public WebProgrammerAdvanced() {
        ClientSide c = new WebClientSideAdvanced();
        ServerSide s = new WebServerSideAdvanced();
        setClient(c);
        setServer(s);
    }

    @Override
    public String getAllSkills() {
        return getClientProgrammingSkills() + " / " + getServerProgrammingSkills();
    }
}
