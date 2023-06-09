import java.util.ArrayList;

import java.util.Arrays;



public class Midterm_1B {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(14);

        list.add(24);

        list.add(14);



        ArrayList<Integer> newList = removeDuplicatesGeneric(list);

        System.out.print(newList);

        System.out.println();



        String[] names = {"bob", "susan", "bob"};

        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(names));

        stringList = removeDuplicatesGeneric(stringList);

        System.out.print(stringList);

        System.out.println();

    }



    public static <T> ArrayList<T> removeDuplicatesGeneric(ArrayList<T> list) {

        //make arrayList result
        ArrayList<T> result = new ArrayList<T>();

        for (T item : list) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

}