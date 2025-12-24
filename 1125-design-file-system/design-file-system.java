class FileSystemInitial {
    HashMap<String,Integer> hm;
    public FileSystemInitial() {
        this.hm = new HashMap<>();
        hm.put("",0);
    }
    
    public boolean createPath(String path, int value) {
        StringBuilder sb = new StringBuilder();
        int lastFolder = path.lastIndexOf("/");
        if(hm.containsKey(path.substring(0,lastFolder))&& !hm.containsKey(path)){
            hm.put(path, value);
            return true;
        }
        return false;
    }
    
    public int get(String path) {
        if(hm.containsKey(path)){
            return hm.get(path);
        }
        return -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */

 class FileSystem {
    private Map<String, Integer> map;

    public FileSystem() {
        map = new HashMap<>();
        map.put("/", 0); // root
    }

    public boolean createPath(String path, int value) {
        if (path.equals("/") || map.containsKey(path)) {
            return false;
        }

        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        if (parent.isEmpty()) {
            parent = "/";
        }

        if (!map.containsKey(parent)) {
            return false;
        }

        map.put(path, value);
        return true;
    }

    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
}
