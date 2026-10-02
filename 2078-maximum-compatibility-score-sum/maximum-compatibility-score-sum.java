class Solution {
    int res;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = mentors.length;
        boolean[] visited = new boolean[m];
        recurse(students, mentors, visited, 0, 0);
        return res;
    }
    private void recurse(int[][] students, int[][] mentors, boolean[] visited, int pos, int score){
        if(pos == students.length){
            res = Math.max(res, score);
            return;
        }
        for(int i=0;i<students.length;i++){
            if(!visited[i]){
                visited[i] = true;
                recurse(students, mentors, visited, pos+1, score+score(students[pos],mentors[i]));
                visited[i] = false;
            }
        }
    }
    private int score(int[] a, int[] b){
        int score=0;
        for(int i=0;i<a.length;i++) if(a[i]==b[i]) score++;
        return score;
    }
}