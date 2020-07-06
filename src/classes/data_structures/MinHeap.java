package classes.data_structures;

import java.util.ArrayList;

class MinHeap {
    int size;
    ArrayList<Integer> heap;

    public MinHeap(){
        this.size = 0;
        this.heap = new ArrayList<>();
    }

    public int ExtractMin(){
        if (size == 0)
            return 0;
        if (size ==1){
            int last = heap.get(0);
            heap.remove(0);
            this.size--;
            return last;
        }

        int lastMin = heap.get(0);

        heap.set(0, heap.get(size-1));
        SiftDown(0);
        size--;

        return lastMin;
    } 

    public void Add(int value){
        heap.add(size, value);

        SiftUp(size);
        size++;
    }

    public void Swap(int firstPos, int secondPos){ 
        int temporal = heap.get(firstPos); 
        heap.set(firstPos, heap.get(secondPos)); 
        heap.set(secondPos, temporal);
    }

    public void ChangePriority(int indexToChange, int priority){
        int oldPriority = heap.get(indexToChange);
        heap.set(indexToChange, priority);
        

        if (priority < oldPriority)
            SiftUp(indexToChange);
        else
            SiftDown(indexToChange);
    }

    public void SiftUp(int index){

        while (index > 0 && heap.get(index) < heap.get(getParentIndex(index))){
            int parent = getParentIndex(index);

            Swap(index, parent);

            index = parent;
        }
    }

    public void SiftDown(int index){
        int left = getLeftIndex(index);
        int right = getRightIndex(index);
        int minimum = index;

        if (right != -1 && heap.get(right) < heap.get(minimum))
            minimum = right;
        if (left != -1 && heap.get(left) < heap.get(minimum))
            minimum = left;

        if (minimum != index) {
            Swap(index, minimum);

            SiftDown(minimum);
        }
    }

    private int getParentIndex(int index){
        return (int) ((index - 1) / 2);
    }

    private int getLeftIndex(int index){
        int calculate = (index * 2) + 1;

        if (calculate < this.size)
            return (index * 2) + 1;
        else return -1;
    }

    private int getRightIndex(int index){
        int calculate = (index * 2) + 2;

        if (calculate < this.size)
            return calculate;
        else return -1;
    }

    public int getMin(){
        return heap.get(0);
    }

    public int getSize(){
        return this.size;
    }
}