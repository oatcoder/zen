package zen.use.models;

public class Use {
    private String description;
    private String title;

    public Use(String description, String title) {
        this.setDescription(description);
        this.setTitle(title);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}