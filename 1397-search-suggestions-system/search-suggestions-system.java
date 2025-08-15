class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            String s = searchWord.substring(0,i+1);
            List<String> li = new ArrayList<>();
            for(int j=0;j<products.length && li.size()<3;j++){
                if(products[j].startsWith(s)){
                    li.add(products[j]);
                }
            }
            res.add(li);
        }
        return res;
    }
}