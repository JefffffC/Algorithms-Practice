public class MinHeap {
    private int[] Heap;
    private int size;
    private int maxSize;

    private static final int FRONT = 1;

    public MinHeap(int maxsize) {
        maxSize = maxsize;
        size = 0;
        Heap = new int[maxsize+1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos/2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return ((2 * pos) + 1);
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size/2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) { // if the node is a non-leaf node and greater than any of its children
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos)); // recursive call to continue heapify
                }
                else { // if right child is lesser than left child
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) { // time complexity of Heap insertion is O(log(n))
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) { // "bubble" the insert to the appropriate position through swapping
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void minHeap() {
        for (int pos = (size/2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int remove() { // O(log(n))
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }
}
