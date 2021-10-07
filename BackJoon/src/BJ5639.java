import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5639 {
    static public class Node{
        int num;
        Node left, right;
        public Node(int num){
            this.num = num;
        }
        public Node(int num, Node left, Node right){
            this.num = num;
            this.left = left;
            this.right = right;
        }
        public void insert(int data){
            if(data < this.num){
                if(this.left == null){
                    this.left = new Node(data);
                }else{
                    this.left.insert(data);
                }
            }else{
                if(this.right == null){
                    this.right = new Node(data);
                }else{
                    this.right.insert(data);
                }
            }
        }
    }
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true){
            input = br.readLine();
            if(input == null || input.equals("")){
                break;
            }
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);
    }
    public static void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.num);
        }
    }
}
