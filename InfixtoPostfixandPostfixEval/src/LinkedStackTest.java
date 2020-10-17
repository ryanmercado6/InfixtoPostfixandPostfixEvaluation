class LinkedStackTest{
	
	public static <T> void main (String[] args) {	
	String infix = "a*b/(c-a)+d*e";
	System.out.println("Testing postfix expression "+ infix);
	
	System.out.println("Postfix expression is "+ convertToPostfix(infix));
	}
	//method to rank operator values
	public static int precedenceValue(char entry) {
		switch (entry)
		{
			case '+':case '-':
				return 1;
			case '*':case '/':
				return 2;
			default:
				return 0;
		}
		
	}
	//method to convert to postfix
	public static String convertToPostfix(String infix)
	{
		//convert all values to lowercase
		infix =infix.toLowerCase();
		//create empty string to return
		String postfix = "";
		//create empty stack to add operators
		StackInterface <Character> operatorStack = new LinkedStack<>();
		//counter for index of next char 
		int nextCharIndex=0;
		//loop through each position in length of string
		while(nextCharIndex<infix.length()) 
		{
			//get character at index of char
			char nextChar= infix.charAt(nextCharIndex);
			//compare char to different cases
			switch (nextChar)
			{
				//operand cases, append to end of postfix
			    case 'a': 
			    case 'b':
			    case 'c':
			    case 'd':
			    case 'e':
			    case 'f':			    
			    case 'g':			    
			    case 'h':			    
			    case 'i':			    
			    case 'j':			    
			    case 'k':
			    case 'l':			    
			    case 'm':
			    case 'n':
			    case 'o':
			    case 'p':
			    case 'q':
			    case 'r':
			    case 's':
			    case 't':
			    case 'u':			    
			    case 'v':			    
			    case 'w':			    
			    case 'x':			    
			    case 'y':			    
			    case 'z':
			    	postfix=postfix+nextChar;
			    	break;
			    //power case, append to operator stack
				case '^':
					operatorStack.push(nextChar);
			    	break;
			    //operator cases, pop operators from the stack, appending them to postfix
			    //Do this until stack is empty or top entry has a lower precedence than the newly encountered operator
			    //Then push new operator to stack
				case '+':
				case '-':
				case '*':
				case '/': 
					while (!operatorStack.isEmpty()&& (precedenceValue(nextChar)<=precedenceValue(operatorStack.peek()))) {
						postfix = postfix+ operatorStack.peek();
						operatorStack.pop();
					}
					operatorStack.push(nextChar);
					break;
				//open parenthesis case, push onto stack
				case '(':
					operatorStack.push(nextChar);
					break;
				//close parenthesis, pop operators from stack and append them until an open parenthesis is popped
				case ')':
					char topOperator = operatorStack.pop();
					while (topOperator != '(')
					{
						postfix=postfix+topOperator;
						topOperator = operatorStack.pop();
					}
					break;
				default: 
					break;
			}
			nextCharIndex++;
		}
		//add the rest of the stack to postfix
		while (!operatorStack.isEmpty())
		{
			char topOperator = operatorStack.pop();
			postfix=postfix+topOperator;
	    }
		return postfix;

	}
}