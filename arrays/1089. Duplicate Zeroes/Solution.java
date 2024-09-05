class Solution {
    public void duplicateZeros(int[] arr) {
        int[] temp = Arrays.copyOf(arr,arr.length);
        int j=0;
        for(int i=0;i<arr.length && j<arr.length;i++,j++){
            if(temp[i]==0){
                arr[j]=0;
                if(j+1<arr.length) arr[j+1]=0;
                j++;
            }else{
                arr[j]=temp[i];
            }
        }
    }
}
