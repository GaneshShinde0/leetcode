class Solution {
    public List<String> topKFrequent16ms(String[] words, int k) {
        Map<String, Integer> hm = new HashMap<>();
        for(String word:words){
            hm.put(word, hm.getOrDefault(word,0)+1);
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                if(o2.getValue().compareTo(o1.getValue())==0){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        List<String> li = new LinkedList<>();
        for(Map.Entry<String, Integer> entry: sortedMap.entrySet()){
            li.add(entry.getKey());
            k--;
            if(k==0) break;
        }
        return li;
    }
    // Optimized
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Use a priority queue to store the top k frequent words
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> {
            int freqCompare = frequencyMap.get(w1).compareTo(frequencyMap.get(w2));
            if (freqCompare == 0) {
                return w2.compareTo(w1);  // Sort lexicographically in reverse order
            }
            return freqCompare;  // Sort by frequency (ascending)
        });

        // Step 3: Add words to the priority queue
        for (String word : frequencyMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();  // Remove the least frequent/lexicographically greater element
            }
        }

        // Step 4: Extract the elements from the priority queue into a list
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // Step 5: Reverse the list since we want the most frequent words first
        Collections.reverse(result);
        return result;
    }
}
