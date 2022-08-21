package zen;

import static spark.Spark.*;
import java.util.logging.Logger;

import zen.repository.MongoData;
import zen.use.UseController;
import zen.use.UseService;

public class Endpoints {
    private final static Logger LOGGER = Logger.getLogger(Endpoints.class.getName());

    public static void main(String[] args) {
        MongoData mongoData = MongoData.getInstance();
        UseService useService = new UseService(mongoData);
        UseController useController = new UseController(useService);

        path("/api", () -> {
            before("/*", (q, a) -> {
                LOGGER.info("Received api call");
                a.type("application/json");
            });
            path("/uses", () -> {
                useController.buildRoute();
            });
            path("/comments", () -> {
                get("/add", (req, res) -> "adding a comment is not in place yet");
            });
        });
    }
}