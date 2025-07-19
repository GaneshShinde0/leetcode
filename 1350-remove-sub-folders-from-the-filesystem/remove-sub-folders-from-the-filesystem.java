class Solution {
    public List<String> removeSubfoldersBF(String[] folder) {
        Set<String> set = new LinkedHashSet<>();
        for(String s: folder) set.add(s);
        
        for(int i=0;i<folder.length;i++){
            for(int j=0;j<folder.length;j++){
                // System.out.println(set);
                if(i!=j && folder[i].startsWith(folder[j]+'/')) set.remove(folder[i]);
            }
        }
        List<String> li = new ArrayList<>();
        for(String s: set){
            li.add(s);
        }
        return li;
    }

    public List<String> removeSubfolders(String[] folder) {
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        List<String> result = new ArrayList<>();
        for(String f:folder){
            boolean isSubFolder = false;
            String prefix = f;

            // Check if all prefixes of the current folder are there
            while(!prefix.isEmpty()){
                int pos = prefix.lastIndexOf('/');
                if(pos == -1 )break;

                prefix = prefix.substring(0,pos);

                if(folderSet.contains(prefix)){
                    isSubFolder = true;
                    break;
                }
            }
            if(!isSubFolder){
                result.add(f);
            }
        }
        return result;
    }
}