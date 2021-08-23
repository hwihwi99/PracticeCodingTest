public class TreePractice {
    public static void main(String[] args) {
        MyBinTree mbt = new MyBinTree("+");
        mbt.addNode("X");
        mbt.addNode("X");

        mbt.insertLeft(mbt.root().left(),"2");
        mbt.insertRight(mbt.root().left(),"-");
        mbt.insertLeft(mbt.root().left().right(),"3");
        mbt.insertRight(mbt.root().left().right(),"1");
        mbt.insertLeft(mbt.root().right(),"3");
        mbt.insertRight(mbt.root().right(),"2");

        mbt.inOrder(mbt.root());
        System.out.println();
        System.out.print("= ");
        System.out.println(mbt.PostOrder(mbt.root()));
    }
}
