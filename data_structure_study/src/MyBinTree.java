import java.util.ArrayList;
public class MyBinTree extends MyTree{
    public class TwoChildrenException extends Exception{
        public TwoChildrenException(String message) {
            super(message);
        }
    }
    public class NotExternalException extends Exception {
        public NotExternalException(String message) {
            super(message);
        }
    }
    MyBinTree(){
        super();
    }
    MyBinTree(Object e){
        super(e);
        super.root().children().add(null);
        super.root().children().add(null);
    }

    public boolean isEmpty(){
        return super.size() == 0;
    }

    public boolean isRoot(MyBinNode v){
        return v.parent() == null;
    }

    // 자식이 있으면 true
    public boolean isInternal(MyBinNode v){
        return !isExternal(v);
    }

    // 자식이 없으면 true
    public boolean isEXternal(MyBinNode v){
        if(!hasLeft(v)&&!hasRight(v))
            return true;
        return false;
    }

    public MyBinNode root(){
        return (MyBinNode) super.root();
    }

    public MyBinNode parent(MyBinNode v){
        return (MyBinNode) v.parent();
    }

    public MyBinNode left(MyBinNode v){
        return (MyBinNode) v.children().get(0);
    }

    public MyBinNode right(MyBinNode v){
        return (MyBinNode) v.children().get(1);
    }

    public boolean hasLeft(MyBinNode v){
        return left(v) != null;
    }

    public boolean hasRight(MyBinNode v){
        return right(v) != null;
    }

    public MyBinNode addRoot(Object e){
        MyBinNode newRoot = (MyBinNode) super.addRoot(e);
        super.root().children().add(null);
        super.root().children().add(null);
        return newRoot;
    }

    public MyBinNode addNode(Object e){
        MyBinNode newNode = null;
        // 만약 자식이 둘 다 차있다면
        if(hasRight((MyBinNode) super.root()) && hasLeft((MyBinNode)super.root())){
            System.out.println("CHILD SPACE IS ALREADY FULL");
        }
        // 왼쪽 자식만 있다면
        else if(hasLeft((MyBinNode)super.root())){
            // 우선 오른쪽 노드를 지우고
            super.removeChild(super.root(), 1);

            newNode = (MyBinNode) super.addNode(e);
            newNode.children().add(null);
            newNode.children().add(null);
        }
        // 오른쪽 자식만 있다면
        else if (hasRight((MyBinNode) super.root())){
            // 일단 오른쪽에 있는 애를 임시로 저장하고 자식에서 지운다.
            MyBinNode temp = (MyBinNode) (super.removeChild(super.root(),1));
            // 왼쪽 자식도 지워준다.
            super.removeChild(super.root(),0);

            newNode = (MyBinNode) super.addNode(e);
            newNode.children().add(null);
            newNode.children().add(null);

            MyBinNode reNode = (MyBinNode) super.addNode(temp);
            reNode.children().add(null);
            reNode.children().add(null);
        }
        // 둘다 없다면
        else {
            super.removeChild(super.root(),0);
            super.removeChild(super.root(),0);

            // 왼쪽에 넣어주고
            newNode = (MyBinNode) super.addNode(e);
            newNode.children().add(null);
            newNode.children().add(null);

            // 오른쪽에 빈 공간하나 만들어주기
            super.root().children().add(null);
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

    public Object replace(MyBinNode v, Object e){
        Object temp = v.element();
        v.setElement(e);
        return temp;
    }

    public MyBinNode remove(MyBinNode v) throws TwoChildrenException {
        // 지울 노드의 부모노드를 체크한다.
        MyBinNode parent = (MyBinNode) v.parent();

        // 지울 노드가 부모의 왼쪽인지, 오른쪽인지 판단한다.
        int index = 0;
        if(left(parent) == v)
            index = 0;
        else if(right(parent)==v)
            index = 1;

        // 삭제할 노드의 자식이 두개라면 --> 삭제 불가!
        if(hasLeft(v)&&hasRight(v)){
            throw new TwoChildrenException("TwoChildrenException !!");
        }
        // 삭제한 노드의 왼쪽에만 자식이 있다면?
        else if(hasLeft(v)){
            MyBinNode children = (MyBinNode) v.children().get(0);
            parent.children().set(index,children);
            children.setParent(parent);
        }
        // 삭제할 노드의 오른쪽에만 자식이 있다면?
        else if(hasRight(v)){
            MyBinNode children = (MyBinNode) v.children().get(1);
            parent.children().set(index,children);
            children.setParent(parent);
        }
        // 삭제할 노드가 자식이 없다면?
        else {
            // 부모에서 현재 삭제할 노드의 인덱스를 파악했으므로 그 노드를 null로 바꿔주면서 삭제한다.
            parent.children().set(index,null);
        }
        // 삭제한 노드를 반환한다.
        return v;
    }

    public void attach (MyBinNode v, MyBinNode t1, MyBinNode t2) throws NotExternalException {
        //external 노드에다가 한번에 t1,t2 붙이기
        if(isExternal(v)){
            insertLeft(v,t1.element());
            insertLeft(v,t2.element());
        }else{
            throw new NotExternalException("NotExternalException!!");
        }
    }

    public void preOrder(MyBinNode v){
        System.out.println(v.element()+" ");

        if (hasLeft(v))
            preOrder(left(v));

        if (hasRight(v))
            preOrder(right(v));
    }

    public void inOrder(MyBinNode v){
        if (hasLeft(v)) {
            System.out.println("(");
            inOrder(left(v));
        }

        System.out.println(v.element());

        if (hasRight(v)) {
            inOrder(right(v));
            System.out.println(")");
        }
    }

    public void postOrder(MyBinNode v){
        if (hasLeft(v))
            postOrder(v);

        if (hasRight(v))
            postOrder(v);

        System.out.println(v.element());
    }
}
