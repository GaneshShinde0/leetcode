class Solution {

    public String largestTimeFromDigits(int[] A){
        String ans = "";
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    if(i==j||i==k||j==k) continue;
                    String h = ""+A[i]+A[j];
                    String m = ""+A[k]+A[6-i-j-k];
                    String time = h+":"+m;
                    if(h.compareTo("24")<0 && m.compareTo("60")<0 && ans.compareTo(time)<0) ans = time;
                }
            }
        }
        return ans;
    }
    public String largestTimeFromDigitsInitialDoesNotWork(int[] arr) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        Set<Integer> taken = new HashSet<>();
        String hours = getHours(taken, arr);
        String mins = getMins(taken, arr);
        if(hours.equals("")||mins.equals("")) return "";
        sb.append(hours).append(":");
        sb.append(mins);
        // if(sb.length()!=5) return "";
        return sb.toString();
    }
    private String getMins(Set<Integer> taken, int[] arr){
        String res = "";
        for(int i=3;i>=0;i--){
            if(arr[i]<6 && !taken.contains(i)){
                res+=arr[i];
                taken.add(i);
                break;
            }
        }
        for(int i=3;i>=0;i--){
            if(!taken.contains(i)){
                res+=arr[i];
                taken.add(i);
                break;
            }
        }
        return res;
    }
    private String getHours(Set<Integer> taken, int[] arr){
        String res = "";
        for(int i=3;i>=0;i--){
            if(arr[i]<=2){
                res+=arr[i];
                taken.add(i);
                break;
            }
        }
        if(res.length()==0) return "";
        for(int i=3;i>=0;i--){
            if((res.charAt(0)=='1'||res.charAt(0)=='0') && !taken.contains(i)){
                res+=arr[i];
                taken.add(i);
                break;
            }else if(res.charAt(0)=='2'){
                if(arr[i]<=3 && !taken.contains(i)){
                    res+=arr[i];
                    taken.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
