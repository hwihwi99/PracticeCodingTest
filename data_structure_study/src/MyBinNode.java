import java.util.ArrayList;

public class MyBinNode extends MyNode{
    private MyNode parent;
    private ArrayList children;
    private int cost;
    private Object element;

    public MyBinNode(){
        super();
    }

    public MyBinNode(MyNode parent, int cost, Object element){
        super(parent,cost,element);
    }

    public MyBinNode left(){
        return (MyBinNode) getChildren().get(0);
    }

    public MyBinNode right(){
        return (MyBinNode) getChildren().get(1);
    }

    public void setLeft(MyBinNode v){
        getChildren().set(0,v);
    }

    public void setRight(MyBinNode v){
        getChildren().set(1,v);
    }
}
