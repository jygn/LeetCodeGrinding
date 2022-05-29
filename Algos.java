public class Algos {
    
    private Algos() {}


    // todo fix
    public static void binarySearch(int val, int[] sortedArray) {

        int lowIndex = 0;
        int highIndex = sortedArray.length - 1;

        int midIndex = sortedArray.length/2;

        // [1 2 3 4 5 6 7]
        // ex: val = 3, midIndex = 4
        if (val < sortedArray[midIndex]) {
            // split arr

            highIndex = midIndex - 1; // [1 2 3]
        }

        if (val > sortedArray[midIndex]) {

            lowIndex = midIndex + 1; // [5 6 7]
        }

        if (val == sortedArray[midIndex]) {
            System.out.println("value found!");
            return;
        }

        int[] subArr = new int[highIndex + 1];

        for (int i = lowIndex; i <= highIndex; i++) {

            subArr[i] = sortedArray[i];
        }

        binarySearch(val, subArr);
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        
        binarySearch(3, arr);
        
    }
}
