import java.util.Iterator;
import java.util.NoSuchElementException;

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

    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first();
        private Position<E> recent = null;
        public boolean hasNext() {
            return (cursor != null);
        }
        public Position<E> next() throws NoSuchElementException {
            if (cursor == null) throw new NoSuchElementException("nothing left");
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }
        public void remove() throws IllegalStateException {
            if (recent == null) throw new IllegalStateException("nothing to remove");
        }
    }

    private class PositionIterable implements Iterable<Position<E>> {
        public Iterator <Position<E>> iterator() {
            return new PositionIterator();
        }
    }

    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator();
        public boolean hasNext() {
            return posIterator.hasNext();
        }
        public E next() {
            return posIterator.next().getElement();
        }
        public void remove() {
            posIterator.remove();
        }
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
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
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    // private helper function
    private Position<E> addBetween(E e, Node<E> prev, Node<E> next) {
        Node<E> newNode = new Node<>(e, prev, next);
        prev.setNext(newNode);
        next.setPrevious(newNode);
        size++;
        return position(newNode);
    }

    public Position<E> addFirst(E e) {
        return addBetween(e, head, head.getNext());
    }

    public Position<E> addLast(E e) {
        return addBetween(e, tail.getPrevious(), tail);
    }

    public Position<E> addBefore(Position <E> p, E e) throws IllegalArgumentException{
        Node <E> node = validate(p);
        return (addBetween(e, node.getPrevious(), node));
    }

    public Position<E> addAfter(Position <E> p, E e) throws IllegalArgumentException {
        Node <E> node = validate(p);
        return (addBetween(e, node, node.getNext()));
    }
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> prev = node.getPrevious();
        Node<E> next = node.getNext();
        prev.setNext(next);
        next.setPrevious(prev);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrevious(null);
        return answer;
    }
}
