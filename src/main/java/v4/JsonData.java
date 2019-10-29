package v4;

public class JsonData {
    private String name;
    private int id;
    private Boolean userControlSetTop;
    private int courseId;
    private int parentChapterId;
    private int order;
    private int visible;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getUserControlSetTop() {
        return userControlSetTop;
    }

    public void setUserControlSetTop(Boolean userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
    public String toString(){
        return this.getName()+" "+this.getUserControlSetTop()+" "+this.getCourseId()+" "
                +this.getId()+" "+this.getParentChapterId()+" "+this.getVisible()+" "+this.getOrder();
    }
}
