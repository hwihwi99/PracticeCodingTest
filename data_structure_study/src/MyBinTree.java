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
        return v.parent() == null;
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
        return v.children().get(0)!=null;
    }

    public boolean hasRight(MyBinNode v){
        return v.children().get(1)!=null;
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
            System.out.println("모든 루트 자식이 차있습니다.");
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
        }else{
            System.out.println("No children");
            super.removeChild(super.root(),0);
            super.removeChild(super.root(),0);

            newNode = (MyBinNode) super.addNode(e);
            newNode.children().add(null);
            newNode.children().add(null);


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

    public Object replace (MyBinNode v, Object e){
        Object temp = v.element();
        v.setElement(e);
        // 대체되고 없어질 아이 리턴하기
        return temp;
    }

    public MyBinNode remove(MyBinNode v) throws TwoChildrenException{

        // 지우려고 하는 것의 노드의 부모를 찾아서
        MyBinNode parent = (MyBinNode) v.parent();

        int idx = 0;
        // 지울 애가 부모의 왼쪽 노드였다면 0, 오른쪽 노드였다면 1을 저장한다.
        if(this.left(parent) == v){
            idx = 0;
        }else{
            idx = 1;
        }

        // 자식이 모두 있을 때
        if(hasRight(v) && hasLeft(v)){
            throw  new TwoChildrenException("TwoChildrenException");
        }
        // 왼쪽에만 자식이 있을 때
        else if(this.hasLeft(v)){
            MyBinNode children = (MyBinNode) v.children().get(0);
            parent.children().set(idx,children);
            children.setParent(parent);
        }else if(this.hasRight(v)){
            MyBinNode children = (MyBinNode) v.children().get(1);
            parent.children().set(idx,children);
            children.setParent(parent);
        }
        // 자식이 모두 없을 때
        else{
            // 원래 부모의 자식에서 그 노드를 빼주면 됩니다.
            parent.children().set(idx,null);
        }
        return v;
    }
    public void attach(MyBinNode v, MyBinNode t1, MyBinNode t2) throws NotExternalException{
        if(this.isExternal(v)){
            this.insertLeft(v,t1.element());
            this.insertRight(v,t2.element());
        }else {
            throw new NotExternalException("We can't attach that Node");
        }
    }

    public void preOrder(MyBinNode v){
        System.out.println(v.element()+" ");

        if(this.hasLeft(v))
            preOrder(this.left(v));
        if(this.hasRight(v))
            preOrder(this.right(v));
    }

    public void inOrder(MyBinNode v){
        if(hasLeft(v)){
            System.out.print("(");
            inOrder(this.left(v));
        }
        System.out.print(v.element());
        if(hasRight(v)){
            inOrder(this.right(v));
            System.out.print(")");
        }
    }

    public int PostOrder(MyBinNode v) {

        int value = 0;

        if (this.isExternal(v)) {
            return Integer.parseInt(v.element().toString());
        }
        else{
            int x = PostOrder(v.left());
            int y = PostOrder(v.right());


            switch (v.element().toString()){
                case "+":
                    value = x+y;
                    break;

                case "X":
                    value = x*y;
                    break;

                case "*":
                    value = x*y;
                    break;

                case "-":
                    value = x-y;
                    break;
            }
            return value;
        }
    }
}
