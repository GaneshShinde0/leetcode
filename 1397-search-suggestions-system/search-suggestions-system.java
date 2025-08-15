class Solution {
    public List<List<String>> suggestedProductsSort(String[] products, String searchWord) {
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

    public List<List<String>> suggestedProductsPQ(String[] products, String searchWord) {
    PriorityQueue<String> pq = new PriorityQueue<>(3, (s1,s2) -> s1.compareTo(s2)); 
    List<List<String>> list = new ArrayList<>();
    
    for(int i = 1; i<=searchWord.length(); i++){
        String temp = searchWord.substring(0, i);
        for(String s : products){
        if(s.startsWith(temp)){
            pq.offer(s);
        }
        }
        List<String> temp_list = new ArrayList<>();
        for(int j = 0; j<3; j++){
        if(pq.peek() != null){
            temp_list.add(pq.poll());
        }
        }
        pq.clear();
        list.add(temp_list);
    }
    return list;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    TrieNode root = new TrieNode();

    private void insert(String product) {
        TrieNode node = root;
        for (char c : product.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];

            if (node.suggestions.size() < 3)
                node.suggestions.add(product);
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for (String product : products)
            insert(product);

        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;
        for (char c : searchWord.toCharArray()) {
            if (node != null)
                node = node.children[c - 'a'];
            if (node != null)
                result.add(node.suggestions);
            else
                result.add(new ArrayList<>());
        }

        return result;
    }
}