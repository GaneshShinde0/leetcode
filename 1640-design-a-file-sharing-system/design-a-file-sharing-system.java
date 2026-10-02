class FileSharing {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Map<Integer, Set<Integer>> userToChunks = new TreeMap<>();

    public FileSharing(int m) {
        pq.add(1);
    }

    public int join(List<Integer> ownedChunks) {
        int id = pq.poll();
        if (pq.isEmpty()) {
            pq.add(id + 1);
        }
        userToChunks.put(id, new HashSet<>(ownedChunks));
        return id;
    }

    public void leave(int userID) {
        pq.add(userID);
        userToChunks.remove(userID);
    }

    public List<Integer> request(int userID, int chunkID) {
        List<Integer> res = new LinkedList<>();
        for (Integer user : userToChunks.keySet()) {
            if (userToChunks.get(user).contains(chunkID)) {
                res.add(user);
            }
        }     
        if (res.size() != 0) userToChunks.get(userID).add(chunkID);
        return res;
    }
    
}