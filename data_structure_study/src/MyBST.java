import java.util.ArrayList;

public class MyBST extends MyBinTree{
    public MyBST(){
        // 루트가 null이고 총 크기가 0인 트리 생성
        super();
    }

    public MyBST(Object e){
        // 루트에 e를 넣고 크기가 1인 트리 생성
        super(e);
    }

    private MyBinNode nextNode(MyBinNode v){
        // 중위 순회를 하면서 v노드의 다음번 노드를 반환
        MyBinNode currNode = v;
        if(super.hasRight(currNode)) {
            currNode = currNode.right();
            while(!super.isExternal(currNode) && super.hasLeft(currNode))
                currNode = currNode.left();
            return currNode;
        }

        return null;
    }

    public Object find(Object k){
        MyBinNode currentNode = super.root();
        while (currentNode != null){
            if((Integer)k < (Integer) currentNode.element()){
                currentNode = currentNode.left();
            }else if ((Integer)k > (Integer) currentNode.element()){
                currentNode = currentNode.right();
            }else{
                return currentNode.element();
            }
        }
        return null;
    }

    public ArrayList findAll(Object k){
        ArrayList<Object> find = new ArrayList<>();
        MyBinNode currentNode = super.root();
        while (currentNode!=null){
            if((Integer)k < (Integer) currentNode.element()){
                currentNode = currentNode.left();
            }else if ((Integer)k > (Integer) currentNode.element()){
                currentNode = currentNode.right();
            }else{
                // 같으면 왼쪽에다가 삽입하기
                find.add(currentNode.element());
                currentNode = currentNode.left();
            }
        }
        return find;
    }

    public Object insert(Object k){
        MyBinNode currentNode = super.root();
        if(currentNode == null){
            super.addRoot(k);
            return k;
        }
        while (true){
            if((Integer) k <= (Integer) currentNode.element()){
                if(currentNode.left()==null){
                    super.insertLeft(currentNode,k);
                    return k;
                }else{
                   currentNode = currentNode.left();
                }
            }else{
                if(currentNode.right()==null){
                    super.insertRight(currentNode,k);
                    return k;
                }else{
                    currentNode = currentNode.right();
                }
            }
        }
    }

    public Object remove(Object k) throws TwoChildrenException{

        MyBinNode currentNode = super.root();

        while (currentNode != null){
            if((Integer)k < (Integer) currentNode.element()){
                currentNode = currentNode.left();
            }else if ((Integer)k > (Integer) currentNode.element()){
                currentNode = currentNode.right();
            }else{
                // 같으면 일단 빠져나와
                break;
            }
        }

        if(currentNode != null){
            // 자식이 둘 다 있거나 루트노드라면
            if(super.hasLeft(currentNode) && super.hasRight(currentNode) || super.isRoot(currentNode)){
                MyBinNode removeNode =  currentNode;
                currentNode = this.nextNode(removeNode);

                // 루트노트라면
                if(super.isRoot(removeNode)){
                    super.addRoot(currentNode.element());
                    super.root().setLeft(removeNode.left());
                    super.root().setRight(removeNode.right());
                }else{
                    currentNode.setLeft(removeNode.left());
                    currentNode.setRight(removeNode.right());
                    currentNode.setParent(removeNode.parent());
                }
                return removeNode.element();
            }else{
                super.remove(currentNode);
                return k;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        int[] keys = new int[] {2, 9, 1, 4, 8, 9};
        MyBST mbst = new MyBST(6);
        for(int k : keys)
            mbst.insert(k);
        mbst.preOrder(mbst.root());
        System.out.println();

        System.out.println("mbst.find(8)   : " + mbst.find(8));
        System.out.println("mbst.find(3)   : " + mbst.find(3));
        System.out.println("mbst.insert(3) : " + mbst.insert(3));
        System.out.println("mbst.insert(7) : " + mbst.insert(7));
        System.out.println("mbst.insert(9) : " + mbst.insert(9));
        System.out.println("mbst.remove(1) : " + mbst.remove(1));
        System.out.println("mbst.remove(4) : " + mbst.remove(4));
        System.out.println("mbst.remove(6) : " + mbst.remove(6));
        System.out.println("mbst.find(3)   : " + mbst.find(3));
        System.out.println("mbst.find(6)   : " + mbst.find(6));
        System.out.println("mbst.findAll(9): " + mbst.findAll(9));


        mbst.inOrder(mbst.root());
        System.out.println();
    }
}
