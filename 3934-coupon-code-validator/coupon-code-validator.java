class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> res = new ArrayList<>();
        int n = code.length;
        // First col code, 2nd Business, 3rd Act
        String[][] codeToBusinessLine = new String[n][3];
        for(int i=0;i<n;i++){
            String priority = getPriority(businessLine[i]);
            if(isActive[i] && isAlnum(code[i]) && !priority.equals("5")){
                codeToBusinessLine[i][0] = code[i];
            }
            codeToBusinessLine[i][1] = priority;
        }
        // Arrays.sort(codeToBusinessLine,(a,b)->{
        //     if(!a[1].equals(b[1])) return a[1].compareTo(b[1]);
        //     if(a[1].equals(b[1]) && a[0]!=null && b[0]!=null) return a[0].compareTo(b[0]);
        //     return 0;
        //     });
        
        
        Arrays.sort(codeToBusinessLine, Comparator
    .comparing((Object[] row) -> (String) row[1], Comparator.nullsFirst(String::compareTo))
    .thenComparing(row -> (String) row[0], Comparator.nullsFirst(String::compareTo)));
        for(int i=0;i<n;i++){
            if(!codeToBusinessLine[i][1].equals("5") &&  codeToBusinessLine[i][0]!=null &&  !codeToBusinessLine[i][0].isEmpty()) res.add(codeToBusinessLine[i][0]);
        }
        return res;
    }
    private boolean isAlnum(String s){
        for(char c:s.toCharArray()){
            if(!Character.isLetterOrDigit(c) && c!='_') return false;
        }
        return true;
    }
    private boolean validBusinessLine(String s){
        return (s.equals("electronics")||s.equals("grocery")||s.equals("pharmacy")||s.equals("restaurant"));
    }
    private String getPriority(String s){
        if(s.equals("electronics")) return "1";
        else if (s.equals("grocery")) return "2";
        else if (s.equals("pharmacy")) return "3";
        else if (s.equals("restaurant")) return "4";
        else return "5";
    }
}