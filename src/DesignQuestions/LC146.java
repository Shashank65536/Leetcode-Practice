package DesignQuestions;

import java.util.*;

public class LC146 {

    class Node{
        int key;
        int value;
    }
    int capacity;
    Map<Integer, Node> map;
    Deque<Node> dq;
    public LC146(int capacity) {
        this.capacity = capacity;
        dq = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        Node nodeToReturn = map.get(key);

        dq.remove(nodeToReturn);
        dq.addFirst(nodeToReturn);

        return nodeToReturn.value;

    }

    public void put(int key, int value) {
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        if(dq.size() < capacity){

            dq.addFirst(newNode);
            map.put(key,newNode);
        }else{
            Node n = dq.pollLast();
            map.remove(n.key);
            dq.addFirst(newNode);
            map.put(key,newNode);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */