class LuckyNumbersInMatrix {
    public List<Integer> luckyNumbersOptimized (int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<matrix.length;i++){
            int minIndex = minIndex(matrix, i);
            int value = matrix[i][minIndex];
            if(maxInCol(matrix, minIndex,value)){
                list.add(value);
            }
        }
        return list;
    }
        private int minIndex(int [][] arr, int row ){
            int index = 0;
            int min = arr[row][index];
            for(int i =0;i<arr[row].length;i++){
                if(arr[row][i] < min){
                    min = arr[row][i];
                    index = i;
                }
            }
            return index;
        }
        private boolean maxInCol(int [][] arr, int minIndex,int  value){
            for (int i = 0; i < arr.length; i++) {
            if (arr[i][minIndex] > value) return false;
        }
        return true;

        }

    public List<Integer> luckyNumbers(int[][] matrix) {
        int N = matrix.length, M = matrix[0].length;

        List<Integer> rowMin = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int rMin = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                rMin = Math.min(rMin, matrix[i][j]);
            }
            rowMin.add(rMin);
        }

        List<Integer> colMax = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int cMax = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                cMax = Math.max(cMax, matrix[j][i]);
            }
            colMax.add(cMax);
        }

        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == rowMin.get(i) && matrix[i][j] == colMax.get(j)) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }

        return luckyNumbers;
    }
}
