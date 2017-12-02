package net.byteexception.netcode.lobby.storage;

/**
 *
 * @author Mike
 */
public class Credential {

    private String hostname,database,user,password;
    private int port;

    public Credential(String hostname,int port,String database,String user,String password) {
        this.hostname = hostname;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getHostname() {
        return hostname;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }
}

