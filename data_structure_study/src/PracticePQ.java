import java.awt.*;

public class PracticePQ {
    public static void main(String[] args) {
        MyPQ.IntComparator c = new MyPQ.IntComparator();
        MyPQ pq = new MyPQ(c);

        Point p1 = new Point(5,4);
        pq.insert((int)(Math.sqrt(Math.pow(p1.getX(),2)+Math.pow(p1.getY(),2))),"a (5, 4)");

        Point p2 = new Point(2,7);
        pq.insert((int)(Math.sqrt(Math.pow(p2.getX(),2)+Math.pow(p2.getY(),2))),"b (2, 7)");

        Point p3 = new Point(9,5);
        pq.insert((int)(Math.sqrt(Math.pow(p3.getX(),2)+Math.pow(p3.getY(),2))),"c (9, 5)");

        Point p4 = new Point(3,1);
        pq.insert((int)(Math.sqrt(Math.pow(p4.getX(),2)+Math.pow(p4.getY(),2))),"d (3, 1)");

        Point p5 = new Point(7,2);
        pq.insert((int)(Math.sqrt(Math.pow(p5.getX(),2)+Math.pow(p5.getY(),2))),"e (7, 2)");

        Point p6 = new Point(9,7);
        pq.insert((int)(Math.sqrt(Math.pow(p6.getX(),2)+Math.pow(p6.getY(),2))),"f (9, 7)");

        Point p7 = new Point(1,4);
        pq.insert((int)(Math.sqrt(Math.pow(p7.getX(),2)+Math.pow(p7.getY(),2))),"g (1, 4)");

        Point p8 = new Point(4,3);
        pq.insert((int)(Math.sqrt(Math.pow(p8.getX(),2)+Math.pow(p8.getY(),2))),"h (4, 3)");

        Point p9 = new Point(8,2);
        pq.insert((int)(Math.sqrt(Math.pow(p9.getX(),2)+Math.pow(p9.getY(),2))),"i (8, 2)");

        Point p10 = new Point(4,8);
        pq.insert((int)(Math.sqrt(Math.pow(p10.getX(),2)+Math.pow(p10.getY(),2))),"j (4, 8)");

        System.out.println("[가까운 순서]");
        while(!pq.isEmpty()){
            System.out.println(pq.removeMin().getValue());
        }

        System.out.println("----------------------------------------------");

        MyPQ.IntComparator2 comparator2 = new MyPQ.IntComparator2();
        MyPQ pq2 = new MyPQ(comparator2);

        pq2.insert((int)(Math.sqrt(Math.pow(p1.getX(),2)+Math.pow(p1.getY(),2))),"a (5, 4)");
        pq2.insert((int)(Math.sqrt(Math.pow(p2.getX(),2)+Math.pow(p2.getY(),2))),"b (2, 7)");
        pq2.insert((int)(Math.sqrt(Math.pow(p3.getX(),2)+Math.pow(p3.getY(),2))),"c (9, 5)");
        pq2.insert((int)(Math.sqrt(Math.pow(p4.getX(),2)+Math.pow(p4.getY(),2))),"d (3, 1)");
        pq2.insert((int)(Math.sqrt(Math.pow(p5.getX(),2)+Math.pow(p5.getY(),2))),"e (7, 2)");
        pq2.insert((int)(Math.sqrt(Math.pow(p6.getX(),2)+Math.pow(p6.getY(),2))),"f (9, 7)");
        pq2.insert((int)(Math.sqrt(Math.pow(p7.getX(),2)+Math.pow(p7.getY(),2))),"g (1, 4)");
        pq2.insert((int)(Math.sqrt(Math.pow(p8.getX(),2)+Math.pow(p8.getY(),2))),"h (4, 3)");
        pq2.insert((int)(Math.sqrt(Math.pow(p9.getX(),2)+Math.pow(p9.getY(),2))),"i (8, 2)");
        pq2.insert((int)(Math.sqrt(Math.pow(p10.getX(),2)+Math.pow(p10.getY(),2))),"j (4, 8)");

        System.out.println("[멀리 있는 순서]");
        while(!pq2.isEmpty()){
            System.out.println(pq2.removeMin().getValue());
        }

    }
}
