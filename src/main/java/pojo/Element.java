package pojo;

public class Element {

    //TODO
//    Category category;
//    SubCategory subCategory;

    String category;
    String subCategory;

    public Element(String category, String subCategory) {
        this.category = category;
        this.subCategory = subCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
}
