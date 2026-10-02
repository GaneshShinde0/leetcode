class Solution {
    int max;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = mentors.length, n = mentors[0].length;
        boolean[] visited = new boolean[m];
        recurse(visited, students, mentors, 0,0);
        return max;
    }

    private void recurse(boolean[] visited, int[][] students, int[][] mentors, int pos, int score){
        if(pos==students.length){
            max = Math.max(max, score);
            return;
        }
        for(int i=0;i<students.length;i++){
            if(!visited[i]){
                visited[i] = true;
                recurse(visited, students, mentors, pos+1, score+score(students[pos], mentors[i]));
                visited[i] = false;
            }
        }
    }

    private int score(int[] a, int[] b){
        int res = 0;
        for(int i=0;i<b.length;i++) if(a[i]==b[i]) res++;
        return res;
    }
}