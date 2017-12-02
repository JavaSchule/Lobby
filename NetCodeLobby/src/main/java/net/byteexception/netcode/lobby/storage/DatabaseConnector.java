package net.byteexception.netcode.lobby.storage;

public interface DatabaseConnector {

    void connect(Credential credential);

    void disconnect();

    boolean isConnected();

}
