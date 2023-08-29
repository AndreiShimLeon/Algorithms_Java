package org.example;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.lang.reflect.Type;
import java.util.Date;

public class Main {

    public static void Test(){
        int n = 100000;
        int [] arr1 = new int[n];
        int [] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            int number = (int) (Math.random() * 1000);
            arr1[i] = number;
            arr2[i] = number;
        }
        Date start = new Date();
        ShakeSort(arr1);
        Date end = new Date();
        long ShakeSortTime = end.getTime() - start.getTime();
        start = new Date();
        MergeSort(arr1);
        end = new Date();
        long MStime = end.getTime() - start.getTime();
        System.out.printf("ShakeSortTime = %d, MStime = %d", ShakeSortTime, MStime);

    }
    public static void Swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static int[] buffer = new int[100000];
    public static void MergeSort(int[] array){
        MSort(array, 0, array.length-1);
    }

    public static void MSort(int[] array, int left, int right){
//        if(array.length != 0 && array == 1){
        if(left == right){
            return;
        }
        int mid = (left+right)/2;
        MSort(array, left, mid);
        MSort(array, mid+1, right);
        int left_index = left, right_index = mid+1, counter = left;
        while (left_index <= mid && right_index <= right){
            if(array[left_index] < array[right_index]){
                buffer[counter++] = array[left_index++];
            } else{
                buffer[counter++] = array[right_index++];
            }
        }
        while (left_index <= mid){
            buffer[counter++] = array[left_index++];
        }
        while (right_index <= right){
            buffer[counter++] = array[right_index++];
        }
        for (int i = left; i <= right ; i++) {
            array[i] = buffer[i];
        }

    }
    public static void ShakeSort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            int j;
            for (j = i; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    Swap(array, j, j + 1);
                }
            }

            for (j = array.length - i - 2; j > i; --j) {
                if (array[j] < array[j - 1]) {
                    Swap(array, j - 1, j);
                }
            }
        }

    }

    public static void BubbleSort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    Swap(array, j, j + 1);
                }
            }
        }

    }

    public static void SelectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int minPosition = i;

            for (int j = i + 1; j < array.length; ++j) {
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
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
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

        while (minimumIndex <= maximumIndex) {
            while (array[minimumIndex] < array[pivot]) {
                ++minimumIndex;
            }

            while (array[maximumIndex] > array[pivot]) {
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

    public static int BinarySearch(int[] arr, int value){
        int left = 0, right = arr.length - 1;
        while(right - left > 1){
            int mid = (left + right) / 2;
            if(arr[mid] < value)
                left = mid;
            else
                right = mid;
        }
        if(arr[left] == value)
            return left;
        if(arr[right] == value)
            return right;
        return -1;
    }
    public static int BinarySearch_myVersion(int[] array, int value) {
        return BSearch(array, value, 0, array.length -1);
    }

    private static int BSearch(int[] array, int value, int left, int right){
        if (left == right && left != value){
            return -1;
        }
        int mid = (right+left)/2;
        if (array[mid] == value){
            return mid;
        }else if (array[mid] > value){
            return BSearch(array, value, left, mid-1);
        } else{
            return BSearch(array, value, mid+1,right);
        }
    }
    public static void PrintArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{4, 55, 1, 32, 5, 12, 92, 14, 12, 2, 5, 7, 2, 6, 8, 12};
        System.out.println("Array: ");
        PrintArray(numbers);
////        BubbleSort(numbers);
////        ShakeSort(numbers);
////        InsertionSort(numbers);
////        SelectionSort(numbers);
////        QuickSort(numbers);
        MergeSort(numbers);
        System.out.println("Sorted array: ");
        PrintArray(numbers);

//        Test();
        System.out.println(BinarySearch(numbers, 5));
    }
}