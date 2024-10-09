class EliminateAlternates {
    public int lastRemaining(int n) {
        if(n==1) return 1;
        return  2*(1+n/2-lastRemaining(n/2));
    }
}

/*
## Elimination Game Solution Explanation

### Problem Statement

You have a list `arr` of all integers in the range \([1, n]\) sorted in strictly increasing order. The elimination process involves:

1. Starting from left to right, remove the first number and every other number afterward until the end of the list.
2. Repeat the previous step from right to left, removing the rightmost number and every other number from the remaining numbers.
3. Continue alternating left-to-right and right-to-left until only one number remains.

Given the integer `n`, return the last number that remains in `arr`.

### Key Insights

To solve this problem efficiently, we focus on tracking the position of the last remaining number rather than simulating the entire list elimination. We define:

- `head`: The current starting number in the list.
- `step`: The difference between consecutive numbers considered in the current round.
- `left`: A boolean indicating the direction of elimination (`True` for left-to-right, `False` for right-to-left).

### Algorithm Steps

1. **Initialization**:
   - Set `head = 1` (the first number in the list).
   - Set `step = 1` (initial step size).
   - Set `left = True` (starting with left-to-right elimination).

2. **Elimination Process**:
   - **Left-to-Right Elimination**:
     - Remove every other number starting from the first.
     - Move the `head` forward by `step` if eliminating from left or if the number of elements `n` is odd (when eliminating from right).
   - **Right-to-Left Elimination**:
     - Remove every other number starting from the last.
     - Update the `head` if `n` is odd.

3. **Updating Step Size and Remaining Elements**:
   - Double the `step` size after each pass.
   - Halve the number of remaining elements `n`.

4. **Termination**:
   - Continue until `n` becomes 1, indicating only one number remains.

### Code Implementation

```python
def last_remaining(n: int) -> int:
    head = 1
    step = 1
    left = True
    
    while n > 1:
        if left or n % 2 == 1:
            head += step
        
        step *= 2
        n //= 2
        left = not left
    
    return head

# Examples
print(last_remaining(9))  # Output: 6
print(last_remaining(1))  # Output: 1
*/
