public class DoublyLinkedPositionalList<E> implements PositionalList<E>{
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> previousNode;
        private Node<E> nextNode;
        public Node(E e, Node<E> prev, Node<E> next) {
            element = e;
            previousNode = prev;
            nextNode = next;
        }
        public E getElement() throws IllegalStateException {
            if (nextNode == null)
                throw new IllegalStateException("Position no longer valid");
            return element;
        }
        public Node<E> getPrevious() {
            return previousNode;
        }
        public Node<E> getNext() {
            return nextNode;
        }
        public void setElement(E e) {
            element = e;
        }
        public void setNext(Node<E> n) {
            nextNode = n;
        }
        public void setPrevious(Node<E> p) {
            previousNode = p;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public DoublyLinkedPositionalList() {
        head = new Node<>(null,null,null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getNext() == null)
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    private Position<E> position(Node<E> node) {
        if (node == head || node == tail)
            return null;
        return node;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Position<E> first() {
        return position(head.getNext());
    }

    public Position<E> last() {
        return position(tail.getPrevious());
    }

    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrevious());
    }

    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node
    }
}
