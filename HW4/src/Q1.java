public class Q1 {
    public static void main(String[] args) throws InterruptedException {
        //make integerWrapper
        IntegerWrapper sum = new IntegerWrapper(0);

        //make 1000 threads
        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                synchronized (sum)
                {
                    sum.value++;
                }
            });
            //start threads
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        //print sum value
        System.out.println("Sum is equal to " + sum.value);
    }

    static class IntegerWrapper {
        int value;

        IntegerWrapper(int value) {
            this.value = value;
        }
    }
}

