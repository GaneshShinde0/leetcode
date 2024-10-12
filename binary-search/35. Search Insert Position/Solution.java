class Solution {
    public char nextGreatestLetterInitialSolution(char[] letters, char target) {
        int start =0, end = letters.length-1;
        int n= end;
        while(start<=end){
            int mid = start + (end-start)/2;
            // System.out.println("Start:"+start+", End:"+end+",Mid:"+mid);
            if(letters[mid]==target){
                start = mid;
                break;
            }
            else if (letters[mid]>target) end = mid-1;
            else start = mid+1;
        }
                        System.out.println(start);
        if(start<=n && letters[start]>target) return letters[start];
        while(start<=n && letters[start]<=target){
            start++;
            System.out.println(start);
        }
        if(start<=n) return letters[start];
        return letters[0];
    }
    public char nextGreatestLetterMyOptimization(char[] letters, char target) {
        int start =0, end = letters.length-1;
        int n= end;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(letters[mid]<=target){
                start = mid+1;
            }
            else end = mid-1;
        }
        // if(start<=n && letters[start]>target) return letters[start];
        // while(start<=n && letters[start]<=target){
        //     start++;
        // }
        if(start<=n) return letters[start];
        return letters[0];
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1;
        int n = letters.length;
        
        // Binary search to find the smallest letter greater than target
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            // If mid is greater than target, focus on the left half (but include mid as potential result)
            if (letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1; // Otherwise, focus on the right half
            }
        }
        
        // After the loop, start points to the smallest letter greater than target
        // If start has gone beyond the array, wrap around to letters[0]
        return letters[start % n]; 
    }

}
