package zen.use;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import zen.repository.MongoData;
import zen.use.models.Use;

public class UseService {
    private MongoData mongoData;

    public UseService(MongoData mongoData) {
        this.mongoData = mongoData;
    }

    public Document createUse(Use use) {
        MongoCollection<Document> table = this.mongoData.getTable("uses");
        Document newDoc = Document.parse(new Gson().toJson(use));
        table.insertOne(newDoc);
        return newDoc;
    }
}