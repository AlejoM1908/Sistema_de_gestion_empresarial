package classes.data_structures;

interface HashMapsInterface{
    public void Add();
    public HashNode Remove();
}

class HashNode<K, V>{
    private K key;
    private V value;
    private HashNode<K, V> next;

    public HashNode(K key, V value, HashNode<K, V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey (){
        return key;
    }
}