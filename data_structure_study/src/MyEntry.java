import java.util.*;

interface Entry{
    public void setKey(Object k);
    public void setValue(Object v);
    public Object getkey();
    public Object getValue();
}

// 이 클래스에는 key값과 value값을 갖고 있어야 겠지!
public class MyEntry implements Entry {

    private Object key;
    private Object value;

    public MyEntry(){
        this.key = null;
        this.value = null;
    }

    public MyEntry(Object key, Object value){
        this.key = key;
        this.value = value;
    }

    @Override
    public void setKey(Object k) {
        this.key = k;
    }

    @Override
    public void setValue(Object v) {
        this.value = v;
    }

    @Override
    public Object getkey() {
        return this.key;
    }

    @Override
    public Object getValue() {
        return this.value;
    }
}
