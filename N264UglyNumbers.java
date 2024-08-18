class N264UglyNumbers {

    // Takes Around 50 ms
    public int nthUglyNumberUsingTreeSet(int n) {
        TreeSet<Long> uglyNumbersSet = new TreeSet<>(); // TreeSet to store potential ugly numbers
        uglyNumbersSet.add(1L); // Start with 1, the first ugly number
        // TreeSet automatically sorts elements in ascending order and does not
        // allow duplicate entries, just like a HashSet in python

        Long currentUgly = 1L;
        for (int i = 0; i < n; i++) {
            currentUgly = uglyNumbersSet.pollFirst(); // Get the smallest number from the set and remove it

            // Insert the next potential ugly numbers into the set
            uglyNumbersSet.add(currentUgly * 2);
            uglyNumbersSet.add(currentUgly * 3);
            uglyNumbersSet.add(currentUgly * 5);
        }

        return currentUgly.intValue(); // Return the nth ugly number
    }

    // Takes around 40 ms
    public int nthUglyNumberUsingPQ(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seenNumbers = new HashSet<>(); // Set to avoid duplicates
        int[] primeFactors = { 2, 3, 5 }; // Factors for generating new ugly numbers

        minHeap.offer(1L);
        seenNumbers.add(1L);

        long currentUgly = 1L;
        for (int i = 0; i < n; i++) {
            currentUgly = minHeap.poll(); // Get the smallest number

            // Generate and push the next ugly numbers
            for (int prime : primeFactors) {
                long nextUgly = currentUgly * prime;
                if (seenNumbers.add(nextUgly)) { // Avoid duplicates
                    minHeap.offer(nextUgly);
                }
            }
        }

        return (int) currentUgly; // Return the nth ugly number
    }

    public int nthUglyNumber(int n){
        int[] uglyNumbers = new int[n]; // Dynamic array to Store n ugly numbers.
        uglyNumbers[0]=1; // As we know first ugly number is 1;

        // Three pointers for the multiples of 2, 3 and 5
        int indexOfMultipleOf2 = 0, indexOfMultipleOf3=0, indexOfMultipleOf5=0;
        int nextMultipleOf2 = 2, nextMultipleOf3=3, nextMultipleOf5 = 5;

        // Generate ugly numbers and set them in array until n
        for(int i=1;i<n;i++){
            int nextUglyNumber = Math.min(nextMultipleOf3, Math.min(nextMultipleOf5,nextMultipleOf2));

            uglyNumbers[i]=nextUglyNumber;

            // Update the correspondig pointer and next multiple
            if(nextUglyNumber == nextMultipleOf2){
                indexOfMultipleOf2++;
                nextMultipleOf2 = uglyNumbers[indexOfMultipleOf2]*2;
            }

            if(nextUglyNumber == nextMultipleOf3){
                indexOfMultipleOf3++;
                nextMultipleOf3 = uglyNumbers[indexOfMultipleOf3]*3;
            }

            if(nextUglyNumber == nextMultipleOf5){
                indexOfMultipleOf5++;
                nextMultipleOf5 = uglyNumbers[indexOfMultipleOf5]*5;
            }
        }
        return uglyNumbers[n-1];
    }
}
