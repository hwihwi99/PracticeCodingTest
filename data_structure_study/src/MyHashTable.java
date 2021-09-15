import java.util.ArrayList;

public class MyHashTable {
    private ArrayList<ArrayList<StudentInfo>> bucketArray;
    private int bucketCapacity;
    private int totalCnt;

    MyHashTable(int initialCapacity){
        bucketArray = new ArrayList<>();
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
        StudentInfo info = new StudentInfo(k,v);
        int key = hashFunc(k);
        ArrayList<StudentInfo> temp = (ArrayList) bucketArray.get(key);

        // 기존에 아무것도 없었다면
        if(temp == null){
            ArrayList <StudentInfo> newList = new ArrayList<StudentInfo>();
            newList.add(info);
            this.bucketArray.set(key,newList);
            totalCnt ++;
            return null;
        }

        for(int i = 0; i< temp.size();i++){
            StudentInfo tempInfo = (StudentInfo) temp.get(i);
            if(k.equals(tempInfo.getStudentID())){
                String result = tempInfo.getStudentName();
                tempInfo.setStudentName(v);
                return result;
            }
            if(i == temp.size()-1){
                temp.add(info);
                totalCnt++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(13);
        hashTable.put("201810612","이휘정");
        System.out.println(hashTable.bucketArray);
    }
}
