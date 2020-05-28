package classes.data_structures;

interface StackInterface<T> {
    public void Push(T value);
    public T Pop();
    public T Top();
    public boolean IsEmpty();
    public void Empty();
}

/**
 * @param <T> that define the data type
 */
class StackNode<T> {

    private T key;
    private StackNode<T> next;

    /**
     * constructor of the class StackNode
     *
     * @param key to be stored
     */
    StackNode(T key, StackNode<T> next) {
        this.key = key;
        this.next = next;
    }

    /**
     * key is the data that is stored into the node
     * 
     * @HasGetter 
     * @HasSetter
     * @return key stored in the node
     */
    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    /**
     * next is a pointer to the next node in the Stack
     * 
     * @HasGetter 
     * @HasSetter
     * @return next node pointer
     */
    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }
}

/**
 * @param <T> that define the data type
 */
public class Stack<T> implements StackInterface<T>{
    
    private StackNode<T> head;
    private int size;

    /**
     * Constructor of the class Stack
     */
    Stack() {
        this.size = 0;
        this.head = null;
    }

    /**
     * Constructor of the class Stack
     * 
     * @param head of the Stack to be reconstructed
     */
    Stack(StackNode<T> head){
        this.head = head;
        this.size = 0;
        StablishStack();
    }

    /**
     * Function that reconstruct a Stack given a head StackNode
     */
    private void StablishStack(){
        if (this.head == null) return;

        StackNode<T> stablishNode = this.head;

        if (stablishNode.getNext() == null) this.size = 1;
        else{
            while(stablishNode.getNext() != null){
                stablishNode = stablishNode.getNext();
                this.size++;
            }
            this.size++;
        }
    }

    /**
     * Function that say if the Stack is empty
     *
     * @return if the Stack is empty or not
     */
    @Override
    public boolean IsEmpty() {
        return this.head == null;
    }

    /**
     * Function that push a new node into the Stack
     *
     * @param value to be stored
     */
    @Override
    public void Push(T value) {
        StackNode<T> newNode = new StackNode<>(value, this.head);
        this.head = newNode;
        this.size++;
    }

    /**
     * Function that pop the top node
     * 
     * @return key of the popped node
     */
    @Override
    public T Pop() {
        StackNode<T> oldNode = this.head;

        if (this.size == 0) {
            return null;
        }

        this.head = this.head.getNext();
        this.size--;
        return oldNode.getKey();
    }

    /**
     * Function that show the value stored in the top node
     * 
     * @return key of the top node
     */
    @Override
    public T Top() {
        if (size == 0) {
            return null;
        }
        return this.head.getKey();
    }

    /**
     * Function that empties the Stack
     */
    @Override
    public void Empty() {
        this.size = 0;
        this.head = null;
    }

    /**
     * size is the value that stores how many nodes there is in the Stack
     * 
     * @HasGetter 
     * @HasSetter
     * @return size of the Stack
     */
    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
