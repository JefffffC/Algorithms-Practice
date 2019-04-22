public class LinkedListQueue<E> implements Queue<E>{
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public LinkedListQueue() {}
    public int size() {
        return list.getSize();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void enqueue(E e) {
        list.addLast(e);
    }
    public E dequeue() {
        return list.removeFirst(); // remember, SinglyLinkedList only has removeFirst, so need to add at behind
    }
    public E first() {
        return list.first();
    }
}
