class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> displayTable = new ArrayList<>();
        TreeSet<Integer> tables = new TreeSet<>();
        TreeSet<String> dishes = new TreeSet<>();
        HashMap<String, Integer> dishToIndex = new HashMap<>();
        HashMap<Integer, Integer> tableToIndex = new HashMap<>();

        // Headers
        List<String> headers = new ArrayList<>();
        headers.add("Table");
        int idx = 1;
        int maxTables = 1;
        for(int i=0;i<orders.size();i++){
            String table = orders.get(i).get(1);
            String dish = orders.get(i).get(2);
            dishes.add(dish);
            tables.add(Integer.parseInt(table));
        }

        for(String dish:dishes){
            headers.add(dish);
            dishToIndex.put(dish,idx++);
        }
        for(Integer t:tables){
            tableToIndex.put(t,maxTables++);
        }
        displayTable.add(headers);
        List<String> temp = new ArrayList<String>();
        for(int i=0;i<idx;i++){
            temp.add("0");
        }
        for(int i=0;i<maxTables-1;i++){
            displayTable.add(new ArrayList<String>(temp));
        }
        for(int i=0;i<orders.size();i++){
            int tableIndex = tableToIndex.get(Integer.parseInt(orders.get(i).get(1)));
            String dish = orders.get(i).get(2);
            int currDishIndex = dishToIndex.get(dish);
            int oldValue = Integer.parseInt(displayTable.get(tableIndex).get(currDishIndex));
            displayTable.get(tableIndex).set(currDishIndex,String.valueOf(oldValue+1));
        }
        for(Map.Entry<Integer,Integer> entry:tableToIndex.entrySet()){
            displayTable.get(entry.getValue()).set(0,String.valueOf(entry.getKey()));
        }
        
        return displayTable;
    }
}


class SolutionBitSlow {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer,TreeMap<String,Integer>>hm=new TreeMap<>();
        Set<String>st=new HashSet<>();
        for(List<String>lst:orders){
            int table=Integer.parseInt(lst.get(1));
            String food=lst.get(2);
            st.add(food);
            if(hm.containsKey(table)){
                TreeMap<String,Integer>t=hm.get(table);
                t.put(food,t.getOrDefault(food,0)+1);
            }
            else {
                hm.put(table,new TreeMap<>());
                hm.get(table).put(food,1);
            }
        }
        List<List<String>>ans=new ArrayList<>();
        List<String>l=new ArrayList<>(st);
        Collections.sort(l);
        l.add(0,"Table");
        ans.add(l);

        for(Integer s:hm.keySet()){
            List<String>lst=new ArrayList<>();
            lst.add(s+"");
            TreeMap<String,Integer>tm=hm.get(s);
            for(int i=1;i<l.size();i++){
                if(tm.containsKey(l.get(i)))lst.add(tm.get(l.get(i))+"");
                else lst.add("0");
            }
            ans.add(lst);
        }
        return ans;
    }
    }