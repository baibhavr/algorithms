package algorithms;

import java.util.HashMap;

/**
* Use Doubly Linked List to maintain order of use(pu/get)
* Use HashMap for constant time access of those nodes in DLL using key
*/
class LRUCache {

    Node head, tail;
    HashMap<Integer,Node> cache;
    int cap;
    
    public LRUCache(int capacity) {
        cache = new HashMap<Integer,Node>();
        cap = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            
            Node cur = cache.get(key);
            remove(cur);    // Re-attach it to recently used end of DLL
            append(cur);
            return cur.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node cur;
        if(cache.containsKey(key)){    // already exists
            (cur = cache.get(key)).val = value;
            remove(cur);    // removes from Linkedlist & hashMap
        }
        else{
            cur = new Node(key,value);
            if(cache.size()==cap)  // cache is full
                remove(head);
        }
        append(cur);
    }

    public void remove(Node cur){
        
        Node before = cur.prev;
        Node after  = cur.next;

        if(cur==head && cur==tail)  // only 1 item and size 1
            head = tail = null;
        else if(cur==head)  // cur at the head
            (head = after).prev = null;
        else if(cur==tail)  // cur at the tail
            (tail = before).next = null;
        else{// cur in the middle
            before.next = after;
            after.prev  = before;
        }
        cache.remove(cur.key);
        cur.prev = cur.next = null;
    }
    
    public void append(Node cur){

        if(tail==null)
            head = tail = cur;
        else{
            tail.next = cur;
            cur.prev = tail;
            tail = cur;
        }
        cache.put(cur.key,cur);
    }
    
    class Node{
        int key,val;
        Node prev,next;
        Node(int k,int v){
            key=k;
            val=v;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


/* * ["LRUCache","put","put","put","get","put","get","get","get"]
[[3],[1,17],[2,1],[3,19],[1],[4,19],[2],[3],[4]]

["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]

["LRUCache","get","put","get","put","put","get","get"]
[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
 */
