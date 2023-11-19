package M04.Programing_Assignments;

public class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0; // Number of elements in the list

    /** Create an empty list */
    public TwoWayLinkedList() {
    }

    /** Create a list from an array of objects */
    public TwoWayLinkedList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
        add(objects[i]);
    }

    /** Return the head element in the list */
    public E getFirst() {
        if (size == 0) {
            return null;
        }else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        }else {
            return tail.element;
        }
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // The new node is the only node in list
            tail = head;
    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
    Node<E> newNode = new Node<>(e); // Create a new node for e

    if (tail == null) {
        head = tail = newNode; // The only node in list
    }else {
        tail.next = newNode; // Link the new node with the last node
        tail = newNode; // tail now points to the last node
    }
    size++; // Increase size
    }
    /** Add a new element at the specified index
    * in this list. The index of the head element is 0
    */
    @Override
    public void add(int index, E e) {
        if (index == 0) addFirst(e); // Insert first
        else if (index >= size) addLast(e); // Insert last
        else { // Insert in the middle
            Node<E> current = head;
            for (int i = 1; i < index; i++)
            current = current.next;
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }
    /** Remove the head node and
    * return the object that is contained in the removed node. */
    public E removeFirst() {
        if (size == 0) {
            return null;//Nothing to delete
        } else{
            Node<E> temp = head; // Keep the first node temporarily
            head = head.next; // Move head to point to next node
            size--; // Reduce size by 1
        if (head == null) tail = null; // List becomes empty
            return temp.element; // Return the deleted element
        }
    }
    /** Remove the last node and
    * return the object that is contained in the removed node. */

    public E removeLast() {
        if (size == 0 || size == 1) {
            return removeFirst();
        }else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
            current = current.next;
            }
        E temp = tail.element;
        tail = current;
        tail.next = null;
        size--;
        return temp;
        }
    }
    /** Remove the element at the specified position in this
    * list. Return the element that was removed from the list. */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) return null; // Out of range
        else if (index == 0) return removeFirst(); // Remove first
        else if (index == size - 1) return removeLast(); // Remove last
        else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
            previous = previous.next;
            }
        Node<E> current = previous.next;
        previous.next = current.next;
        size--;
        return current.element;
        }
    }
    /** Override toString() to return elements in the list */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            }else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    /** Clear the list */
    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    /** Return true if this list contains the element e */
    @Override
    public boolean contains(Object e) {
    // Left as an exercise
        return true;
    }

    /** Return the element at the specified index */
    @Override
    public E get(int index) {
    // Left as an exercise
        return null;
    }

    /** Return the index of the first matching element in
    * this list. Return −1 if no match. */
    @Override
    public int indexOf(Object e) {
    // Left as an exercise
        return 0;
    }

    /* Return the index of the last matching element in
    * this list. Return −1 if no match.
    * */
    @Override
    public int lastIndexOf(E e) {
    // Left as an exercise
        return 0;
    }
    /** Replace the element at the specified position
    * in this list with the specified element. */
    @Override
    public E set(int index, E e) {
    // Left as an exercise
        return null;
    }

    /** Override iterator() defined in Iterable */
    @Override
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements java.util.Iterator<E> {
        private Node<E> current = head; // Current index

    @Override
    public boolean hasNext() {
        return (current != null);
    }

    @Override
    public E next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

}


