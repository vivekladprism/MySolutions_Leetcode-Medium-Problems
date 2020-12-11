class Solution {
    public int[] nextGreaterElements(int[] nums) 
    {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        if(n == 0)
            return nums;
        
        stack.push(nums[n-1]);
        // traverse once from end to first element of array
        for(int i = n-2; i >= 0; i--)
        {
            // if peek() is more, add to stack
            // else pop till peek() is more
            while(!stack.isEmpty() && stack.peek() <= nums[i])
            {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        
        // repeat above steps while also filling the next highest element from stack
        // in answer array.
        
        int ans[] = new int[n];
        for(int i = n-1; i >= 0; i--)
        {
            while(!stack.isEmpty() && stack.peek() <= nums[i])
            {
                stack.pop();
            }
            if(!stack.isEmpty())
                ans[i] = stack.peek();
            else
                ans[i] = -1;
            stack.push(nums[i]);
        
        }
        
        return ans;
        
        
    }
}