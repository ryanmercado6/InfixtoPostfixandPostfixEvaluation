import java.lang.Math; 
class ArrayStackTest
{
	public static void main (String[] args) {
		//creating postfix to be evaluated
		String postFix="ab*ca-/de*+";
		System.out.println("Evaluating postfix expression "+ postFix);
		//print evaluation
		System.out.println(evaluatePostfix(postFix));
	}
public static int evaluatePostfix(String postfix) 
	{
	//index counter
	int nextCharIndex=0;
	char nextChar;
	int operandTwo;
	int operandOne;
	int result;
	//creating stack to hold values
	StackInterface <Integer> valueStack = new ResizeableArrayStack<>();
	//iterate through each char of the postfix
		while(nextCharIndex<postfix.length()) 
		{
			//get the char of whichever index we are at
			nextChar = postfix.charAt(nextCharIndex);
			//evaluate chars
			switch (nextChar) 
			{
			//cases a-e push the value of the variable onto the stack
			case 'a': 
		    	valueStack.push(2);
		    	break;
		    case 'b':
		    	valueStack.push(3);
		    	break;
		    case 'c':
		    	valueStack.push(4);
		    	break;
		    case 'd':
		    	valueStack.push(5);
		    	break;
		    case 'e':
		    	valueStack.push(6);
		    	break;
		    //pop the values out of the stack and perform the given operator
		    case '+':
		    	operandTwo = valueStack.pop();
		    	operandOne = valueStack.pop();
		    	result = operandOne+operandTwo;
		    	valueStack.push(result);
		    	break;
		    case '-':
		    	operandTwo = valueStack.pop();
		    	operandOne = valueStack.pop();
		    	result = operandOne-operandTwo;
		    	valueStack.push(result);
		    	break;
		    case '*':
		    	operandTwo = valueStack.pop();
		    	operandOne = valueStack.pop();
		    	result = operandOne*operandTwo;
		    	valueStack.push(result);
		    	break;
		    case '/':
		    	operandTwo = valueStack.pop();
		    	operandOne = valueStack.pop();
		    	result = operandOne/operandTwo;
		    	valueStack.push(result);
		    	break;
		    case '^':
		    	operandTwo = valueStack.pop();
		    	operandOne = valueStack.pop();
		    	result = (int) Math.pow(operandOne, operandTwo);
		    	valueStack.push(result);
		    	break;
		    default: 
		    	break;
			}
	    nextCharIndex++;
		}
	//return value left in the stack
	return valueStack.peek();
	}
}

