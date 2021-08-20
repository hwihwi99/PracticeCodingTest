public class MyBinNode extends MyNode {
    public MyBinNode(){
        super();
    }

    public MyBinNode(Object e){
        super(e);
    }

    // 2진트리.. -> 왼쪽은 0번, 오른쪽은 1번 인덱스!

    // 그 궁금한게... 그 ArrayList = new ArrayList 이런거 안해주고 어케 사용해...??

    public MyBinNode left(){
        return (MyBinNode) super.children().get(0);
    }

    public MyBinNode right(){
        return (MyBinNode) super.children().get(1);
    }

    public void setLeft(MyBinNode v){
        super.children().set(0,v);
    }

    public void setRight(MyBinNode v){
        super.children().set(1,v);
    }
}
