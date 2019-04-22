public class Main {

    public static void main(String[] args) {
        System.out.println("Algorithm testing:");
        ArrayQueue<Integer> testADT = new ArrayQueue<>(5);
        testADT.enqueue(1);
        testADT.enqueue(2);
        testADT.enqueue(3);
        testADT.enqueue(4);
        testADT.enqueue(5);
        System.out.println(testADT.first());
        testADT.dequeue();
        testADT.dequeue();
        System.out.println(testADT.dequeue());
    }

    public static int factorial(int n) throws IllegalArgumentException{
        if (n<0){
            throw new IllegalArgumentException();
        }
        else if (n == 0) {
            return 1;
        }
        else return (n * factorial(n-1));
    }
    static int numCalls = 0;
    public static void solveHanoi(int n, String start, String aux, String end) {
        numCalls++;
        System.out.println("Recursive call number " + numCalls + ".");
        if (n == 1) {
            System.out.println(start + " -> " + end);
        }
        else {
            solveHanoi((n-1), start, end, aux);
            System.out.println(start + " -> " + end);
            solveHanoi((n-1), aux, end, start);
        }
    }

}
