public class TreePostOrder {

    public static void postOrder(MyTreeNode node){

        if(node!=null){
            for(MyTreeNode n : node.children()){
                postOrder(n);
            }
            if(node.getSize() == 0){
                System.out.println(node.element()+"="+node.sumChild()+"KB");
                node.setSize(node.sumChild());
            }
        }
    }

    public static void main(String[] args) {
        MyTree tree = new MyTree();

        MyTreeNode root = tree.addRoot("cs16/");

        MyTreeNode hw = tree.addNode("homeworks/");
        MyTreeNode program = tree.addNode("programs/");
        MyTreeNode todo = tree.addNode("todo.txt",1);
        MyTreeNode h1c = tree.addChild(hw,"h1c.doc",3);
        MyTreeNode h1nc = tree.addChild(hw,"h1nc.doc",2);
        MyTreeNode ddr = tree.addChild(program,"DDR.java",10);
        MyTreeNode stock = tree.addChild(program,"Stocks.java",25);
        MyTreeNode robot = tree.addChild(program,"Robot.java",20);

        postOrder(tree.root());
    }

}
