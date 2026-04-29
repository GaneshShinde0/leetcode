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
class SolutionOther {
    public String largestTimeFromDigits(int[] arr) {
        int[] freq = new int[10];
        for(int num : arr){
            freq[num]++;
        }

        if(freq[0] == 0 && freq[1] == 0 && freq[2] == 0) return "";

        StringBuilder sb = new StringBuilder();
        helper(sb, freq, 0, false);
        String temp = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < temp.length(); i++){
            sb2.append(temp.charAt(i));
            if(i == 1){
                sb2.append(':');
            }
        }
        return sb2.toString();
    }

    private boolean helper(StringBuilder sb, int[] freq, int i, boolean isTight){
        if(i == 4) return true;


        int upperBound = 0;
        if(i == 0){
            upperBound = 2;
        }else if(i == 1 && isTight){
            upperBound = 3;
        }else if(i == 2){
            upperBound = 5;
        }else{
            upperBound = 9;
        }
        
        for(int d = upperBound; d >= 0; d--){
            if(freq[d] > 0){
                sb.append((char)(d + '0'));
                freq[d]--;
                boolean nextTight = (i == 0 && d == 2);
                if(helper(sb, freq, i + 1, nextTight)) return true;
                // System.out.println(List.of(i, d));
                sb.deleteCharAt(sb.length() - 1);
                freq[d]++;
            }
        }
        return false;

    }
}