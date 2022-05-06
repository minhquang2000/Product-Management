/**
 * 
 * Generic version of the Stack class.
 *
 * 
 * 
 * @param <T> the type of the value
 * 
 */

class MyStack<T> {

    /**
     * 
     * Head node contains front node in the stack
     * 
     */

    Node<T> head;

    MyStack() {
        head = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }

    public void push(T info) {
        head = new Node<T>(info, head);
    }

    public T pop() {
        boolean condition = isEmpty();
        if (condition == false) { // Kiểm tra stack có rỗng hay không
            T info = head.getInfo();
            head = head.getNext();
            return info;
        }
        return null;
    }
}
