import java.util.ArrayList;
public class MyBinTree extends MyTree{
    // 예외처리 (Exception) : 오류가 발생했을 때 그 처리를 예외에게 맡기는 것
    public class TwoChildrenException extends Exception{
        // 자식이 이미 두명이면..
        // 즉 자식이 있는데 그 노드를 지우려고 한다!
        TwoChildrenException(String msg){
            super(msg);
        }
    }

    public class NotExternalException extends Exception{
        // 해당 노드가 종단 노드가 아니라면.. 오류!
        // 즉 자식 두개를 붙이려고 하는데 이미 자식이 있는 노드면 오류처리를 내자
        NotExternalException(String msg){
            super(msg);
        }
    }

    // 빈 트리 생성
    public MyBinTree(){
        super();
    }

    // 트리 생성과 동시에 루트노드 추가
    public MyBinTree(Object e){
        super(e);
        // 루트 노드가 생겼지만 아직 자식이 없지! 그래서 null로 크기 2짜리 배열을 만든다.
        super.root().children().add(null);
        super.root().children().add(null);
    }

    public Boolean isEmpty(){
        return super.size() == 0;
    }

    public Boolean isRoot(MyBinNode v){
        return super.root() == v;
    }

    public MyBinNode root(){
        return (MyBinNode) super.root();
    }

    public MyBinNode parent(MyBinNode v){
        return (MyBinNode) v.parent();
    }

    public MyBinNode left (MyBinNode v){
        return (MyBinNode) v.children().get(0);
    }

    public MyBinNode right (MyBinNode v){
        return (MyBinNode) v.children().get(1);
    }

    public boolean hasLeft(MyBinNode v){
        return left(v) == null;
    }

    public boolean hasRight(MyBinNode v){
        return right(v) == null;
    }

    // 자식이 없으면 참, 있으면 거짓
    public boolean isExternal(MyBinNode v){
        if(!hasRight(v) && !hasLeft(v))
            return true;
        else return false;
    }

    // isExternal의 반대버전!
    // 자식이 없으면 거짓. 있으면 참
    public boolean isInternal(MyBinNode v){
        return !isExternal(v);
    }

    public MyBinNode addRoot(Object e){
        MyBinNode root = (MyBinNode) super.addRoot(e);

        super.root().children().add(null);
        super.root().children().add(null);

        return root;
    }

    // 루트에 자식 넣기
    public MyBinNode addNode(Object e){
        MyBinNode newNode = null;

        // 이미 자식이 모두 있을 때
        if (hasLeft((MyBinNode) super.root()) && hasRight((MyBinNode) super.root())) {
            System.out.println("모든 자식이 차있습니다.");
        }

        // 왼쪽 자식만 있을 때
        else if (hasLeft((MyBinNode) super.root())){
            System.out.println("오른쪽에 자식을 넣겠습니다");
            super.removeChild(super.root(),1);

            newNode = (MyBinNode) super.addNode(e);
            newNode.children().add(null);
            newNode.children().add(null);
        }

        // 오른쪽 자식만 있을 때
        else if (hasRight((MyBinNode) super.root())){
            System.out.println("오른쪽에 자식을 넣겠습니다");

            // 오른쪽에 있던 것 임시 옮기기
            MyBinNode temp = (MyBinNode) super.removeChild(super.root(),1);
            super.removeChild(super.root(),0);

            newNode = (MyBinNode) super.addNode(e);
            newNode.children().add(null);
            newNode.children().add(null);

            MyBinNode reNode = (MyBinNode) super.addNode(temp);
            reNode.children().add(null);
            reNode.children().add(null);
        }

        return newNode;
    }

    public MyBinNode insertLeft(MyBinNode v, Object e){
        MyBinNode newNode = null;

        if(!hasLeft(v)){
            newNode = (MyBinNode) super.setChild(v,0,e);
            newNode.children().add(null);
            newNode.children().add(null);
        }
        return newNode;
    }

    public MyBinNode insertRight(MyBinNode v, Object e){
        MyBinNode newNode = null;

        if(!hasRight(v)){
            newNode = (MyBinNode) super.setChild(v,1,e);
            newNode.children().add(null);
            newNode.children().add(null);
        }
        return newNode;
    }

    public Object replace (MyBinNode v, Object e){
        Object temp = v.element();
        v.setElement(e);
        // 대체되고 없어질 아이 리턴하기
        return temp;
    }

//    public MyBinNode remove(MyBinNode v) throws TwoChildrenException{
//        if(hasRight(v) && hasLeft(v)){
//            throw  new TwoChildrenException("TwoChildrenException");
//        }
//    }
}
