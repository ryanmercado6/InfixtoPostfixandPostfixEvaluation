import java.util.EmptyStackException;

class LinkedStack <T> implements StackInterface <T>
{
	private Node topNode;
	//private class for nodes
	private class Node

	{
		private T data;
		private Node next;
		private Node(T dataPortion)
		{
			this(dataPortion,null);
		}
		private Node(T dataPortion, Node nextNode)
		{
			data=dataPortion;
			next = nextNode;
		}
		private T getData()
		{
			return data;
		}
		private void setData(T newData)
		{
			data=newData;
		}
		private Node getNextNode()
		{
			return next;
		}
		@SuppressWarnings("unused")
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		}
	}
	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}
	//remove value and return the value that was removed
	@Override
	public T pop() {
		// TODO Auto-generated method stub
		T top=peek(); 
		topNode = topNode.getNextNode();
		return top;
	}
	//check which value is at the top
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			System.out.println("empty");
			throw new EmptyStackException();
		}
			else
			return topNode.getData();
	}
	//check if empty
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return topNode == null;
	}
	//empty stack
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		topNode = null;
		
	}

}