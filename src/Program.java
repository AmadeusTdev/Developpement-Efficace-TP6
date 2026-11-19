import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static ArrayList<Integer> randomInit(ArrayList<Integer> list, int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt()%50); // Random integers between 0 and 49
        }
        return list;
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> list, int index) {
        if (list.size() <= 1) {
            return list; // No need to sort an empty or single-element list
        }

        // Partitionnement
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> middle = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        // Sort
        for (Integer element : list) {
            if (element == list.get(index)) {
                middle.add(element);
            } else if (element < list.get(index)) {
                left.add(element);
            } else {
                right.add(element);
            }
        }

        left = quickSort(left, 0);
        right = quickSort(right, 0);

        list.clear();
        list.addAll(left);
        list.addAll(middle);
        list.addAll(right);

        return list;
    }
    public static void main(String[] args) {
        // Question 1
        DoublyListClass list1 = new DoublyListClass();
        list1.addLast(5);
        list1.addLast(2);
        list1.addLast(8);
        list1.addLast(1);
        System.out.println("Original list (bubblesort): " + list1);
        list1.bubbleSort();
        System.out.println("Sorted list (bubblesort): " + list1);

        // Question 2
        ArrayList<Integer> myArrayList = new ArrayList<>();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(4);
        myArrayList.add(11);
        myArrayList.add(8);
        myArrayList.add(2);
        myArrayList.add(0);
        myArrayList.add(1);

        System.out.println("Original ArrayList (quicksort): " + myArrayList);
        myArrayList = quickSort(myArrayList, 0);
        System.out.println("Sorted ArrayList (quicksort): " + myArrayList);

        // Question 3
        ArrayList<Integer> randomList = new ArrayList<>();
        randomList = randomInit(randomList, 100000000);

        //System.out.println("Random ArrayList (quicksort): " + randomList);
        long startTime = System.nanoTime();
        randomList = quickSort(randomList, 0);
        System.out.println("Time taken: " + (System.nanoTime() - startTime)/1000000 + " ms");
        //System.out.println("Sorted Random ArrayList (quicksort): " + randomList);

        
    }
}