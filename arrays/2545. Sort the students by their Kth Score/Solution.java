class Solution {
    // Following takes 3 ms
    public int[][] sortTheStudentsNaiveSolution(int[][] score, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[score.length];
        int i=0;
        for(int[] a:score){
            arr[i]=a[k];
            i++;
        }
        int[] temp = Arrays.copyOf(arr,arr.length);
        Arrays.sort(temp);
        int rank=0;
        for(i=0;i<temp.length;i++){
            map.putIfAbsent(temp[i],rank++);
        }
        for(i=0;i<temp.length;i++){
            arr[i]=map.get(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        int[][] res = new int[score.length][score[0].length];
        for(i=0;i<score.length;i++){
            res[score.length-arr[i]-1]=score[i];
        }
        return res;
    }

    public int[][] sortTheStudentsUsingLambda(int[][] score, int k) {
        // Sort the score array based on the k-th column in descending order
        Arrays.sort(score, (a, b) -> Integer.compare(b[k], a[k]));
        return score;
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        quickSort(score, k, 0, score.length - 1);
        return score;
    }

    public void quickSort(int[][] score, int k, int i, int j){
        int start = i;
        int end = j;

        if(start > end){
            return;
        }

        // 'i' is starting person
        // 'k' is which test
        int pivot = score[start][k];
        while(start != end){
            while(true){
                if(start >= end || score[end][k] > pivot){
                    break;
                }
                end--;
            }
            while(true){
                if(start >= end || score[start][k] < pivot){
                    break;
                }
                start++;
            }
            int[] temp = score[start];
            score[start] = score[end];
            score[end] = temp;
        }

        int[] temp = score[start];
        score[start] = score[i];
        score[i] = temp;

        quickSort(score, k, i, start - 1);
        quickSort(score, k, start + 1, j);
    }
}
