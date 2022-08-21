package zen.repository;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClient;

import org.bson.Document;

import com.mongodb.MongoClientSettings;

/**
 * MongoData
 */
public final class MongoData {
    private static MongoData INSTANCE;
    private String info = "Initial info class";

    private MongoData() {
    }

    public synchronized static MongoData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MongoData();
        }

        return INSTANCE;
    }

    private MongoClient getMongoClient() {
        ConnectionString connString = new ConnectionString("mongodb+srv://devUser:h2GHmmQBZVuwduGE@clusteralpha-dpx70.gcp.mongodb.net/zen?w=majority");
        MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connString).retryWrites(true).build();
        return MongoClients.create(settings);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public MongoCollection<Document> getTable(String dbTableName){
        return this.getMongoClient().getDatabase("zen").getCollection(dbTableName);
    }
}