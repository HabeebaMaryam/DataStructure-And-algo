package Heap;

import java.util.ArrayList;

class Heap<T extends Comparable<T>>{
    private ArrayList<T> heap;
    private int size ;

    Heap(){
        heap = new ArrayList<>();
        size = 0;
        heap.add(null);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size == 0)return true;
        return false;
    }
    public int parent (int i ){
        return i/2;
    }
    public int leftChild(int i ){
        return 2 * i;
    }
    public int rightChild(int i) {
        return 2 * i + 1;
    }
    public void swap(int i , int j ){
        T temp = heap.get(i);
        heap.set(i , heap.get(j));
        heap.set(j , temp);
    }

    public void insert(T element ){
        heap.add(element);
        int i = ++size;

        while(i > 1 && heap.get(i).compareTo(heap.get(parent(i))) > 0){
            swap(i , parent(i));
            i = parent(i);
        }
    }

    public void deleteTop(){
        int len = size();
        if(isEmpty()){
            System.out.println("Heap is empty ");
            return ;
        }
        heap.set(1 , heap.get(len));

//        Removes last node
        size--;
//        propagate the root to correct position
//
//        heap.get(i).compareTo( heap.get(left)) < 0
//        heap.get(i): This retrieves the element at index i from the heap (the ArrayList). Remember that the heap implementation often starts indexing at 1 (rather than 0), so i would typically be a valid index within the heap structure.
//        heap.get(left): This retrieves the element at index left from the heap. The variable left (or leftChild in some versions) usually represents the index of the left child of the node at index i in the binary heap.
//                        .compareTo(heap.get(left)): This is the core of the comparison. The compareTo() method is called on the element retrieved from heap.get(i), and the element retrieved from heap.get(left) is passed as the argument. The compareTo() method returns an integer value with the following meaning:
//        Positive value ( > 0): This means that the element at index i is "greater than" the element at index left according to the natural ordering defined by the class of the elements stored in the heap. For example, if you are storing Integers, compareTo will return a positive value if heap.get(i) represents a larger number than heap.get(left).
//         Zero ( == 0): This means that the element at index i is "equal to" the element at index left.
//         Negative value ( < 0): This means that the element at index i is "less than" the element at index left.
//         > 0: This part of the expression checks if the result of compareTo() is greater than 0. If it is, it means that the element at index i is considered "greater than" the element at index left.
        int i = 1;
        while(i <= size){
            int left = leftChild(i);
            int right = rightChild(i);
            if(left < size && heap.get(i).compareTo( heap.get(left)) < 0){
                swap(i, left);
                i = left;
            }
            else if(right < size && heap.get(i).compareTo( heap.get(right)) < 0){
                swap(i , right);
                i = right;
            }
            else{
                break;
            }
        }

    }

    public void swim(int i ){

    }



    public void heapify(ArrayList<T> heap ){

    }

    public void print(){
        for(int i = 1; i <= size; i++){
            System.out.println(heap.get(i));
        }
    }
}

public class HeapImplimentationUsingArray {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<Integer>();
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.deleteTop();
        heap.print();
    }
}
