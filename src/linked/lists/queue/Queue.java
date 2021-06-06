package linked.lists.queue;

public class Queue<Item> {
    Node<Item> head;
    Node<Item> tail;
    int length = 0;

    //Add a new item to the back of the queue
    public void enqueue(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.data = item;

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node<Item> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
            tail = newNode;
        }
        length++;
    }

    //Removes an item from the front of the queue, and returns its data
    public Item dequeue() {
        if (head == null) {
            throw new IndexOutOfBoundsException("The linked list is empty.");
        }
        Item item = head.data;
        if(head.next != null) {
            head = head.next;
            head.previous = null;
            length--;
        }
        else {
            head = null;
            length--;
        }
        return item;
    }

    //Checks if the queue is empty
    public boolean isEmpty() {
        return length == 0;
    }

    //Return the current size of the queue
    public int size() {
        return length;
    }
}
