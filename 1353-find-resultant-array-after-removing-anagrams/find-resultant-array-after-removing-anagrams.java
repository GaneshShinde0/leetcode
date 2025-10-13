class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        res.add(words[0]);
        for(int i=1;i<words.length;i++){
            char[] arr2 = words[i].toCharArray();
            char[] arr1 = words[i-1].toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            String curr1 = new String(arr1);
            String curr2 = new String(arr2);
            if(!curr1.equals(curr2)) res.add(words[i]);
            
        }
        return res;
    }
}