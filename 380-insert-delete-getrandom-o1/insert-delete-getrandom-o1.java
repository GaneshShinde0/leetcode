class RandomizedSet 
{
    ArrayList<Integer> arrlist;
    HashMap<Integer,Integer> hm;
    Random rand = new Random();
    public RandomizedSet() 
    {
        arrlist=new ArrayList<>();
        hm=new HashMap<>();
        
    }
    
    public boolean insert(int val) 
    {
        if(hm.containsKey(val))
        {
            return false;
        }
        else
        {
            hm.put(val,arrlist.size());
            arrlist.add(val);
            return true;
        }
        
    }
    
    public boolean remove(int val) 
    {
        if(!hm.containsKey(val))
        {
            return false;
        }
        int position=hm.get(val);
        if(position!=(arrlist.size()-1)){
            int lastelevalue=arrlist.get(arrlist.size()-1);
            arrlist.set(position,lastelevalue);
            hm.put(lastelevalue,position);
        }
        hm.remove(val);
        arrlist.remove(arrlist.size()-1);
        return true;
    }
    
    public int getRandom() 
    {
     int randomval=rand.nextInt(arrlist.size());
     return arrlist.get(randomval);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */