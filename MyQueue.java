/**
 * 
 * Generic version of the Queue class.
 *
 * 
 * 
 * @param <T> the type of the value
 * 
 */

class MyQueue<T> {

    /**
     * 
     * Head node contains front node in the queue
     * 
     */

    Node<T> head;

    /**
     * 
     * Tail node contains last node in the queue
     * 
     */

    Node<T> tail;

    public MyQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Hàm enqueue thêm dữ liệu vào queue
    public void enqueue(T info) {
        if (isEmpty()) // Kiểm tra queue có rỗng hay không
            head = tail = new Node<T>(info, null);
        else {
            tail.next = new Node<T>(info,null);
            tail = tail.next;
        }
    }

    // Hàm dequeue xóa dữ liệu khỏi queue
    public T dequeue() {
        boolean condition = isEmpty();
        if (condition == false) { // Nếu queue không rỗng
            T info = head.getInfo();
            head = head.getNext();
            return info;
        }
        return null;
    }
}