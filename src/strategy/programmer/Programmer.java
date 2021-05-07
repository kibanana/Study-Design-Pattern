package strategy.programmer;

public abstract class Programmer {
    private ClientSide client;
    private ServerSide server;

    public Programmer() {}

    public ClientSide getClient() {
        return client;
    }

    public void setClient(ClientSide client) {
        this.client = client;
    }

    public ServerSide getServer() {
        return server;
    }

    public void setServer(ServerSide server) {
        this.server = server;
    }

    public String getServerProgrammingSkills() {
        return server.getServerProgrammingSkills();
    }

    public String getClientProgrammingSkills() {
        return client.getClientProgrammingSkills();
    }

    public abstract String getAllSkills();
}
