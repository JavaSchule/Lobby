package net.byteexception.netcode.lobby.storage.mongo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import net.byteexception.netcode.lobby.LobbyPlugin;
import net.byteexception.netcode.lobby.storage.Credential;
import org.bson.Document;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;


/**
 *
 * @author Mike
 */
public class MongoHandler {

    private MongoConnector connector;
    private Credential credential;
    private MongoCollection<Document> collection;

    public MongoHandler(MongoConnector mongoConnector, Credential credential) {
        this.connector = mongoConnector;
        this.credential = credential;
    }

    public void open(String collection) {
        this.connector.connect(credential);
        this.collection = connector.getDatabase().getCollection(collection);
    }

    public void close() {
        this.connector.disconnect();
    }

    public void updateAsync(String field,String value,String nextValue)
    {
        LobbyPlugin.getInstance().getExecutorService().execute(()-> {
            update(field,value,nextValue);
        });
    }

    public void update(String field,String value,String nextValue) {
        collection.updateOne(Filters.eq(field,value), Updates.set(field,nextValue));
    }

    public void insertAsync(Document document) {
       LobbyPlugin.getInstance().getExecutorService().execute(() ->{
           insert(document);
       });
    }

    public void insert(Document document) {
        collection.insertOne(document);
    }

    public Future<Document> getDocumentAsnyc(String field,String  value) {
        return LobbyPlugin.getInstance().getExecutorService().submit(new Callable<Document>() {
            @Override
            public Document call() throws Exception {
                return getDocument(field,value);
            }
        });
    }

    public Document getDocument(String field,String value) {
        return collection.find(Filters.eq(field,value)).first();
    }

    public FindIterable<Document> getDocuments(String field,String value) {
        return collection.find(Filters.eq(field,value));
    }

}
