public class SelectionSort {

    public static void main(String[] args) {

        int arr[] = {64, 25, 12, 22, 11};

        int n = arr.length;

        // Selection Sort
        for (int i = 0; i < n - 1; i++) {

            int min = i;

            // Find smallest element
            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // Swap
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        // Print sorted array
        System.out.println("Sorted Array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}