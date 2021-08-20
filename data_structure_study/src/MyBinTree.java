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
        // 즉 자식 두개를 붙이려고 하는데 이미 자식이 있는 노드면 오류처리를 내자@
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

    public Boolean idRoot(MyBinNode v){
        return super.root() == v;
    }

    public Boolean isInternal(MyBinNode v){
        return super.children(v) == null;
    }

}
