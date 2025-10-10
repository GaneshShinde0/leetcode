class Solution {
    public boolean phonePrefix(String[] numbers) {
        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers.length;j++){
                if(i!=j && numbers[i].startsWith(numbers[j])) return false;
            }
        }
        return true;
    }
}