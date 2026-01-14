
class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> childToParent = new HashMap<>();
        String root = regions.get(0).get(0);
        childToParent.put(root,null);
        for(List<String> li:regions){
            for(int i=1;i<li.size();i++){
                childToParent.put(li.get(i),li.get(0));
            }
        }
        Set<String> parents = new HashSet<>();
        while(region1!=null){
            parents.add(region1);
            region1 = childToParent.get(region1);
        }
        while(!parents.contains(region2)){
            region2 = childToParent.get(region2);
        }
        return region2;

    }
}