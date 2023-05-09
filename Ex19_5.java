import java.util.Random;

public class Ex19_5 {
    public static void main(String[] args) {


        //create list of 100 ints
        Integer[] list = new Integer[100];

        //populate list with random ints
        for (int i = 0; i < list.length; i++) {
            Random r = new Random();
            int randomInt = r.nextInt(10001);
            list[i] = randomInt; // storing random integers in an array
        }

        //create an array of 100 doubles
        Double[] list2 = new Double[100];

        //populate list2 with random doubles
        for(int i = 0; i < list2.length; i++){
            Random r = new Random();
            double double_random = r.nextDouble();
            list2[i] = double_random;
        }

        //print int
        for (int element: list) {
            System.out.print(element + " ");
        }
        //print blank line
        System.out.println();

        //print double
        for(double element: list2){
            System.out.print(element + " ");
        }

        //print blank line
        System.out.println();

        //print max
        System.out.print("Max int = " + max(list));
        System.out.println();
        System.out.print("Max double = " + max(list2));
    }//end main

    public static <E extends Comparable<E>> E max(E[] list) {

        E max = list[0];
        for (int i = 1; i < list.length; i++) {
            E e = list[i];
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }

        return max;
    }
}//end class Ex19_5
