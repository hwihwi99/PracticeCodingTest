public class DoublyLinkedList {

    private class Node {

        private Object o;
        private Node prev;
        private Node next;

        public Node(Object o){
            this.o = 0;
            this.prev = null;
            this.next = null;
        }
        public void setO(Object e){
            this.o = e;
        }
        public Object getO(){
            return this.o;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    // index번째 있는 node 반환
    public Node node (int index){
        if(index < size()/2){
            Node x = head;
            for(int i = 0; i<index;i++){
                x = x.next;
            }
            return x;
        }else{
            Node x = tail;
            for(int i = size()-1;i>index;i--){
                x = x.prev;
            }
            return x;
        }
    }

    // 맨 앞에 노드 추가
    public void addFirst (Object e){
        Node newNode = new Node(e);
        newNode.next = head;
        if(head != null)
            head.prev = newNode;
        head = newNode;
        size++;
        if(head.next == null){
            tail = head;
        }
    }

    // 맨 뒤에 노드 추가
    public void addLast (Object e){
        Node newNode = new Node(e);
        if(size == 0){
            addFirst(e);
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    //index번째에 노드 추가
    public void add(int index, Object e){
        if(index == 0){
            addFirst(e);
        }
        else{
            Node temp1 = node(index-1);
            Node temp2 = temp1.next;
            Node newNode = new Node(e);

            newNode.next = temp2;
            newNode.prev = temp1;

            temp1.next =newNode;
            if(temp2 != null){
                temp2.prev = newNode;
            }
            size ++;

            if(newNode.next == null){
                tail = newNode;
            }
        }
    }


    // 맨 앞 노드 삭제
    public Object removeFirst(){
        Node temp = head;
        head = temp.next;
        Object returndata = temp.getO();
        temp = null;
        if(head != null)
            head.prev = null;
        size --;
        return returndata;
    }

    // 인덱스번째 노드 삭제
    public Object remove (int index){
        if(index == 0)
            return removeFirst();

        //지우기 전 노드
        Node temp = node(index-1);
        //지울 노드
        Node todoDeleted = temp.next;
        temp.next = temp.next.next;

        if(temp.next != null){
            temp.next.prev = temp;
        }
        Object returndata = todoDeleted.getO();
        if(todoDeleted == tail){
            tail = temp;
        }
        todoDeleted = null;
        size --;
        return returndata;
    }

    // 맨 뒤 노드 삭제
    public  Object removeLast(){
        return remove(size()-1);
    }

    // index번째 노드의 값 반환
    public Object get (int k){
        return node(k).getO();
    }
}
