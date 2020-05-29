package classes.data_structures;

interface QueueInterface<T>{
    public void Enqueue(T value);
    public T Dequeue();
    public T Peek();
    public boolean IsEmpty();
    public void Empty();
}

/**
 * @param <T> that define the data type
 */
class QueueNode<T> {

    private T key;
    private QueueNode<T> next;

    /**
     * constructor of the class QueueNode
     *
     * @param key to be stored
     */
    QueueNode(T key) {
        this.key = key;
        this.next = null;
    }

    /**
     * key is the data that is stored into the node
     *
     * @HasGetter
     * @HasSetter
     * @return key stored in the node
     */
    public T getKey() {
        return this.key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    /**
     * next is a pointer to the next node in the Queue
     *
     * @HasGetter
     * @HasSetter
     * @return next node pointer
     */
    public QueueNode<T> getNext() {
        return this.next;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }
}

/**
 * @param <T> that define the data type
 */
public class Queue<T> implements QueueInterface<T>{
    
    private QueueNode<T> head, tail;
    private int size;

    /**
     * Constructor of the class Queue
     */
    public  Queue() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * Constructor of the class Queue
     * 
     * @param head of the Queue to reconstructed
     */
    public Queue(QueueNode<T> head){
        this.head = head;
        this.size = 0;
        StablishQueue();
    }
    
    /**
     * Function that reconstruct a Queue given a head QueueNode
     */
    private void StablishQueue(){
        QueueNode<T> stablishNode = this.head;
        
        if (this.head == null) this.tail = null;
        else if (stablishNode.getNext() == null){
            this.size = 1;
            this.tail = this.head;
        }
        else{
            while(stablishNode.getNext() != null){
                stablishNode = stablishNode.getNext();
                this.size++;
            }
            this.size++;
            this.tail = stablishNode;
        }
    }
    
    /**
     * Function that say if the Queue is empty
     * 
     * @return if the Queue is empty or not
     */
    @Override
    public boolean IsEmpty() {
        return this.head == null;
    }

    /**
     * Funtion that enqueue a new node into the Queue
     * 
     * @param value to be stored
     */
    @Override
    public void Enqueue(T value) {
        QueueNode<T> newNode = new QueueNode<>(value);

        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }

        this.tail = newNode;
        this.size++;
    }

    /**
     * Function that dequeue the first node in the Queue
     * 
     * @return the data of the dequeued node
     */
    @Override
    public T Dequeue() {
        QueueNode<T> oldNode = this.head;

        if (this.size == 0) {
            return null;
        }

        this.head = this.head.getNext();
        this.size--;

        if (this.size == 0) {
            this.tail = null;
        }

        return oldNode.getKey();
    }

    /**
     * Funtion that show the data stored into the first node
     * 
     * @return key of the first node
     */
    @Override
    public T Peek() {
        if (this.size == 0) {
            return null;
        }
        return this.head.getKey();
    }

    /**
     * Function that empties the Queue
     */
    @Override
    public void Empty() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * size is the value that stores how many nodes there is in the Queue
     * 
     * @HasGetter 
     * @HasSetter
     * @return size of the Queue
     */
    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 
     * @HasGetter
     * @HasSetter
     * @return head
     */
    public QueueNode<T> getHead() {
        return head;
    }

    public void setHead(QueueNode<T> head) {
        this.head = head;
    }
    
}
