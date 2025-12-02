class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i=0;i<ppid.size();i++){
            hm.computeIfAbsent(ppid.get(i),k->new ArrayList<Integer>()).add(pid.get(i));
        }
        System.out.println(hm);
        List<Integer> res = new ArrayList<>();
        dfs(hm, res, kill);
        return res;
    }
    private void dfs(HashMap<Integer, List<Integer>> hm, List<Integer> res, int kill){
        res.add(kill);
        if(!hm.containsKey(kill)) return;
        for(int i:hm.get(kill)){
            dfs(hm,res,i);
        }
    } 
}