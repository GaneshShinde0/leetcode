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

    public List<String> removeSubfoldersUsingSet(String[] folder) {
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

    public List<String> removeSubfoldersUsingSorting(String[] folder){
        Arrays.sort(folder);

        List<String> result = new ArrayList<>();
        result.add(folder[0]);

        for(int i=1;i<folder.length;i++){
            String lastFolder = result.get(result.size()-1);
            lastFolder+='/';

            if(!folder[i].startsWith(lastFolder)){
                result.add(folder[i]);
            }
        }

        return result;
    }

    static class TrieNode{
        boolean isEndOfFolder;
        HashMap<String, TrieNode> children;
        TrieNode(){
            this.isEndOfFolder = false;
            this.children = new HashMap<>();
        }
    }
    TrieNode root = new TrieNode();

    public List<String> removeSubfolders(String[] folder){
        for(String path:folder){
            TrieNode currentNode = root;
            String[] folderNames = path.split("/");

            for(String folderName: folderNames){
                if(folderName.equals("")) continue;

                if(!currentNode.children.containsKey(folderName)){
                    currentNode.children.put(folderName, new TrieNode());
                }

                currentNode = currentNode.children.get(folderName);
            }
            currentNode.isEndOfFolder = true;
        }

        List<String> result = new ArrayList<>();
        for(String path:folder){
            TrieNode currentNode = root;
            String[] folderNames = path.split("/");
            boolean isSubFolder = false;
            for(int i=0;i<folderNames.length;i++){
                if(folderNames[i].equals("")) continue;
                TrieNode nextNode = currentNode.children.get(folderNames[i]);

                if(nextNode.isEndOfFolder && i!= folderNames.length-1){
                    isSubFolder = true;
                    break;
                }
                currentNode = nextNode;
            }

            if(!isSubFolder) result.add(path);
        }
        return result;
    }
}
