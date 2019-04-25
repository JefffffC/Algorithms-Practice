public class LinkedBinaryTree2<E> {
    protected static class Node<E> implements Position<E> {
        E element;
        Node<E> parent;
        Node<E> leftChild;
        Node<E> rightChild;
        public Node(E e, Node<E> p, Node<E> l, Node<E> r) {
            element = e;
            parent = p;
            leftChild = l;
            rightChild = r;
        }
        public E getElement() {
            return element;
        }
        public Node<E> getParent() {
            return parent;
        }
        public Node<E> getLeftChild() {
            return leftChild;
        }
        public Node<E> getRightChild() {
            return rightChild;
        }
        public void setElement(E e) {
            element = e;
        }
        public void setParent(Node<E> p) {
            parent = p;
        }
        public void setLeftChild(Node<E> l) {
            leftChild = l;
        }
        public void setRightChild(Node<E> r) {
            rightChild = r;
        }
    }
    protected Node<E> createNode(E e, Node<E> p, Node<E> l, Node<E> r) {
        return new Node<E>(e,p,l,r);
    }
    protected Node<E> root = null;
    private int size = 0;
    public LinkedBinaryTree2(){}

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>)p; // perform safe cast
        if (node.getParent() == node) throw new IllegalArgumentException("p is no longer in tree");
        return node;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Position<E> root() {
        return root;
    }

    public Position<E> parent(Position<E> p) {
        Node<E> node = validate(p);
        return node.getParent();
    }

    public Position<E> leftChild(Position<E> p) {
        Node<E> node = validate(p);
        return node.getLeftChild();
    }

    public Position<E> rightChild(Position<E> p) {
        Node<E> node = validate(p);
        return node.getRightChild();
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (node.getLeftChild() != null)
            throw new IllegalArgumentException("parent already has left child");
        Node<E> child = createNode(e, node, null, null);
        node.setLeftChild(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (node.getRightChild() != null)
            throw new IllegalArgumentException("parent already has right child");
        Node<E> child = createNode(e, node, null, null);
        node.setRightChild(child);
        size++;
        return child;
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }



}
