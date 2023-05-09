import java.util.ArrayList;
import java.util.Random;

public class Ex19_3 {
    public static void main(String[] args) {

        //create arraylist of integers
        ArrayList<Integer> nums = new ArrayList<>(100);

        //create arraylist of characters
        ArrayList<Character> letters = new ArrayList<>(100);


        //generate 100 nums between 0 and 9 inclusive and add them to nums
        for(int i = 0; i <= 100; i++){
            Random random = new Random();
            int randomInt = random.nextInt(10);
            nums.add(randomInt);
        }

        //generate 100 characters between 0 and 9 inclusive and add them to letters
        for(int i = 0; i <= 100; i++){
            Random random = new Random();
            char letter = (char)(random.nextInt(26) + 'a');
            letters.add(letter);
        }

        //before removeDuplicates
        System.out.println(nums);
        System.out.println(letters);

        // set NewList equal to removeDuplicates on nums
        ArrayList<Integer> newList = removeDuplicates(nums);

        //set NewLetters equal to removeDuplicates on letters
        ArrayList<Character> newLetters = removeDuplicates(letters);

        // Print the ArrayLists with duplicates removed
        System.out.println("ArrayList (nums) after duplicates have been removed: " + newList);
        System.out.println("ArrayList (letters) after duplicates have been removed: " + newLetters);
    }//end main
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){

        //create new list
        ArrayList<E> list2 = new ArrayList<>(list.size());

        // Traverse through the first list
        for (E element : list) {

            if (!list2.contains(element)) {

                list2.add(element);
            }
        }
        return list2;
    }

}//end class Ex19_3
