import java.util.ArrayList;

public class MyBinNode extends MyNode{

    public MyBinNode(){
        super();
    }

    public MyBinNode(MyNode parent, int cost, Object element){
        super(parent,cost,element);
    }

    public MyBinNode(Object e){
        super(e);
    }
    public MyBinNode left(){
        return (MyBinNode) super.getChildren().get(0);
    }

    public MyBinNode right(){
        return (MyBinNode) super.getChildren().get(1);
    }

    public void setLeft(MyBinNode v){
        super.getChildren().set(0,v);
    }

    public void setRight(MyBinNode v){
        super.getChildren().set(1,v);
    }
}
