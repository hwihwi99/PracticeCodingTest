import java.util.ArrayList;

public class MyHashTable {
    private ArrayList bucketArray;
    private int bucketCapacity;
    private int totalCnt;

    MyHashTable(int initialCapacity){
        bucketArray = new ArrayList();
        bucketCapacity = initialCapacity;
        totalCnt = 0;
        for(int i = 0;i<bucketCapacity;i++){
            bucketArray.add(null);
        }
    }

    private int hashFunc(String k){
        int h = 0;
        int a = 33;

        for(int i = 0;i<k.length();i++){
            h = (h<<5) | (h>>>27);
            h+= (int)(k.charAt(i) * Math.pow(a,k.length()-i-1));
        }
        h %= this.bucketCapacity;
        return h;
    }

    public int size(){
        return totalCnt;
    }

    public String get (String k){
        int key = hashFunc(k);
        ArrayList temp = (ArrayList) this.bucketArray.get(key);

        if(temp == null){
            System.out.println("This key is not exist");
        }else{
            for(int i = 0;i<temp.size();i++){
                StudentInfo info = (StudentInfo) temp.get(i);
                if(k.equals(info.getStudentID())){
                    return info.getStudentName();
                }
            }
        }
        return null;
    }

    public String put(String k, String v){
        int key = hashFunc(k);
        ArrayList temp = (ArrayList) bucketArray.get(key);

        if(temp == null){
            StudentInfo info = new StudentInfo(k,v);
            temp.add(info);
            totalCnt++;
            return null;
        }
        for(int i = 0;i< temp.size();i++){
            if()
        }
    }
}
