package net.byteexception.netcode.lobby.storage.mongo;

import com.google.gson.Gson;
import org.bson.Document;

import java.io.Serializable;


/**
 *
 * @author Mike
 */
public class MongoSerializer {

    private static final Gson GSON = new Gson();

    public Document serialize(Serializable serializable) {
        return Document.parse(GSON.toJson(serializable));
    }

    public <E> E deserialize(Document document,Class<E> clazz) {
        return GSON.fromJson(document.toJson(), clazz);
    }

}
