class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> tempList = new ArrayList<>();
        int totalLeft=target,index=0;
        backtrack(result,tempList,candidates, totalLeft,index);
        return result;
    }

    public void backtrack(List<List<Integer>> answer, List<Integer> tempList, int[] candidates, int totalLeft,int index){
        if (totalLeft<0){
           return; 
        } else if (totalLeft==0) {
            // A new object should be created otherwise all objects will point to same pointer (the initial tempList)
            answer.add(new ArrayList<>(tempList));
        } else{
            for(int i=index;i<candidates.length && totalLeft>=candidates[i];i++){
                if(i>index && candidates[i]==candidates[i-1]) continue;
                tempList.add(candidates[i]);
                // Check for all possible scenarios.
                backtrack(answer, tempList, candidates, totalLeft-candidates[i], i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
