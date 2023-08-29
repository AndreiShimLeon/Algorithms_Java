//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Main {
    public Main() {
    }

    public static void Swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void ShakeSort(int[] array) {
        for(int i = 0; i < array.length; ++i) {
            int j;
            for(j = i; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    Swap(array, j, j + 1);
                }
            }

            for(j = array.length - i - 2; j > i; --j) {
                if (array[j] < array[j - 1]) {
                    Swap(array, j - 1, j);
                }
            }
        }

    }

    public static void BubbleSort(int[] array) {
        for(int i = 0; i < array.length; ++i) {
            for(int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    Swap(array, j, j + 1);
                }
            }
        }

    }

    public static void SelectionSort(int[] array) {
        for(int i = 0; i < array.length - 1; ++i) {
            int minPosition = i;

            for(int j = i + 1; j < array.length; ++j) {
                if (array[minPosition] > array[j]) {
                    minPosition = j;
                }
            }

            if (minPosition != i) {
                Swap(array, minPosition, i);
            }
        }

    }

    public static void InsertionSort(int[] array) {
        for(int i = 0; i < array.length - 1; ++i) {
            for(int j = i + 1; j < array.length; ++j) {
                if (array[i] > array[j]) {
                    Swap(array, i, j);
                }
            }
        }

    }

    public static void QuickSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        Qsort(array, left, right);
    }

    public static void Qsort(int[] array, int left, int right) {
        if (array.length != 0 && array.length == 1) {
        }

        int minimumIndex = left;
        int maximumIndex = right;
        int pivot = (left + right) / 2;

        while(minimumIndex <= maximumIndex) {
            while(array[minimumIndex] < array[pivot]) {
                ++minimumIndex;
            }

            while(array[maximumIndex] > array[pivot]) {
                --maximumIndex;
            }

            if (minimumIndex <= maximumIndex) {
                if (minimumIndex < maximumIndex) {
                    Swap(array, minimumIndex, maximumIndex);
                }

                --maximumIndex;
                ++minimumIndex;
            }
        }

        if (minimumIndex < right) {
            Qsort(array, minimumIndex, right);
        }

        if (maximumIndex > left) {
            Qsort(array, left, maximumIndex);
        }

    }

    public static void main(String[] args) {
        int[] numbers = new int[]{4, 55, 1, 32, 5, 12, 92, 14, 12, 2, 5, 7, 2, 6, 8, 12};
        QuickSort(numbers);
        int[] var2 = numbers;
        int var3 = numbers.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int number = var2[var4];
            System.out.print("" + number + " ");
        }

    }
}
