public class SinglyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next = null;
        public Node(E e, Node<E> nextNode) { // nested Node class
            element = e;
            next = nextNode;
        }
        public E getElement() {
            return element;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> nextNode) {
            next = nextNode;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    public int getSize() { // returns size of list
        return size;
    }
    public boolean isEmpty() { // checks if list is empty or not
        if(size == 0) {
            return true;
        }
        else
            return false;
    }
    public E first() {
        if (isEmpty()) return null;
        else return head.getElement();
    }
    public E last() {
        if (isEmpty()) return null;
        else return tail.getElement();
    }
    public void addFirst(E element) {
        head = new Node<>(element, head); // use existing head to create new node that points to old head, assign it to new head
        if (this.isEmpty()) { // if empty, tail is also head
            tail = head;
        }
        size++;
    }
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, null); // next node is null b/c this will be new tail
        if (isEmpty())
            head = newNode; // if list is empty, new tail is also new head
        else
            tail.setNext(newNode); // the previous tail's next node is the new node
        tail=newNode; // set the tail to the new node
        size++;
    }
    public E removeFirst() {
        if (isEmpty()) // special case if list is empty
            return null;
        E answer = head.getElement(); // get the data member of the node to be removed
        head = head.getNext(); // set the head to the next node
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }
}
