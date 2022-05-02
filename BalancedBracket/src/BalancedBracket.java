
import java.util.Stack;

public class BalancedBracket {
	
	void solution(String inp)
	{
		
		Stack<Character> stack = new Stack<Character>();
		
		System.out.println("given input is -  "+inp);
		
		int length = inp.length();
		
		//Initializing a boolean called flag 
				boolean flag=true;
		
		//if the input has odd number of brackets, the it is automatically unbalanced		
		if(length%2==0) 
		{
			//pushing half of the string into stack
			for(int i=0;i<(length/2);i++)
			{
				stack.push(inp.charAt(i));
			}

			
			
			
			//checking it with later half of the bracket
			for(int i=(length/2);i<length;i++)
			{
				
				char a = stack.pop();    //1st half of the string
				char b = inp.charAt(i);  //2nd half of the string
				
				switch(a)
				{
				case '{' : 
					
					if(b==')'||b==']') 
					{
						System.out.println("case1");
						flag=false;
					}
					break;
				case '(' : 
					if(b=='}'||b==']') 
					{
						System.out.println("case2");
						flag=false;
					}
					break;
				case '[' : 
					if(b==')'||b=='}') 
					{
						System.out.println("case3");
						flag=false;
					}
					break;

				default : break;
				}
				
			}
			//end of for loop
		}
		
		
		//if the input has odd number of brackets, the it is automatically unbalanced
		else 
		{
			flag = false;
		}
		
		 
		
		if(flag)
		{
			System.out.println("The entered String has Balanced Brackets");
		}
		else
		{
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
		
		//partition line - it has no significance 
		System.out.println("===============================================");
	}

	
	//Driver method	
	public static void main(String args[])
	{
		BalancedBracket obj = new BalancedBracket();
		
		obj.solution("([[{}]])");
		obj.solution("([[{}]]))");
		obj.solution("{[(}])");
		obj.solution("({[]})");
	}
}
