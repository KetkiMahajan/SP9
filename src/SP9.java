/** Sample starter code for SP9.
 *  @author
 */

import java.util.Arrays;
import java.util.Random;

public class SP9 {
    public static Random random = new Random();
    public static int numTrials = 100;
    public static void main(String[] args) {
        int n = 10;
        int choice = 1 + random.nextInt(4);
        if(args.length > 0) {
            n = Integer.parseInt(args[0]);
        }
        if(args.length > 1) {
            choice = Integer.parseInt(args[1]);
        }
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i;
        }
        Timer timer = new Timer();
        switch(3) {
            case 1:
                Shuffle.shuffle(arr);
                numTrials = 1;
                insertionSort(arr,0,arr.length);
                //System.out.println(Arrays.toString(arr));
                break;
            case 2:
                for(int i=0; i<numTrials; i++) {
                    Shuffle.shuffle(arr);
                    mergeSort1(arr);

                }
                //System.out.println(Arrays.toString(arr));
                break;  // etc
            case 3:
                for(int i=0; i<numTrials; i++) {
                    Shuffle.shuffle(arr);
                    mergeSort2(arr);
                }
                System.out.println(Arrays.toString(arr));
                break;  // etc
        }
        timer.end();
        timer.scale(numTrials);

        System.out.println("Choice: " + choice + "\n" + timer);
    }

    private static void mergeSort2(int[] arr) {
        int[] B= new int[arr.length];
        mergeSort2(arr,B,0,arr.length-1);
    }

    private static void mergeSort2(int[] arr, int[] b, int left, int n) {
        if(n<4){
            insertionSort(arr,left,left+n-1);
        }else{
            int mid= n/2;
            mergeSort2(arr,b,left,mid);
            mergeSort2(arr,b,left+mid,n-mid);

            merge2(arr,b,left,left+mid-1,left+n-1);
        }
    }

    private static void merge2(int[] A, int[] B, int p, int q, int r) {
        System.arraycopy(A,p,B,p,r-p+1);

        int i=p, j=q+1;
        for(int k=p; k<=r; k++){
            if(j>r || (i<=q && B[i]<=B[j])){
                A[k]=B[i++];
            }else{
                A[k]=B[j++];
            }
        }

    }

    public static void insertionSort(int[] arr,int p,int r) {
        for(int i=p+1; i < r; i++)
        {
            int temp= arr[i];
            int j=i-1;
            while(j>=0 && temp<=arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void mergeSort1(int[] arr) {
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int p, int r) {
        int q=0;
        if(p<r){
            q=(p+r)/2;
            mergeSort(arr,p,q);
            mergeSort(arr,q+1,r);
            merge(arr,p,q,r);
        }
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int[] L= new int[q-p+1];
        int[] R= new int[r-q];
        System.arraycopy(arr,p,L,0,q-p+1);
        System.arraycopy(arr,q+1,R,0,r-q);

        int i=0, j=0;
        for(int k=p; k<=r; k++){
                if(j>=R.length || (i<L.length && L[i]<=R[j])){
                arr[k]=L[i++];
            }else{
                arr[k]=R[j++];
            }
        }
    }
    /** Timer class for roughly calculating running time of programs
     *  @author rbk
     *  Usage:  Timer timer = new Timer();
     *          timer.start();
     *          timer.end();
     *          System.out.println(timer);  // output statistics
     */

    public static class Timer {
        long startTime, endTime, elapsedTime, memAvailable, memUsed;
        boolean ready;

        public Timer() {
            startTime = System.currentTimeMillis();
            ready = false;
        }

        public void start() {
            startTime = System.currentTimeMillis();
            ready = false;
        }

        public Timer end() {
            endTime = System.currentTimeMillis();
            elapsedTime = endTime-startTime;
            memAvailable = Runtime.getRuntime().totalMemory();
            memUsed = memAvailable - Runtime.getRuntime().freeMemory();
            ready = true;
            return this;
        }

        public long duration() { if(!ready) { end(); }  return elapsedTime; }

        public long memory()   { if(!ready) { end(); }  return memUsed; }

        public void scale(int num) { elapsedTime /= num; }

        public String toString() {
            if(!ready) { end(); }
            return "Time: " + elapsedTime + " msec.\n" + "Memory: " + (memUsed/1048576) + " MB / " + (memAvailable/1048576) + " MB.";
        }
    }

    /** @author rbk : based on algorithm described in a book
     */


    /* Shuffle the elements of an array arr[from..to] randomly */
    public static class Shuffle {

        public static void shuffle(int[] arr) {
            shuffle(arr, 0, arr.length-1);
        }

        public static<T> void shuffle(T[] arr) {
            shuffle(arr, 0, arr.length-1);
        }

        public static void shuffle(int[] arr, int from, int to) {
            int n = to - from  + 1;
            for(int i=1; i<n; i++) {
                int j = random.nextInt(i);
                swap(arr, i+from, j+from);
            }
        }

        public static<T> void shuffle(T[] arr, int from, int to) {
            int n = to - from  + 1;
            Random random = new Random();
            for(int i=1; i<n; i++) {
                int j = random.nextInt(i);
                swap(arr, i+from, j+from);
            }
        }

        static void swap(int[] arr, int x, int y) {
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }

        static<T> void swap(T[] arr, int x, int y) {
            T tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }

        public static<T> void printArray(T[] arr, String message) {
            printArray(arr, 0, arr.length-1, message);
        }

        public static<T> void printArray(T[] arr, int from, int to, String message) {
            System.out.print(message);
            for(int i=from; i<=to; i++) {
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
    }
}
