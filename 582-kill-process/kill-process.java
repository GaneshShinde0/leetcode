class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> parentToChild = new HashMap<>();
        int i=0;
        for(int parentId:ppid){
            parentToChild.computeIfAbsent(parentId, k-> new ArrayList<Integer>()).add(pid.get(i));
            i++;
        }
        List<Integer> result = new ArrayList<>();
        dfs(parentToChild,kill,result);
        return result;
    }
    private void dfs(HashMap<Integer, List<Integer>> parentToChild, int currentKill, List<Integer> result){
        result.add(currentKill);
        if(!parentToChild.containsKey(currentKill)) return;
        for(Integer child:parentToChild.get(currentKill)){
            dfs(parentToChild,child,result);
        }
    }
}