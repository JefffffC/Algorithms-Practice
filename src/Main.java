public class Main {

    public static void main(String[] args) {
        System.out.println("Algorithm testing:");

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
