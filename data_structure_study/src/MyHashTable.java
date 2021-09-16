import java.util.ArrayList;

public class MyHashTable {
    private ArrayList bucketArray;
    private int bucketCapacity;
    private int totalCnt;

    public MyHashTable(int initialCapacity){
        bucketArray = new ArrayList();
        bucketCapacity = initialCapacity;
        totalCnt = 0;
        for(int i = 0; i<bucketCapacity;i++){
            bucketArray.add(null);
        }
    }

    private int hashFunc(String k){
        int h = 0;
        int a = 33;
        for(int i = 0; i<k.length();i++){
            h = (h<<5) | (h>>>27);
            h = (int)(k.charAt(i)*Math.pow(a,k.length()-i-1));
        }
        h %= bucketCapacity;
        return h;
    }

    public int size(){
        return this.totalCnt;
    }

    public String get(String k){
        int key = hashFunc(k);
        ArrayList temp = (ArrayList) bucketArray.get(key);
        if(temp == null){
            System.out.println("this key is not exist");
        }else{
            for(int i = 0; i<temp.size();i++){
                StudentInfo info = (StudentInfo) temp.get(i);
                if(k.equals(info.getStudentID())){
                    return info.getStudentName();
                }
            }
        }
        return null;
    }

    public String put (String k, String v) {
        StudentInfo studentInfo = new StudentInfo(k, v);
        int key = hashFunc(k);
        ArrayList temp = (ArrayList) bucketArray.get(key);

        if (temp == null) {
            ArrayList newList = new ArrayList();
            newList.add(studentInfo);
            this.bucketArray.set(key, newList);
            totalCnt++;
            return null;
        }
        for (int i = 0; i < temp.size(); i++) {
            StudentInfo info = (StudentInfo) temp.get(i);
            if (k.equals(info.getStudentID())) {
                String returnData = info.getStudentName();
                temp.set(i, studentInfo);
                return returnData;
            }
        }
        temp.add(studentInfo);
        totalCnt++;
        return null;
    }

    public String remove(String k){
        int key = hashFunc(k);
        ArrayList temp = (ArrayList) bucketArray.get(key);
        if(temp == null){
            System.out.println("Key cannot find");
            return null;
        }
        for(int i = 0;i< temp.size();i++){
            StudentInfo info = (StudentInfo) temp.get(i);
            if(k.equals(info.getStudentID())){
                String returnData = info.getStudentName();
                temp.remove(i);
                totalCnt --;
                return returnData;
            }
        }
        System.out.println("Key cannot find");
        return null;
    }

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(13);
        hashTable.put("123","A");
        hashTable.put("34235","B");
        hashTable.put("dfssdf","C");
        hashTable.put("dsfs","D");
        System.out.println(hashTable.get("123"));
        System.out.println(hashTable.remove("123"));
        System.out.println(hashTable.get("DSFS"));
        System.out.println(hashTable.bucketArray);
    }
}
