
public class MyTree {
    private MyNode root;
    public MyTree() {
        this.root = null;
    }
    public MyTree(int cost, Object element) {
        this.root = new MyNode(null, cost, element);
    }
    public MyTree(Object element){
        this.root = new MyNode(element);
    }

    public MyNode root() {
        return this.root;
    }

    public MyNode addChild(MyNode v, int cost, Object element) {
        MyNode newNode = new MyNode(v, cost, element);
        v.getChildren().add(newNode);
        return newNode;
    }

}
