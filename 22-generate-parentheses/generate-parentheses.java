class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        generateCombinations(0,0,n,stack,res);
        return res;
    }

    public void generateCombinations(int openCount, int closeCount,int n, Stack<String> stack,List<String> res){
        if(openCount==closeCount && closeCount==n){
            res.add(String.join("",stack));
            return;
        }

        if(openCount < n){
            stack.push("(");
            generateCombinations(openCount+1,closeCount,n,stack,res);
            stack.pop();
        }

        if(closeCount < openCount){
            stack.push(")");
            generateCombinations(openCount,closeCount+1,n,stack,res);
            stack.pop();
        }
    }
}