import java.util.Stack;

class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack <> ();
        for(String s : tokens) {
            if(isOperator(s)) {
                int b = stack.pop(); //first element
                int a = stack.pop(); //second element
                int result = performOperation(s,a,b);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    private int performOperation(String op, int a, int b) {
        switch(op) {
            case "+" -> {
                return a+b;
            }
            case "-" -> {
                return a-b;
            }
            case "*" -> {
                return a*b;
            }
            case "/" -> {
                return a/b;
            }
            default -> throw new IllegalArgumentException("Invalid Operation");
        }
    }
}