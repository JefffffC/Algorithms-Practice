public class LinkedBinaryTree<E> {
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> p, Node<E> l, Node<E> r) {
            element = e;
            parent = p;
            left = l;
            right = r;
        }
        public E getElement() {
            return element;
        }
        public Node<E> getParent() {
            return parent;
        }
        public Node<E> getLeft() {
            return left;
        }
        public Node<E> getRight() {
            return right;
        }
        public void setElement(E e) {
            element = e;
        }
        public void setParent(Node<E> p) {
            parent = p;
        }
        public void setLeft(Node<E> l) {
            left = l;
        }
        public void setRight(Node<E> r) {
            right = r;
        }
    }
    protected Node<E> createNode(E e, Node<E> p, Node<E> l, Node<E> r) {
        return new Node<E>(e, p, l, r); // factory function for creating new node storing element e
    }
    protected Node<E> root = null; // ONLY TWO INSTANCE VARS, ROOT reference and SIZE
    private int size = 0;
    public LinkedBinaryTree(){}
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not a valid position type");
        Node<E> node = (Node<E>)p;
        if (node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree");
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
    public Position<E> parent(Position<E>p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }
    public Position<E> left(Position<E>p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }
    public Position<E> right(Position<E>p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }
    public Position<E> addRoot(E e) throws IllegalStateException { // places root at empty tree, returns its new position
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null)
            throw new IllegalArgumentException("Parent already has left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException("Parent already has right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp; // returns the replaced element at p
    }
}
