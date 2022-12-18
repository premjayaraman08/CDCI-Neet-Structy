package TwoLinkedList;

public class LinkedList {
    ListNode head;
    ListNode tail;
    int size;

    //constructor
    LinkedList(){
        this.size = 0;
        this.head = this.tail = null;
    }


    public void insertFirst(int val){
        // create new node
        ListNode newNode = new ListNode(val);

        // Update head and tail pointers
        newNode.next = head;
        head = newNode;

        if(tail == null){
            tail = newNode;
        }

        size ++;

        // 0 ->  3 - >4 ->  5
        //       h    t
    }

    public void insertLast(int val){
       ListNode newNode = new ListNode(val);

       if(tail == null){
           tail = newNode;
           return;
       }
       //Update tail pointer
       tail.next = newNode;
       tail = newNode;
       size ++;


    }

    public void print(){
        ListNode current = this.head;

        while(current!=null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print(" END ");

    }

    public void insertMiddle(int index, int val ) {
        if( index > size) {
            return;
        }

        if(index == 0){
            this.insertFirst(val);
            return;
        }

        if(index == size  ){
            this.insertLast(val);
            return;
        }

        ListNode curr = this.head;
        for(int i=1; i<index; i++) {
            curr =  curr.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = curr.next;
        curr.next = newNode;

        size++;
    }
    // 1 -> 2 -> 3
    //      h
    /*
    *  Handle empty head
    *  Move head pointer
    *  If head is empty update tail
    */
    public void removeFirst(){
        // handle empty nodes
        if(head == null){
            return;
        }

        head = head.next ;

        //POST removal
        if( head == null ){
            tail = head;
        }

        size --;
    }

    public void removeLast(){

        if(size<=1){
            removeFirst();
        }

        ListNode curr = this.head; // already 1st taken into account
        for(int i=1; i<size -1; i++){
            curr = curr.next;
        }
        tail = curr;
        tail.next = null;
        size --;
    }


    public static void main(String[] args) {

        LinkedList myLL = new LinkedList();
        myLL.removeFirst();

        myLL.insertFirst(4);
        myLL.insertFirst(2);
        myLL.insertFirst(1);
        myLL.insertLast(5);
        myLL.removeLast();

        //myLL.insertMiddle(2,3);

        myLL.print();
    }



    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;

        }

    }
}
