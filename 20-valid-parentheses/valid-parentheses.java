class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> pair = new HashMap<>();
        pair.put('(',')');
        pair.put('{','}');
        pair.put('[',']');

        Stack<Character> stack = new Stack<>();

        for(char c:s.toCharArray()){
            if(pair.containsKey(c)) stack.push(c);
            else{
                if(stack.empty() || pair.get(stack.pop())!=c) return false;
            }
        }

        return stack.empty();
    }
}