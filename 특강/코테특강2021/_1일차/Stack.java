package D0823;

public class Stack<E> {
	
	private E[] list;
	private int top;
	
	public Stack() {
		list = (E[]) new Object[5000000];
		top = 0;
	}
	
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public E pop() {
		top--;
		
		E element = list[top];		
		list[top] = null;

		return element;
	}
	
	
	public void push(E element) {
		list[top] = element;
		top++;
	}
	
	public int getSize() {
		return top;
	}
	
	
	
	
	
	
	
	
	
	
	
}
