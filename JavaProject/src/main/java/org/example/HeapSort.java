package org.example;

public class HeapSort {
    public static void Swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static void PyramidSort(int[] array){
        // Построение кучи (перегруппировка массива)
        for (int i = array.length/2-1; i >= 0 ; i--) {
            Heapify(array, array.length, i);
        }
        for (int i = array.length-1; i >=0 ; i--) {
            Swap(array, 0, i); //извлекаем корень в конец
            Heapify(array, i, 0); // уменьшаем кучу и повторяем
        }

    }

    public static void Heapify(int[]array, int heapSize, int rootIndex){
        // сначала наибольший элемент как корень
        int largest = rootIndex;
        int leftChild = 2*rootIndex+1;
        int rightChild = 2*rootIndex+2;
        if(leftChild < heapSize && array[leftChild] > array[largest]){
            largest = leftChild; // если левый ребенок есть и больше родителя
        }
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;// если правый ребенок есть и больше родителя
        }
        if (largest != rootIndex) { // если самый большой элемент не родитель
            Swap(array, rootIndex, largest); //наибольший элемент в корень
            Heapify(array, heapSize, largest); // рекурсия на измененного ребенка
        }
    }
}
