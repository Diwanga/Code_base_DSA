import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackRE {
	
	//Reverse a string
public static void reverseString(String text) {
	
	Stack<Character> stack = new Stack<Character>();
	
	var array = text.toCharArray();
	
	for (char c : array) {
		stack.push(c);
	}
	while(!stack.isEmpty()) {
		System.out.print(stack.pop());
	}
	
}

//validating  expression
public static boolean  isValid(String text) {
	
	Stack<Character> stack = new Stack<Character>();
	var tarray = text.toCharArray();
	for(char c : tarray) {
		
		
		if(c=='<'||c=='(') {
			stack.push(c);
		}
		
			
		if(c=='>'||c==')' ) {
			
			if(stack.empty()) {
				
				return false;
			}
			
			if((c=='>'&& stack.pop() != '<')||(c==')'&& stack.pop() != '(')) {
				return false;
			}
			
			
		}
	}
	//System.out.println(stack);
	if(!stack.empty()) {
		return false;
	}
	
	return true;
}

//validaating expression elegant way
////////////////////////////////////////////////////////////////////
static List<Character> leftBrackets = Arrays.asList('(','<','[','{');
static List<Character> rightBrackets = Arrays.asList(')','>',']','}');

public static boolean  isValidpro(String text) {
	
	Stack<Character> stack = new Stack<Character>();
	
	
	var tarray = text.toCharArray();
	
	for(char c : tarray) {
		
		if(isLeftBrackt(c))
			stack.push(c);
		
		if(isRightBrackt(c)) {
			if(stack.isEmpty()) {
				return false;
			}
			if(!bracketsMatch(c, stack.pop()))
				return false;
			
		}
		
	}
	return true;
		

}

public static  boolean isLeftBrackt(char ch ) {
	return leftBrackets.contains(ch);
}
public static boolean isRightBrackt(char ch ) {
	return rightBrackets.contains(ch);
}
public  static boolean bracketsMatch(char one , char two ) {
	return  rightBrackets.indexOf(one) == leftBrackets.indexOf(two);
}
	
	
	//////////////////////////////////////////////////////////////////////////////


	public static void main(String[] args) {
//		reverseString("DIWANGA");
		
	System.out.println(isValidpro("sdsdgf,,mm,<,{}[][[[]]],>")); 
		
	}
}

