class Solution {
    public int maximumUnitsON(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        for(int[] arr: boxTypes){
            System.out.println(Arrays.toString(arr));
        }
        int i=0;
        int numBoxes=0;
        while(truckSize>0&& i<boxTypes.length){
            if(boxTypes[i][0]>0){
                numBoxes+=boxTypes[i][1];
                truckSize--;
                boxTypes[i][0]--;
            }else{
                i++;
            }
        }
        return numBoxes;
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] count = new int[1001];
        for (int[] box : boxTypes) count[box[1]] += box[0];

        int maxUnit = 0;
        for (int i = 1000; i >= 0; i--) {
            if (count[i] > 0) {
                int curBoxes = Math.min(truckSize, count[i]);
                maxUnit += curBoxes * i;
                truckSize -= curBoxes;
                if (truckSize == 0) return maxUnit;
            }
        }
        return maxUnit;
    }
}
