import java.util.Arrays;

public class MinPQ<Key extends Comparable<Key>> {
    //A Standard priority queue for managing events
    private Key[] pq;
    private int size;
    
    public MinPQ(int capacity){
        pq = (Key[]) new Comparable[capacity + 1];
        size = 0;
    }
    public int size(){
        return size;
    }
    public void insert(Event e){

    }
    public void deleteMin(){

    }
    public boolean isEmpty(){
        return size == 0;
    }
}