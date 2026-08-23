class ThroneInheritance {
    String king;
    HashMap<String, List<String>> parChild;
    HashSet<String> deceased;
    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.parChild = new HashMap<String, List<String>>();
        this.deceased = new HashSet<String>();
    }
    
    public void birth(String parentName, String childName) {
        this.parChild.computeIfAbsent(parentName, x-> new ArrayList<String>()).add(childName);
    }
    
    public void death(String name) {
        this.deceased.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> inheritanceOrder = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        dfs(king, inheritanceOrder, visited);
        return inheritanceOrder;
    }

    private void dfs(String curr, List<String> currOrder, Set<String> visited){
        if(visited.contains(curr)) return;
        if(!deceased.contains(curr)) currOrder.add(curr);
        visited.add(curr);
        if(!parChild.containsKey(curr)) return;
        for(String child:parChild.get(curr)){
            if(!visited.contains(child)){
                dfs(child, currOrder, visited);
            }
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */