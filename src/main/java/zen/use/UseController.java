package zen.use;

import static spark.Spark.*;
import com.google.gson.Gson;

import zen.StandardResponse;
import zen.StatusResponseEnum;
import zen.use.models.Use;

public final class UseController {
    private UseService useService;

    public UseController(final UseService useService) {
        this.useService = useService;
    }

    public void buildRoute() {
        post("/add", (req, res) -> this.postUse(req.body()));
    }

    public String postUse(String useStringValue) {
        try {
            Gson gson = new Gson();
            Use use = gson.fromJson(useStringValue, Use.class);
            this.useService.createUse(use);
            return new Gson().toJson(new StandardResponse(StatusResponseEnum.SUCCESS));
        } catch (Exception e) {
            return new Gson().toJson(new StandardResponse(StatusResponseEnum.ERROR, new Gson().toJson(e.getMessage())));
        }
    }
}