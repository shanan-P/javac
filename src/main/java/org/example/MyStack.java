package org.example;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * A custom stack implementation that supports a constant-time min() operation.
 * This is achieved by using an auxiliary stack to keep track of the minimum values.
 */
public class MyStack {

    private int[] mainStack;
    private int[] minStack;
    private int mainTop;
    private int minTop;

    /**
     * Constructs a stack with the specified capacity.
     * @param capacity the maximum capacity of the stack.
     */
    public MyStack(int capacity) {
        mainTop = -1;
        minTop = -1;
        mainStack = new int[capacity];
        minStack = new int[capacity];
    }

    /**
     * Pushes a value onto the top of this stack.
     * @param value the value to be pushed.
     * @throws StackOverflowError if the stack is full.
     */
    public void push(int value) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        
        mainTop++;
        mainStack[mainTop] = value;
        
        // Push to minStack if it's empty or the new value is <= current min
        if (minTop == -1 || value <= minStack[minTop]) {
            minTop++;
            minStack[minTop] = value;
        }
    }

    /**
     * Removes the object at the top of this stack and returns that object.
     * @return The object at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        int poppedValue = mainStack[mainTop];
        mainTop--;
        
        // If the popped value was the minimum, pop it from minStack too
        if (poppedValue == minStack[minTop]) {
            minTop--;
        }
        
        return poppedValue;
    }

    /**
     * Looks at the object at the top of this stack without removing it.
     * @return the object at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return mainStack[mainTop];
    }

    /**
     * Tests if this stack is empty.
     * @return {@code true} if the stack is empty; {@code false} otherwise.
     */
    public boolean isEmpty() {
        return mainTop == -1;
    }

    /**
     * Tests if this stack is full.
     * @return {@code true} if the stack is full; {@code false} otherwise.
     */
    public boolean isFull() {
        return mainTop == mainStack.length - 1;
    }

    /**
     * Returns the minimum element in the stack.
     * @return the minimum element.
     * @throws EmptyStackException if this stack is empty.
     */
    public int min() {
        if (minTop == -1) {
            throw new EmptyStackException();
        }
        return minStack[minTop];
    }
}