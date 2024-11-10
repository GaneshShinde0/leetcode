class Solution {
     public int largestInteger(int n){
        char[] a = String.valueOf(n).toCharArray();
        for(int i = 0; i < a.length; i++)
            for(int j = i + 1; j < a.length; j++)
                if(a[j] > a[i] && (a[j] - a[i]) % 2 == 0){
                    char t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
        return Integer.parseInt(new String(a));
    }

    public int largestIntegerAlternate(int num) {
        int count = 0;
        int temp = num;

        while(temp>0) {
            count ++;
            temp/= 10;
        }

        // converting num to array;
        int[] arr = new int[count];
        int k = count - 1;
        temp = num;

        while(temp>0) {
            arr[k--] = temp % 10;
            temp /= 10;
        }

        for(int i=0; i<count-1; i++) {
            for(int j=i+1; j<count; j++) {
                if(arr[i]%2 == 0 && arr[j]%2 == 0 && arr[j] > arr[i]) {
                    int z=arr[i];
                    arr[i]=arr[j];
                    arr[j]=z;
                } else if(arr[i]%2!=0&&arr[j]%2!=0&&arr[j]>arr[i]){
                    int z=arr[i];
                    arr[i]=arr[j];
                    arr[j]=z;
                }
            }
        }

        int res =0;

        for(int i: arr) {
            res *= 10;
            res += i;
        }

        return res;
    }
}
