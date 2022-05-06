/**
 * 
 * Generic version of the LinkedList class.
 *
 * 
 * 
 * @param <T> the type of the value
 * 
 */

public class MyList<T> {

    /**
     * 
     * Head node, default is null
     * 
     */

    Node<T> head;

    /**
     * 
     * Tail node, default is null
     * 
     */

    Node<T> tail;

    /**
     * 
     * Default constructor
     * 
     */

    public MyList() {

    }

    /**
     * 
     * Constructor with head and tail
     *
     * 
     * 
     * @param head Head node of this list
     * 
     * @param tail Tail node of this list
     * 
     */

    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * 
     * Checking if this list is empty
     *
     * 
     * 
     * @return true if list is empty
     * 
     */

    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * 
     * Returning the length of this list
     *
     * 
     * 
     * @return The length of this list
     * 
     */

    public int length() {
        int length = 0;
        Node<T> current = this.head;

        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }

    /**
     * 
     * Insert an item to the head of this list
     *
     * 
     * 
     * @param item The item to be inserted
     * 
     */

    public void insertToHead(T item) {
        Node<T> newNode = new Node<>(item, this.head);
        newNode.setNext(this.head);
        this.head = newNode;
    }

    /**
     * 
     * Insert an item at position to this list
     *
     * 
     * 
     * @param position The position of new item
     * 
     * @param item     The item to be inserted
     * 
     */

    public void insertAfterPosition(int position, T item) {
        if (position < 0) {
            return;
        }
        // If pos is zero, It's add to first
        if (position == 0) {
            insertToHead(item);
            return;
        }
        int i = 0;
        Node<T> current = this.head;
        while (i < position - 1 && current != null) {
            i++;
            current = current.getNext();
        }
        // pos is outIndex of linked list
        if (i != position - 1) {
            return;
        }
        // insert newNode to pos
        Node<T> newNode = new Node<>(item, current.getNext());
        current.setNext(newNode);
    }

    /**
     * 
     * Deleting the tail of this list
     * 
     */

    public void deleteTail() {
        if (this.head == null) {
            System.out.println("List is empty");
            return;
        } else {
            if (head != tail) {
                Node<T> current = head;
                while (current.getNext() != tail) {
                    current = current.getNext();
                }
                tail = current;
                tail.next = null;
            } else {
                head = tail = null;
            }
        }

    }

    /**
     * 
     * Searching and deleting an item from this list by comparing the ID of items
     *
     * 
     * 
     * @param item The item to be deleted
     * 
     */

    public void deleteElement(T item) {
        // Store head node
        Node<T> temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.getInfo() == item) {
            head = temp.getNext(); // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.getInfo() != item) {
            prev = temp;
            temp = temp.getNext();
        }

        // If key was not present in linked list
        if (temp == null)
            return;

        // Unlink the node from linked list
        prev.setNext(temp.getNext());
    }

    /**
     * 
     * Swaping two nodes [firstNode] and [secondNode]
     *
     * 
     * 
     * @param firstNode
     * 
     * @param secondNode
     * 
     */

    public void swap(Node<T> firstNode, Node<T> secondNode) {
        T temp = firstNode.getInfo();
        firstNode.setInfo(secondNode.getInfo());
        secondNode.setInfo(temp);
    }

    /**
     * 
     * Deleting all items in the list
     * 
     */

    public void clear() {
        head = null;
    }

}