class MinStack {
    List<Integer> stack;
    List<Integer> minStack;

    public MinStack() {
        minStack = new ArrayList<>();
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        minStack.add(Math.min(getMinTillNow(),val));
        stack.add(val);
    }
    
    public void pop() {
        minStack.remove(head());
        stack.remove(head());
    }
    
    public int top() {
        return stack.get(head());
    }
    
    public int getMin() {
        return minStack.get(head());
    }

    private int head(){
        return stack.size()-1;
    }

    private int getMinTillNow(){
        if(!minStack.isEmpty() && minStack.size()>0){
            return minStack.get(head());
        }

        return Integer.MAX_VALUE;
    }

    public String toString(){
        return String.format("stack: %s\nminStack: %s\n",stack,minStack);
    }
}