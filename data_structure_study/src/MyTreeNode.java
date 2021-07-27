import java.util.ArrayList;

public class MyTreeNode {
    // 현재 내 노드의 저장된 데이터
    private Object element;
    // 내 노드의 부모 노드 (부모는 단 하나)
    private MyTreeNode parent;
    // 내 노드의 자식 노드들 (자식은 여러개 있을 수 있어)
    private ArrayList<MyTreeNode> children;

    MyTreeNode(){
        element = null;
        parent = null;
        children = null;
    }

    MyTreeNode(Object e){
        element = e;
        parent = null;
        children = null;
    }

    // 현재 내 노드의 데이터 반환
    public Object element(){
        return this.element;
    }

    // 현재 내 노드의 부모노드 반환
    public MyTreeNode parent(){
        return this.parent;
    }

    // 현재 내 노드의 자식 노드들을 리스트로 반환
    public ArrayList<MyTreeNode> children(){
        return this.children;
    }

    // 현재 노드가 자식 노드를 몇개나 가지고 있는지 확인
    public int degree(){
        return children.size();
    }

    // 현재 노드의 데이터 값 설정
    public void setElement(Object e){
        this.element = e;
    }

    // 현재 노드의 부모 값 지정
    public void setParent(MyTreeNode p){
        this.parent = p;
    }

    // 현재 노드의 자식 값 지정
    public void setChildren(ArrayList c){
        this.children = c;
    }
}
