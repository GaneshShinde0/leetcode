class Twitter {

    private Map<Integer, Set<Integer>> userAndFollowing;
    private Map<Integer, PriorityQueue<int[]>> tweets;
    int timestamp;
    public Twitter() {
        userAndFollowing = new HashMap<>();
        tweets = new HashMap<>();
        timestamp=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, x->new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]))).add(new int[]{timestamp++,tweetId});
        if(tweets.get(userId).size()>10) tweets.get(userId).poll();
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]); // Compare by most recent timestamps.
        Set<Integer> followees = userAndFollowing.getOrDefault(userId, new HashSet<>());
        followees.add(userId);
        for (int followee : followees) {
            PriorityQueue<int[]> tweetList = tweets.getOrDefault(followee, new PriorityQueue<>());
            pq.addAll(tweetList);
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 10) {
            res.add(pq.poll()[1]);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        userAndFollowing.computeIfAbsent(followerId, x->new HashSet<Integer>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(userAndFollowing.containsKey(followerId)) userAndFollowing.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */