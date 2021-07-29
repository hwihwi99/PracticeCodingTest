public class Tree_Postorder {
    public static void preOrder(MyTreeNode node){
        if(node != null){
            System.out.println(node.element());
            if(node.children()!=null){
                System.out.print("   ");
                for(MyTreeNode child : node.children()) {
                    System.out.print("   ");
                    preOrder(child);
                }
            }
        }
    }
    public static void main(String[] args) {
        MyTree root = new MyTree();

        MyTreeNode MMF = root.addRoot("Make Money Fast!");

        MyTreeNode motivations = root.addNode("1. Motivations");
        MyTreeNode methods = root.addNode("2. Methods");
        MyTreeNode references = root.addNode("References");

        MyTreeNode greed = root.addChild(motivations,"1.1 Greed");
        MyTreeNode avidity = root.addChild(motivations,"1.2 Avidity");

        MyTreeNode stock = root.addChild(methods,"2.1 Stock Fraud");
        MyTreeNode ponzi = root.addChild(methods,"2.2 Ponzi Scheme");
        MyTreeNode bank = root.addChild(methods,"2.3 Bank Robbery");

        preOrder(root.root());

    }
}
