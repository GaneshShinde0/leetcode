class Solution {
    public int minAllOneMultiple(int k) {
        if(k%2==0||k%5==0) return -1;
        int curr = 1; // We are looking for a number composed of digit 1, sequence starts with the number 1.
        // We initialize curr = 1 to represent the first number in the sequence.
        // Count = 1 means the current number has length 1.
        int count = 1;
        while(curr%k!=0){ // We are checking if current is multiple of k
            curr = (curr*10+1)%k; // We are multiplying our number of 10 and adding 1 ..
            // Basically we are generating the sequence 
            count++;
        }
        return count;
    }
}