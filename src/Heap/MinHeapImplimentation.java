package Heap;
import java.util.ArrayList;
class MinHeap<T extends Comparable<T>>{
    private int size;
    private ArrayList<T> minHeap;

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int leftChild(int i ){
        return 2*i;
    }
    public int rightChild(int i ){
        return 2*i+1;
    }
    public int parent(int i ){
        return i/2;
    }
    public void swap(int i , int j){
        T temp = minHeap.get(i);
        minHeap.set(i , minHeap.get(j));
        minHeap.set(j , temp);
    }
    public boolean greater(int i , int j){
        return minHeap.get(i).compareTo(minHeap.get(j)) > 0;
    }
    public void swim(int i ){
        while(i > 1 && greater(i , parent(i))){
            swap(i , parent(i));
            i = parent(i);
        }
    }
    public void sink(int i){
        while(leftChild(i) <= size){
            int min = leftChild(i);
            if(rightChild(i) <= size && greater(leftChild(i) , rightChild(i))){
                min = rightChild(i);
            }
            minHeap.set(i , minHeap.get(min));
            i = min;
        }
    }
    public void add(T elem){
        minHeap.add(elem);
        size++;
        swim(size);
    }
    public void deleteHead(){
        minHeap.set(1 , minHeap.get(size));
        minHeap.remove(size);
        size--;
        sink(1);
    }
    public T getPeek(){
        if(isEmpty()){
            System.out.println("Heap is Empty ");
            return null;
        }
        return minHeap.get(1);
    }
    public void heapify(T[] arr){
        for(T elem : arr){
            minHeap.add(elem);
        }
        int n = size/2;
        for(int i = n ; i >= 1; i = parent(i)){
            sink(i);
        }
    }




}
public class MinHeapImplimentation {

}
