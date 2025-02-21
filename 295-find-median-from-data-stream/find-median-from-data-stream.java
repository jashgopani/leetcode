class MedianFinder {
    private PriorityQueue<Integer> small, large;

    public MedianFinder() {
        small = new PriorityQueue<>((a,b)->Integer.compare(b,a));//max heap
        large = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        small.add(num);
        
        if(small.size() > 0 && large.size() > 0 && (Integer)small.peek() > (Integer)large.peek()){
            large.add(small.poll());
        }

        if(small.size() > large.size() + 1){
            large.add(small.poll());
        }

        if(large.size() > small.size() + 1){
            small.add(large.poll());
        }

    }
    
    public double findMedian() {

        if(small.size() > large.size()) return (Integer)small.peek();

        if(large.size() > small.size()) return (Integer)large.peek();

        return (((Integer)small.peek()) + ((Integer)large.peek()))/2.0d;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */