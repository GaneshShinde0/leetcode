class Solution {
    public String removeOccurrencesUsingReplace(String s, String part) {
        while(s.contains(part)){
            s=s.replaceFirst(part,"");
        }
        return s;
    }
    // Using String Builder
    public String removeOccurrences(String s, String part) 
    {
        StringBuilder sb=new StringBuilder(s);
        int partlen=part.length();
        while(sb.indexOf(part)!=-1)
        {
            int index=sb.indexOf(part);
            sb.delete(index,index+partlen);
        }
        return sb.toString();
    }
}
