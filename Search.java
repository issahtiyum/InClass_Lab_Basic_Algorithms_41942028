import java.util.Arrays;
import java.util.Scanner;

public class Search {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int [] myArray = {2, 5, 8, 3, 4, 6, 10, 15, 20, 1, 11};

    // Task 1
    System.out.print("Which value do you want to find? ");
    int value = input.nextInt();
    int desiredIndex = -1;

    for(int i = 0; i < myArray.length; i++) {
      if (value == myArray[i]) {
        desiredIndex = i;
      }
    }
    if (desiredIndex != -1) {
      System.out.println("The index of " + value + " is " + desiredIndex);
    } else {
      System.out.println("This value is not available in the array");
    }

    // Task 2

    System.out.println("What is the index of the first value you want to swap? ");
    int firstIndex = input.nextInt();

    System.out.println("What is the index of the second value you want to swap? ");
    int secondIndex = input.nextInt();

    if (firstIndex <= myArray.length - 1 && secondIndex <= myArray.length - 1 ) {
      int tempValue = myArray[firstIndex];
      myArray[firstIndex] = myArray[secondIndex];
      myArray[secondIndex] = tempValue;

      System.out.println("The new array: " + Arrays.toString(myArray));
    } else {
      System.out.println("One of the indeces is not bound in the array ");
    }

    // Task 3

    int[] dummyArray1 = new int[myArray.length];
    int[] dummyArray2 = new int[myArray.length];

    for (int i = 0; i < myArray.length; i++) {
        dummyArray1[i] = myArray[i];
        dummyArray2[i] = myArray[i];
    }

    int[] ascArray = new int[myArray.length];
    int[] descArray = new int[myArray.length];
    
    
    for (int i = 0; i < ascArray.length; i++) {
      int smallestNum = dummyArray1[0];
      int smallestIndex = 0;
      for (int j = 0; j < dummyArray1.length; j++){
        if (dummyArray1[j] < smallestNum) {
          smallestNum = dummyArray1[j];
          smallestIndex = j;
        }
      }
      ascArray[i] = smallestNum;
      dummyArray1[smallestIndex] = 1000; // Since we cannot remove the values, we just set it at a high value that no other number can reach.
    }
    System.out.println("String in ascending order: " + Arrays.toString(ascArray));

    for (int i = 0; i < descArray.length; i++) {
      int largestNum = dummyArray2[0];
      int largestIndex = 0;
      for (int j = 0; j < dummyArray2.length; j++){
        if (dummyArray2[j] > largestNum) {
          largestNum = dummyArray2[j];
          largestIndex = j;
        }
      }
      descArray[i] = largestNum;
      dummyArray2[largestIndex] = -1000; // Since we cannot remove the values, we just set it at a very low value that no other number can reach.
    }

    System.out.println("String in descending order: " + Arrays.toString(descArray));


  // Task 4 
    System.out.print("Which value do you want to find? ");
    int desiredValue = input.nextInt();
    int desiredValueIndex = -1;

    for(int i = 0; i < myArray.length; i++) {
      if (desiredValue == myArray[i]) {
        desiredValueIndex = i;
      }
    }
    if (desiredValueIndex != -1) {
      System.out.println(desiredValueIndex);
    } else {
      System.out.println("This value is not available in the array");
    }

    // Task 5

    System.out.print("Which value do you want to find? ");
    int target = input.nextInt();
    boolean found = false;
    
    int low = 0;
    int high = ascArray.length - 1;

    
    while (low <= high) {
      int middle = (high + low) / 2;

      if (ascArray[middle] == target) {
        System.out.println("The index of " + target + " is " + middle);
        found = true;
        break;
      } else if (ascArray[middle] < target) {
        low = middle + 1;
      } else if (ascArray[middle] > target) {
        high = middle - 1;
      }
    }

    if (!found) {
      System.out.println("The value was not found in the array");
    }


    input.close();
  }
}
