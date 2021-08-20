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
    public MyBinTree(){
        super();
    }
    public
}
