import java.util.HashMap;
import java.util.Map;

class LFUCache {
    private static class Node {
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    private static class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;
            Node lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        }
    }

    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Node> cacheMap;
    private final Map<Integer, DoublyLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cacheMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        Node node = cacheMap.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        if (cacheMap.size() >= capacity) {
            DoublyLinkedList minFreqList = frequencyMap.get(minFrequency);
            Node evictedNode = minFreqList.removeLast();
            if (evictedNode != null) {
                cacheMap.remove(evictedNode.key);
            }
        }

        Node newNode = new Node(key, value);
        cacheMap.put(key, newNode);
        minFrequency = 1;
        
        DoublyLinkedList list = frequencyMap.computeIfAbsent(1, k -> new DoublyLinkedList());
        list.addFirst(newNode);
    }

    private void updateFrequency(Node node) {
        int currentFreq = node.frequency;
        DoublyLinkedList oldList = frequencyMap.get(currentFreq);
        oldList.remove(node);

        if (currentFreq == minFrequency && oldList.size == 0) {
            minFrequency++;
        }

        node.frequency++;
        DoublyLinkedList newList = frequencyMap.computeIfAbsent(node.frequency, k -> new DoublyLinkedList());
        newList.addFirst(node);
    }
}
