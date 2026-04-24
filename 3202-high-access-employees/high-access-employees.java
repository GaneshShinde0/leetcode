class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> accessTimes) {
        Collections.sort(accessTimes,(a,b)->a.get(1).compareTo(b.get(1)));
        HashMap<String,Deque<Integer>> userAccessTimes = new HashMap<>();
        Set<String> result = new HashSet<>();
        for(List<String> curr:accessTimes){
            Deque<Integer> access = userAccessTimes.computeIfAbsent(curr.get(0),x->new ArrayDeque<>());
            access.add(parseTime(curr.get(1)));
            if(access.size()>=3 && access.peekLast()-access.peekFirst()>=60) access.pollFirst();
            else if(access.size()>=3)result.add(curr.get(0));
        }
        return new ArrayList<>(result);
    }
    private int parseTime(String s){
        return Integer.parseInt(s.substring(0,2))*60+Integer.parseInt(s.substring(2));
    }
}