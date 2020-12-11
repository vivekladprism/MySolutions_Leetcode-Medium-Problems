/*
	Algorithm-
	0. Create stack of type int[] where 0 position stores price and 1 position stores the index of occurrence.
	1. if stack is empty or price of top of stack is greater than current price, push current price to stack with its index.
	2. Increment index for next coming price.
	3. If stack is not empty and price of top of stack is less than or equal to current price, pop from stack.
	4. If stack is empty after step 3, return current index value + 1;
	5. Else return current index value - index value of top of stack. 
*/


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