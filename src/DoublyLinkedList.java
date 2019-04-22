public class DoublyLinkedList<E> {
    private static class Node<E> {
        private E data;
        private Node<E> nextNode;
        private Node<E> previousNode;
        public Node(E e, Node<E> prev, Node<E> next){
            data = e;
            previousNode = prev;
            nextNode = next;
        }
        public E getElement() {
            return data;
        }
        public Node<E> getNext() {
            return nextNode;
        }
        public Node<E> getPrevious() {
            return previousNode;
        }
        public void setNext(Node<E> next) {
            nextNode = next;
        }
        public void setPrevious(Node<E> prev) {
            previousNode = prev;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;
    public DoublyLinkedList() {
        head = new Node<>(null, null, null); // sentinel for head
        tail = new Node<>(null, head, null);
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return (size==0);
    }
    public E first() {
        if (isEmpty()) return null;
        return head.getNext().getElement(); // gets the node immediately after head sentinel
    }
    public E last() {
        if (isEmpty()) return null;
        return tail.getPrevious().getElement(); // gets the node immediately after tail sentinel
    }
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(head.getNext());
    }
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(tail.getPrevious());
    }
    public void addFirst(E e) {
        addBetween(e, head, head.getNext());
    }
    public void addLast(E e) {
        addBetween(e, tail.getPrevious(), tail);
    }
    private void addBetween(E e, Node<E> prev, Node<E> next) {
        Node<E> newNode = new Node<>(e,prev,next);
        prev.setNext(newNode);
        next.setPrevious(newNode);
        size++;
    }
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrevious();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrevious(predecessor);
        size--;
        return node.getElement();
    }
}
