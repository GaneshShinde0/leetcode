class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String,List<String>> result = new HashMap<>();
        for(String path:paths){
            String[] folderAndFiles = path.split(" ");
            String root = folderAndFiles[0];
            for(int i=1;i<folderAndFiles.length;i++){
                String file = folderAndFiles[i];
                int start = file.indexOf("(");
                int end = file.indexOf(")");
                result.computeIfAbsent(file.substring(start,end), k->new ArrayList<String>()).add(root+"/"+file.substring(0,start));
            }
        }
        return result.values().stream().filter(k->k.size()>=2).collect(Collectors.toList());
    }
}