package com.solvd.onlineshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList<T> {
	private final static Logger logger = LogManager.getLogger(LinkedList.class.getName());
	private Node<T> head;
	private Node<T> tail;
	private Integer size;

	public LinkedList() {
		this.head = null;
		this.size = 0;
		this.tail = null;
	}

	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			 tail.setNext(newNode);
	         newNode.setPrev(tail);
	         tail = newNode;
		}
		size++;
	}
	
	public void insertAt(Integer index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            newNode.setNext(head);
            if (head != null) {
                head.setPrev(newNode);
            }
            head = newNode;
            if (size == 0) {
                tail = newNode;
            }
        } else if (index == size) {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            newNode.setPrev(current);
            current.getNext().setPrev(newNode);
            current.setNext(newNode);
        }
        size++;
	}

	public Boolean remove(T data) {

		if (head == null)
			return false;

		Node<T> current = head;

		while (current != null && !current.getData().equals(data)) {
			current = current.getNext();
		}

		if (current == null)
			return false;

		if (current == head) {
			head = head.getNext();
			if (head != null)
				head.setPrev(null);
		} else if (current == tail) {
			tail = tail.getPrev();
			if (tail != null)
				tail.setNext(null);
		} else {
			current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
		}

		size--;
		return true;
	}

	public T get(Integer index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getData();
	}

	public Integer size() {
		return size;
	}

	public void displayForward() {
		Node<T> current = head;
		while (current != null) {
			logger.info(current.getData() + " -> ");
			current = current.getNext();
		}
	}

	public void displayBackward() {
		Node<T> current = tail;
		while (current != null) {
			logger.info(current.getData() + " -> ");
			current = current.getPrev();
		}
	}
}
