import java.util.ArrayList;

public class MyTrees {
    private MyTreeNode root;
    private int Totalsize;

    MyTrees(){
        root = null;
        Totalsize = 0;
    }
    MyTrees(Object e){
        root = new MyTreeNode(e);
        root.setChildren(new ArrayList());
        Totalsize = 1;
    }

    // 트리의 전체 노드의 갯수
    public int size(){
        return Totalsize;
    }

    // 현재 트리의 root 노드
    public MyTreeNode root(){
        return this.root;
    }

    // 해당 노드의 자식 노드 리스트 반환환
    public ArrayList children (MyTreeNode v){
        return v.children();
    }

    // child가 0이면 true
    public boolean isExternal(MyTreeNode v){
        return v.children().size() == 0;
    }


    //주의!! 모든 첫 생성한 노드에는 child노드들을 담을 공간이 필요하다! 잊지말기

    // 루트노드 만들어서 추가 -> 트리에 첫 노드 삽입, 루트 노드 생성
    public MyTreeNode addRoot(Object e){
        root = new MyTreeNode(e);
        root.setChildren(new ArrayList());
        Totalsize = 1;
        return root;
    }

    // 루트 노드에 자식 노드로 추가하기
    public MyTreeNode addNode(Object e){
        MyTreeNode newNode = new MyTreeNode(e);
        newNode.setChildren(new ArrayList());
        root.children().add(newNode);
        Totalsize++;
        return newNode;
    }

    // 루트 노드에 자식 노드로 추가하기
    public MyTreeNode addNode(Object e, int size){
        MyTreeNode newNode = new MyTreeNode(e,size);
        newNode.setChildren(new ArrayList());
        root.children().add(newNode);
        Totalsize++;
        return newNode;
    }

    public MyTreeNode addChild(MyTreeNode v, Object e){
        MyTreeNode newNode = new MyTreeNode(e);
        newNode.setChildren(new ArrayList());
        v.children().add(newNode);
        Totalsize++;
        return newNode;
    }

    public MyTreeNode addChild(MyTreeNode v, Object e, int size){
        MyTreeNode newNode = new MyTreeNode(e,size);
        newNode.setChildren(new ArrayList());
        v.children().add(newNode);
        Totalsize++;
        return newNode;
    }

    public MyTreeNode addChild(MyTreeNode v, int i, Object e){
        MyTreeNode newNode = new MyTreeNode(e);
        newNode.setChildren(new ArrayList());
        v.children().add(i,newNode);
        Totalsize++;
        return newNode;
    }

    public MyTreeNode setchild(MyTreeNode v, int i, Object e) {
        MyTreeNode changeNode = new MyTreeNode(e);
        changeNode.setChildren(new ArrayList());
        v.children().set(i,changeNode);
        return changeNode;
    }

    public MyTreeNode removeChild(MyTreeNode v, int i){
        MyTreeNode delete = v.children().remove(i);
        Totalsize--;
        return delete;
    }

}
