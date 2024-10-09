class FrequencyMap {
    public int minimumPushesNaive(String word) {
        // Frequency map for each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Count frequency of each character in the word
        for (char c : word.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Extract the frequencies into a list
        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        
        // Sort the frequencies in descending order
        frequencies.sort(Collections.reverseOrder());
        System.out.println(frequencies);
        // Calculate the minimum number of presses required
        int minPresses = 0;
        for (int i = 0; i < frequencies.size(); i++) {
            int multiplier = (i / 8) + 1;  // Determine the multiplier based on the range
            minPresses += multiplier * frequencies.get(i);
        }
        
        return minPresses;
    }

    public int minimumPushes(String word) {
        // Frequency map for each character
        int[] frequencyMap = new int[26];
        
        // Count frequency of each character in the word
        for (char c : word.toCharArray()) {
            frequencyMap[c - 'a']++;
        }
        
        // Calculate the minimum number of presses required
        int minPresses = 0;
        int charactersProcessed = 0;
        Arrays.sort(frequencyMap);

        // Iterate over the frequency map in descending order of frequency
        for (int i = 0; i < 26; i++) {
            if (frequencyMap[i] > 0) {
                int multiplier = ((25-i )/ 8) + 1;  // Determine the multiplier based on the range                
                minPresses += multiplier * frequencyMap[i];
            }
        }

        return minPresses;
    }
}
