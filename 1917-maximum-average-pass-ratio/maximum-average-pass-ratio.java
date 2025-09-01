class Solution {
    public double maxAverageRatioInitial(int[][] classes, int extraStudents) {
        List<Double> passRatios = new ArrayList<>();
        int n = classes.length;
        // Callculate Initial Pass Ratios
        for(int i = 0; i< n; i++){
            double initialRatio = (double) classes[i][0]/classes[i][1];
            passRatios.add(initialRatio);
        }

        while(extraStudents>0){
            List<Double> updatedRatios = new ArrayList<>();
            for(int i=0; i<n; i++){
                double newRatio = (double) (classes[i][0]+1)/ (classes[i][1]+1);
                updatedRatios.add(newRatio);
            }
            int bestClassIndex = 0;
            double maxGain = 0;
            // Find the class that gains the most from an extra student
            for(int i=0;i<n;i++){
                double gain = updatedRatios.get(i)-passRatios.get(i);
                if(gain>maxGain){
                    maxGain = gain;
                    bestClassIndex = i;
                }
            }
            passRatios.set(bestClassIndex,updatedRatios.get(bestClassIndex));
            classes[bestClassIndex][0]++;
            classes[bestClassIndex][1]++;
            extraStudents--;
        }

        double totalPassRatio = 0;
        for(double passRatio:passRatios){
            totalPassRatio += passRatio;
        }
        return totalPassRatio/classes.length;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents){
        // Lambda to calculate gain of adding an extra sutdent
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));

        for(int[] singleClass: classes){
            int passCount = singleClass[0];
            int currTotal = singleClass[1];
            double gain = calculateGain(passCount, currTotal);
            maxHeap.offer(new double[] {gain, passCount, currTotal});
        }

        // Distribute Extra Students
        while(extraStudents-->0){
            double[] current = maxHeap.poll();
            double currentGain = current[0];
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            maxHeap.offer(new double[]{
                    calculateGain(passes+1, totalStudents+1),
                    passes+1,
                    totalStudents+1
            });
        }
        // Caclulate final average pass ratio
        double totalPassRatio = 0;
        while(!maxHeap.isEmpty()){
            double[] curr = maxHeap.poll();
            int passCount = (int) curr[1];
            int currTotal = (int) curr[2];
            totalPassRatio +=(double) passCount/currTotal;
        }
        return totalPassRatio/classes.length;
    }
    private double calculateGain(int passes, int totalStudents){
        return(
            (double) (passes+1)/(totalStudents+1)
            - (double) (passes)/totalStudents
        );
    }
}