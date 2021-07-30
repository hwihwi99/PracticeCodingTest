import java.util.ArrayList;

public class MyTreeNode {
    // 현재 내 노드의 저장된 데이터
    private Object element;
    // 내 노드의 부모 노드 (부모는 단 하나)
    private MyTreeNode parent;

    private int size;
    // 내 노드의 자식 노드들 (자식은 여러개 있을 수 있어)
    private ArrayList<MyTreeNode> children;

    MyTreeNode(){
        element = null;
        size = 0;
        parent = null;
        children = null;
    }

    MyTreeNode(Object e){
        element = e;
        size = 0;
        parent = null;
        children = null;
    }

    MyTreeNode(Object e, int s){
        element = e;
        size = s;
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

    // 현재 내 노드의 파일 사이즈 확인
    public int getSize() {return this.size;}

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

    // 현재 노드 사이즈 값 지정
    public void setSize(int size){
        this.size = size;
    }

    // 현재 자식 노드 값 다 더하기
    public int sumChild(){
        int sum = 0;
        for(MyTreeNode n : this.children){
            sum += n.getSize();
        }
        return sum;
    }
}
