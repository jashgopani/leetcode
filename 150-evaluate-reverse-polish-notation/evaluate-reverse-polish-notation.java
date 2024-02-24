class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String token = tokens[i];
            switch(token){
                case "+":
                case "-":
                case "*":
                case "/":
                    int op2 = stack.pop();
                    int op1 = stack.pop();
                    int res = eval(token,op1,op2);
                    stack.push(res);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public int eval(String operation,int op1, int op2){
        switch(operation){
            case "+":
                return op1+op2;
            case "-":
                return op1-op2;
            case "*":
                return op1*op2;
            case "/":
                return op1/op2;
            default:
                return -1;
        }
    }
}