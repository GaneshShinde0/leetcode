class CountPairsUsingArray {
    public int countPairs(List<Integer> list, int target) {
        int arr[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]<target){
                    count++;
                }
            }
        }
        return count;
        
    }
}
