//public class MyBinTree extends MyTree {
//    public class TwoChildrenException extends Exception{}
//    public class NotExternalException extends Exception{}
//    public MyBinTree(){
//        super();
//    }
//
//    public MyBinTree(Object e){
//        super(e);
//        super.root().getChildren().add(null);
//        super.root().getChildren().add(null);
//    }
//
//
//    public boolean isEmpty(){
//        return super.root() == null;
//    }
//
//    public boolean isRoot(MyBinNode v){
//        // 너 루트노드야? == 너 부모 노드 없지??
//        return v.getParent()==null;
//    }
//
//    // 자식이 있니?
//    public boolean isInternal(MyBinNode v){
//        return !isExternal(v);
//    }
//
//    // 자식이 없니?
//    public boolean isExternal(MyBinNode v){
//        if(!hasLeft(v)&&!hasRight(v))
//            return true;
//        return false;
//    }
//
//    public MyBinNode root(){
//        return (MyBinNode) super.root();
//    }
//
//    public MyBinNode parent(MyBinNode v){
//        return (MyBinNode) v.getParent();
//    }
//
//    public MyBinNode left(MyBinNode v){
//        return (MyBinNode) v.getChildren().get(0);
//    }
//
//    public MyBinNode right(MyBinNode v){
//        return (MyBinNode) v.getChildren().get(1);
//    }
//
//    public boolean hasLeft(MyBinNode v){
//        return left(v) != null;
//    }
//
//    public boolean hasRight(MyBinNode v) {
//        return right(v) != null;
//    }
//
//    public MyBinNode addRoot(Object e){
//        MyBinNode newNode = new MyBinNode(e);
//        newNode.setLeft(root().left());
//        newNode.setRight(root().right());
//        root().setParent(newNode);
//        return newNode;
//    }
//
//    // 루트의 자식노드에 값 넣기
//    public MyBinNode addNode(Object e){
//        MyBinNode newNode = null;
//        // 1. 왼쪽, 오른쪽 자식이 모두 있을 때
//
//        // 2. 왼쪽 자식이 있을 때
//
//        // 3. 오른쪽 자식이 있을 때
//
//        // 4. 자식이 모두 없을 때
//
//        return newNode;
//    }
//
//    public MyBinNode insertLeft(MyBinNode v, Object e){
//
//    }
//
//    public MyBinNode insertRight(MyBinNode v, Object e){
//
//    }
//
//    public Object replace(MyBinNode v,Object e){
//
//    }
//
//    public MyBinNode remove(MyBinNode v) throws TwoChildrenException{
//
//    }
//
//    public void attach(MyBinNode v, MyBinNode t1, MyBinNode t2) throws NotExternalException{
//
//    }
//
//    }
