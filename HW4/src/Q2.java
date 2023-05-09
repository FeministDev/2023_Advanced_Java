import java.util.concurrent.*;

public class Q2 {

    private static final int THRESHOLD = 10000;



    public static void main(String[] args) {
        // Create a list of 90,000,000 random double values
        double[] list = new double[90000000];
        for (int i = 0; i < list.length; i++) {
            list[i] = Math.random();
        }

        // Compute the sequential sum and time it
        long startSeq = System.currentTimeMillis();
        double seqSum = sequentialSum(list);
        long endSeq = System.currentTimeMillis();
        long seqTime = endSeq - startSeq;

        // Compute the parallel sum and time it
        long startPar = System.currentTimeMillis();
        double parSum = parallelSum(list);
        long endPar = System.currentTimeMillis();
        long parTime = endPar - startPar;

        // Print the results
        System.out.println("Sequential sum:  " + seqSum + " , Time Required: " + seqTime + " ms");
        System.out.println("Parallel sum: " + parSum + " , Time Required: " + parTime + " ms");
        
    }
    private static class SumTask extends RecursiveTask<Double> {

        //make list of doubles
        private double[] list;
        private int start;
        private int end;

        //Create SumTask method
        public SumTask(double[] list, int start, int end) {
            this.list = list;
            this.start = start;
            this.end = end;
        }

        @Override
        public Double compute() {
            if (end - start <= THRESHOLD) {
                //set sum
                double sum = 0;

                //for loop
                for (int i = start; i < end; i++) {
                    sum += list[i];
                }

                //return sum
                return sum;
            }
            else {
                //set mid
                int mid = (start + end) / 2;

                //left
                SumTask left = new SumTask(list, start, mid);

                //right
                SumTask right = new SumTask(list, mid, end);

                left.fork();

                //results
                double rightResult = right.compute();
                double leftResult = left.join();
                return leftResult + rightResult;
            }
        }
    }

    public static double parallelSum(double[] list) {

        //forkjoin
        ForkJoinPool pool = new ForkJoinPool();

        //list
        SumTask task = new SumTask(list, 0, list.length);
        return pool.invoke(task);
    }

    public static double sequentialSum(double[] list) {
        //sum
        double sum = 0;

        //for loop
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }

        //return sum
        return sum;
    }
}
