import java.util.ArrayList;

public class MyNode {
    private MyNode parent;
    private ArrayList children;
    private int cost;
    private Object element;

    public MyNode(MyNode parent, int cost, Object element) {
        this.parent = parent;
        this.cost = cost;
        this.element = element;
        this.children = new ArrayList();
    }

    public MyNode(){

    }

    public MyNode getParent() {
        return parent;
    }

    public void setParent(MyNode parent) {
        this.parent = parent;
    }

    public ArrayList getChildren() {
        return children;
    }

    public void setChildren(ArrayList children) {
        this.children = children;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }
}
