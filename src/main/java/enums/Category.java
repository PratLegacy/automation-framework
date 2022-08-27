package enums;

public enum Category {

    ELEMENTS("Elements"),
    FORMS("Forms"),
    ALERTS_FRAMES_WINDOWS("Alerts, Frames & Windows"),
    WIDGETS("Widgets"),
    INTERACTIONS("Interactions"),
    BOOK_STORE_APPLICATION("Book Store Application");

    private final String categoryName;

    Category(String name) {
        this.categoryName = name;
    }
}
