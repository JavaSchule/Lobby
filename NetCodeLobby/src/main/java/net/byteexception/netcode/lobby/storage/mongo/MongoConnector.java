package net.byteexception.netcode.lobby.storage.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
import net.byteexception.netcode.lobby.storage.Credential;
import net.byteexception.netcode.lobby.storage.DatabaseConnector;


/**
 * Class for MongoDB Connector
 *
 * @author Mike
 */
public class MongoConnector implements DatabaseConnector {

    private MongoClient client;
    private MongoDatabase database;

    @Override
    public void connect(Credential credential) {
        if (!isConnected()) {
            this.client = new MongoClient(credential.getHostname(), credential.getPort());
            MongoCredential.createCredential(credential.getUser(), credential.getDatabase(), credential.getPassword().toCharArray());
            this.database = client.getDatabase(credential.getDatabase());
        }
    }

    @Override
    public void disconnect() {
        if(isConnected()) {
            client.close();
        }
    }

    @Override
    public boolean isConnected() {
        return client!=null&&database!=null;
    }

    public MongoClient getClient() {
        return client;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
