import java.util.*;

public class LRUCache {
	class Node {
        int val;
        int key;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public int cap;
    public int size;
    public int head;
    public int tail;
    public Map<Integer,Node> map;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.map = new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        if(node.key != head) {toHead(node);}
        return node.val;
    }
    
    public void put(int key, int value) {
    	Node node = map.getOrDefault(key,new Node(key,value));
        if(!map.containsKey(key)) {
            if(size == 0) {
                head = key;
                tail = key;
            } else {
                Node currHead = map.get(head);
                currHead.prev = node;
                node.next = currHead;
                head = key;
            }
            size++;
            if(size > cap) {
                Node currTail = map.get(tail);
                Node newTail = currTail.prev;
                newTail.next = null;
                map.remove(tail);
                tail = newTail.key;
                size--;
            }
        } else {
            node.val = value;
            if(node.key != head) {
                toHead(node);
            }
        }
        map.put(key,node);
    }
    
    void toHead(Node node) {
        // update tail
        if(node.key == tail) {
        	tail = node.prev.key;
        }
        // remove node
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        if(next != null) next.prev = prev;
        // update head
        Node currHead = map.get(head);
        currHead.prev = node;
        node.next = currHead;
        node.prev = null;
        head = node.key;
    }

}
