class Solution 
{
    public Node expTree(String s) 
    {
        Stack<Character> OperatorStack = new Stack<Character>();
        Queue<Character> OutputQueue = new LinkedList<Character>();
        
		//Infix -> postfix
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                OutputQueue.add(s.charAt(i));
            else if(IsOperator(s.charAt(i)))
            {
                while(!OperatorStack.isEmpty() && Precedence(OperatorStack.peek()) >= Precedence(s.charAt(i)))
                    OutputQueue.add(OperatorStack.pop());
                
                OperatorStack.push(s.charAt(i));    
            }
            else if(s.charAt(i) == '(')
                OperatorStack.push(s.charAt(i));
            else
            {
                while(!OperatorStack.isEmpty() && OperatorStack.peek() != '(')
                    OutputQueue.add(OperatorStack.pop());
                
                OperatorStack.pop();
            }
        }
        
        while(!OperatorStack.isEmpty())
            OutputQueue.add(OperatorStack.pop());
			
        //Postfix -> expression tree
        Stack<Node> resultStack = new Stack<Node>();
        
        while(!OutputQueue.isEmpty())
        {
            Character ch = OutputQueue.poll();
            if(IsOperator(ch))
            {
                Node right = resultStack.pop();
                Node left = resultStack.pop();
                resultStack.push(new Node(ch, left, right));
            }
            else
                resultStack.push(new Node(ch));
        }
        
        return resultStack.peek();
    }
    
    private boolean IsOperator(Character c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    private int Precedence(Character c)
    {
        int pred = 0;
        
        switch(c)
        {
            case '+':
                pred = 2;
                break;
            case '-':
                pred = 2;
                break;
            case '*':
                pred = 3;
                break;
            case '/':
                pred = 4;
                break;
            default:
                break;
        }
        
        return pred;
    }
}