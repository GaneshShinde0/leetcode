class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int start=0;
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            String s = searchWord.substring(0,i+1);
            List<String> li = new ArrayList<>();
            boolean first= false;
            for(int j=start;j<products.length && li.size()<3;j++){
                if(products[j].startsWith(s)){
                    if(!first){
                        start = j;
                        first = true;
                    }
                    li.add(products[j]);
                }
            }
            res.add(li);
        }
        return res;
    }
}