class NoOfPairsOfInterchangeableRectagle {
    public long interchangeableRectanglesNaiveTimesOutForLongInput(int[][] rectangles) {
        int count=0;
        for(int i=0;i<rectangles.length-1;i++){
            double ratioOuter = 1.0*rectangles[i][0]/rectangles[i][1];
            for(int j=i+1;j<rectangles.length;j++){
                double ratioInner = 1.0*rectangles[j][0]/rectangles[j][1];
                if (Math.abs(ratioOuter-ratioInner)<0.000000001){
                    count++;
                }
            }
        }
        return count;
    }

    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> ratioCountMap = new HashMap<>();
        long count = 0;

        for (int[] rectangle : rectangles) {
            double ratio = (double) rectangle[0] / rectangle[1];
            ratioCountMap.put(ratio, ratioCountMap.getOrDefault(ratio, 0) + 1);
        }

        for (int freq : ratioCountMap.values()) {
            if (freq > 1) {
                count += (long) freq * (freq - 1) / 2; // Combination formula: nC2
            }
        }

        return count;
    }
}
