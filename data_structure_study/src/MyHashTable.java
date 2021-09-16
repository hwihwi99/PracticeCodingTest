import java.util.ArrayList;

public class MyHashTable {
    private ArrayList bucketArray;
    private int bucketCapacity;
    private int totalCnt;
    private float loadFactor;

    public MyHashTable(int initialCapacity){
        bucketArray = new ArrayList();
        bucketCapacity = initialCapacity;
        totalCnt = 0;
        for(int i = 0; i<bucketCapacity;i++){
            bucketArray.add(null);
        }
    }

    public MyHashTable(int initialCapacity, float loadFactor){
        bucketArray = new ArrayList();
        bucketCapacity = initialCapacity;
        totalCnt = 0;
        this.loadFactor = loadFactor;
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

    // loadFactor가 커져서 capacity를 늘렸다면.. -> 배열의 크기를 늘리고 재배치 해주어야합니다.
    private void rehash(int capacity){
        ArrayList oldList = this.bucketArray;

        // bucketArray 다시 설정
        this.bucketCapacity = capacity;
        this.bucketArray = new ArrayList();
        for(int i=0;i<bucketCapacity;i++){
            bucketArray.add(null);
        }
        this.totalCnt = 0;

        for(int i = 0; i<oldList.size();i++){
            ArrayList temp = (ArrayList) oldList.get(i);
            if(temp != null){
                for(int j = 0; j< temp.size();j++){
                    StudentInfo tempInfo = (StudentInfo) temp.get(j);
                    this.put(tempInfo.getStudentID(),tempInfo.getStudentName());
                }
            }
        }
    }

    public float getLoadFactor(){
        return (float) this.totalCnt/this.bucketCapacity;
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

        if(this.getLoadFactor() > this.loadFactor){
            rehash(2*bucketCapacity);
        }

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

//    public void printHashTable(){
//        System.out.println("************HASH TABLE****************");
//        System.out.println("Capacity : "+this.bucketCapacity + ", Size : "+this.totalCnt+", LoadFactor : " + this.loadFactor);
//
//
//    }
    public static void main(String[] args) {
        MyHashTable mht = new MyHashTable(13,0.9F);

        System.out.println("-----------------------------");
        System.out.println(mht.put("201211032","HSK"));
        System.out.println(mht.put("201211032","HSK2"));
        System.out.println(mht.put("201211111","KDI"));
        System.out.println(mht.put("201211115","KDP"));
        System.out.println(mht.put("201711215","DDP"));
        System.out.println(mht.put("201711515","GDP"));

        System.out.println(mht.put("201911515","LID"));
        System.out.println(mht.put("201911528","HID"));
        System.out.println(mht.put("201911529","YID"));
        System.out.println(mht.put("201911530","YKD"));
        System.out.println(mht.put("201911560","YHD"));
        System.out.println("CURRENT LOADFACTOR : "+mht.getLoadFactor());

        System.out.println("-----------------------------");
        System.out.println("get 201211032 : "+mht.get("201211032"));
        System.out.println("get 201211111 : "+mht.get("201211111"));

       // mht.printHashTable();



    }
}
