class Solution {
    public String findContestMatch(int n) {
        List<StringBuilder> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new StringBuilder(String.valueOf(i+1)));
        }
        // System.out.println(li);
        while(n>0){
            for(int i=0;i<n/2;i++){
                li.get(i).insert(0,"(");
                // li.get(i).append(")");
                // li.get(n-i-1).insert(0,"(");
                li.get(i).append(",");
                li.get(n-i-1).append(")");
                li.get(i).append(li.get(n-i-1));
            }
            n/=2;
        }
        return li.get(0).toString();
    }
}

/*
1 2 3 4 5 6 7 8
1 8, 2 7, 3 6, 4,5
1 8 4 5, 2,7, 2, 6
*/