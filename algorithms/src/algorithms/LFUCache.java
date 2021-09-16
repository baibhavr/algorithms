package algorithms;

import java.util.HashMap;

/**
* Maintain HashMap<Key, DoublyLinkedListNode>
* HashMap<Freq. of use, DoublyLinkedList>
* 1 DoublyLinkedList maintains Nodes for 1 freq. but in order of recently used. Recent item goes to tail, stale at head
*/
public class LFUCache {

	HashMap<Integer,Node> map;
    HashMap<Integer, DoublyLL> cache;
    int cap, leastFreq=1; // keeps track of leastfreq
    
    public LFUCache(int capacity) {
        cap = capacity;
        map = new HashMap<Integer,Node>();
        cache = new HashMap<Integer,DoublyLL>();
    }
    
    public int get(int key) {
        
        System.out.println("Get "+key);
        if(map.containsKey(key)){
            // get node
            Node cur = map.get(key);
                
            // update order
            remove(cur);
            cur.freq++;
            add(cur);
            
            return cur.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        System.out.println("Put "+key);
        
        Node cur;
        int freq;
        if(map.containsKey(key)){   // Key already exists so update
            cur = map.get(key);
            cur.freq++;     // Increament frequency
            remove(cur);    // remove from map and cache
        }
        else{   // No such key exists
            
            if(map.size()==cap)     // remove 1 element by LFU policy
                remove(getEvictNode());
            
            cur = new Node(); cur.key = key; cur.val = value;   // create a new node
        }
        
        add(cur);   // add to map and cache
    }
    
    public void remove(Node cur){
        
        // REMOVE from CACHE
        DoublyLL curDLL = cache.get(cur.freq);
        
        if(cur==curDLL.head && cur==curDLL.tail)
            curDLL.head = curDLL.tail = null;
            
        // if curNode is at head
        else if(cur == curDLL.head)
            (curDLL.head = cur.next).prev = null;

        // if curNode is at tail
        else if(curDLL.tail==cur)
            (curDLL.tail = cur.prev).next = null;
        
        // if curNode is in-between
        else
            (cur.prev.next   = cur.next).prev   = cur.prev;
        cur.next = cur.prev = null;
        
        // REMOVE from MAP
        map.remove(cur.key);
    }
    
    // Adds to tail
    public void add(Node cur){
                
        // add to cache
        if(cache.get(cur.freq)==null)
            cache.put(cur.freq,new DoublyLL());
        
        DoublyLL curDLL = cache.get(cur.freq);
        
        if(curDLL.head==null)
            curDLL.head = curDLL.tail = cur;
        else{
            (curDLL.tail.next = cur).prev = curDLL.tail;
            curDLL.tail = cur;
        }
        
        // add to map
        map.put(cur.key,cur);
    }
    
    // Get Node at head that needs to be evicted
    public Node getEvictNode(){
        Node evict = cache.get(leastFreq).head;
        return evict;
    }
        
    class DoublyLL{
        Node head, tail;
    }
    class Node{ // DLL Node
        int key,val,freq=1;
        Node prev,next;
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */