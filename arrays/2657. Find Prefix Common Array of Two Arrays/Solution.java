class Solution {
    public int[] findThePrefixCommonArrayInitial(int[] A, int[] B) {
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        int n = A.length;
        int[] C = new int[n];

        for(int i=0;i<n;i++){
            aSet.add(A[i]);
            bSet.add(B[i]);
            Set<Integer> intersection = new HashSet<>(aSet);
            intersection.retainAll(bSet);
            C[i]=intersection.size();
        }
        return C;
    }

    public int[] findThePrefixCommonArrayUsingBooleanArray(int[] A, int[] B) {
        
        int n = A.length;
        boolean[] isA = new boolean[n];
        boolean[] isB = new boolean[n];
        int[] C = new int[n];

        for(int i=0;i<n;i++){
            isA[A[i]-1]=true;
            isB[B[i]-1]=true;
            int count=0;
            for(int j=0;j<n;j++){
                if(isA[j]&&isB[j]) count++;
            }
            C[i]=count;
        }
        return C;
    }
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int temp[]=new int[51];
        int n=A.length;
        int count=0;
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {   
           temp[A[i]]++;
           temp[B[i]]++;
           if(temp[A[i]]==2)
           {
                count++;
                temp[A[i]]=0;
           }
           if(temp[B[i]]==2)
           {
                count++;
                temp[B[i]]=0;
           }

            arr[i]=count;

        }

        return arr;
    }
}
