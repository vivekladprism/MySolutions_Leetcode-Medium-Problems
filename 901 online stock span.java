class StockSpanner {
    Stack<int[]> stack;
    int index = 0;
    
    public StockSpanner() {
        stack = new Stack<>();    
    }
    
    public int next(int price) {
        
        if(stack.isEmpty() || stack.peek()[0] > price)
        {
            stack.push(new int[]{price, index++});
            return 1;
        }
        else
        {
            while(!stack.isEmpty() && stack.peek()[0] <= price)
            {
                stack.pop();
            }
            int ans = 1;
            if(!stack.isEmpty())
                ans = index - stack.peek()[1];
            else
                ans = index + 1;

            stack.push(new int[]{price, index++});
            return ans;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */