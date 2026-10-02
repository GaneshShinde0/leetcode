class Video {
    String data;
    int likes, dislikes, views;
    public Video(String data) {
        this.data = data;
    }
    void like() {
        likes++;
    }
    void dislike() {
        dislikes++;
    }
    void view() {
        views++;
    }
}

class VideoSharingPlatform {
    TreeSet<Integer> availableIds = new TreeSet<>();
    List<Video> videos = new ArrayList<>();

    public VideoSharingPlatform() {
    }
    
    public int upload(String video) {
        Video newVideo = new Video(video);
        if (!availableIds.isEmpty()) {
            int id = availableIds.first();
            availableIds.remove(id);
            videos.set(id, newVideo);
            return id;
        } else {
            videos.add(newVideo);
            return videos.size() - 1;            
        }
    }
    
    public void remove(int videoId) {
        if (videoId < videos.size() && videos.get(videoId) != null) {
            videos.set(videoId, null);
            availableIds.add(videoId);
        }
    }
    
    public String watch(int videoId, int startMinute, int endMinute) {
        if (videoId < videos.size()) {
            Video video = videos.get(videoId);
            if (video == null) {
                return "-1";
            }
            video.view();
            return video.data.substring(startMinute, Math.min(endMinute + 1, video.data.length()));
        } else {
            return "-1";
        }
    }
    
    public void like(int videoId) {
        if (videoId < videos.size()) {
            Video video = videos.get(videoId);
            if (video == null) {
                return;
            }
            video.like();
        }
    }
    
    public void dislike(int videoId) {
        if (videoId < videos.size()) {
            Video video = videos.get(videoId);
            if (video == null) {
                return;
            }
            video.dislike();
        }
    }
    
    public int[] getLikesAndDislikes(int videoId) {
        if (videoId < videos.size()) {
            Video video = videos.get(videoId);
            if (video == null) {
                return new int[]{-1};
            }
            return new int[]{video.likes, video.dislikes};
        } else {
            return new int[]{-1};
        }
    }
    
    public int getViews(int videoId) {
        if (videoId < videos.size()) {
            Video video = videos.get(videoId);
            if (video == null) {
                return -1;
            }
            return video.views;
        } else {
            return -1;
        }
    }
}