public class Algos {
    
    private Algos() {}

    public static void binarySearch(int val, int[] sortedArray, int lowIndex, int highIndex) {

        int midIndex = (lowIndex + highIndex)/2;

        // [1 2 3 4 5 6 7]
        // ex: val = 3, midIndex = 4
        if (val < sortedArray[midIndex]) {
            highIndex = midIndex - 1; // [1 2 3]
        }

        if (val > sortedArray[midIndex]) {

            lowIndex = midIndex + 1; // [5 6 7]
        }

        if (val == sortedArray[midIndex]) {
            System.out.println("value found!" + sortedArray[midIndex]);
            return;
        }

        binarySearch(val, sortedArray, lowIndex, highIndex);
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        
        binarySearch(3, arr, 0, 6);
        
    }
}
