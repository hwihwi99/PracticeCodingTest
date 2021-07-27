public class Tree_1 {
    public static void main(String[] args) {
        MyTree tree = new MyTree();

        MyTreeNode root = tree.addRoot("Computers'R Us");

        MyTreeNode sale = tree.addNode("Sales");
        MyTreeNode manufacture = tree.addNode("Manufacturing");
        MyTreeNode rd = tree.addNode("R&D");

        MyTreeNode US = tree.addChild(sale,0,"US");
        MyTreeNode international = tree.addChild(sale,1,"International");

        MyTreeNode laptop = tree.addChild(manufacture,0,"Laptops");
        MyTreeNode desktop = tree.addChild(manufacture,1,"Desktops");

        MyTreeNode europe = tree.addChild(international,0,"Europe");
        MyTreeNode asia = tree.addChild(international,1,"Asia");
        MyTreeNode canada = tree.addChild(international,2,"Canada");

        System.out.println("[Level 0]");
        System.out.println(root.element());
        System.out.println();

        System.out.println("[Level 1]");
        System.out.print(sale.element() +", ");
        System.out.print(manufacture.element()+", ");
        System.out.println(rd.element());
        System.out.println();

        System.out.println("[Level 2]");
        System.out.print(US.element()+", ");
        System.out.print(international.element()+", ");
        System.out.print(laptop.element()+", ");
        System.out.println(desktop.element());
        System.out.println();

        System.out.println("[Level 3]");
        System.out.print(europe.element()+", ");
        System.out.print(asia.element()+", ");
        System.out.println(canada.element());
        System.out.println();

        System.out.println("* Tree Size = Total "+tree.size()+" Nodes");
    }
}
