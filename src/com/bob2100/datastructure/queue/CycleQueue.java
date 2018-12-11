package com.bob2100.datastructure.queue;

public class CycleQueue {
	private Integer[] data;

	private int head;

	private int tail;

	private boolean empty;

	public CycleQueue() {
		data = new Integer[5];
		head = 0;
		tail = 0;
		empty = true;
	}

	public boolean enQueue(Integer num) {
		if (isFull()) {
			return false;
		} else {
			if (isEmpty()) {
				empty = false;
			} else {
				tail++;
				if (tail >= data.length) {
					tail = 0;
				}
				data[tail] = num;
			}
			return true;
		}
	}

	public Integer deQueue() {
		if (isEmpty()) {
			return null;
		} else {
			if (head >= data.length) {
				head = 0;
			}
			if (head == tail && !isEmpty()) {
				return data[head];
			}
			return data[head++];
		}

	}

	public boolean isFull() {
		return tail - head == data.length - 1 || tail - head == -1;
	}

	public boolean isEmpty() {
		return empty;
	}

}
