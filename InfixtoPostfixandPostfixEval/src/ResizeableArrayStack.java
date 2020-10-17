import java.util.Arrays;
import java.util.EmptyStackException;

class ResizeableArrayStack <T> implements StackInterface <T>
{
	private T[] stack;
	private int topIndex;
	private static int DEFAULT_CAPACITY = 50;
//constructor	
	public ResizeableArrayStack()
	{
		this(DEFAULT_CAPACITY);
	}
//constructor	
	public ResizeableArrayStack(int capacity) {
		@SuppressWarnings("unchecked")
		T[] tempStack = ((T[]) new Object[capacity]);
		stack=tempStack;
		topIndex=-1;
	}
//add new value to stack
	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		ensureCapacity();
		stack[topIndex +1]=newEntry;
		topIndex++;
	}
//method to double size if array is full
	private void ensureCapacity() {
		// TODO Auto-generated method stub
		if(topIndex>=stack.length-1)
		{
			int newLength = 2 * stack.length;
			stack = Arrays.copyOf(stack, newLength);
		}
		
	}
//remove value and return value that was removed
	@Override
	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();
		else
		{
			T top = stack[topIndex];
			stack[topIndex]= null;
			topIndex--;
			return top;
		}
	}
//check which value is at the top
	@Override
	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		else
			return stack[topIndex];
	}
//check if stack is empty
	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}
//clear the stack
	@Override
	public void clear() {
		while (topIndex >-1)
		{
			stack[topIndex]=null;
			topIndex--;
		}
		
	}
	
}