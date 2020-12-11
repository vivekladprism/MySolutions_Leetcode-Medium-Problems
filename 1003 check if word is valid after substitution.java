
// Solution 1

class Solution {
    public boolean isValid(String s) 
    {
        // Conditions
        /*
            1. a will always be followed by a or b
            2. b will always be followed by a or c
            3. Number of bs cannot be greater than number of as
            4. Number of as should be equal to bs and cs
        */
        int count = 0;
        char arr[] = s.toCharArray();
        int countB = 0;
        
        for(int i = 0 ; i < arr.length; i++)
        {
            if(i+1 < arr.length && arr[i] == 'a' && arr[i+1] == 'c')
                return false;
            if(i+1 < arr.length && arr[i] == 'b' && arr[i+1] == 'b')
                return false;
            if(arr[i] == 'a')
                count++;
            if(arr[i] == 'c')
            {
                 count --;
                countB--;
            }   
            if(arr[i] == 'b')
            {
                countB ++;
                if(countB > count)
                    return false;
            }
            if(count < 0)
                return false;
        }
        return count == 0;
        
    }
}

// Solution 2
 public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') return false;
                if (stack.isEmpty() || stack.pop() != 'a') return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }