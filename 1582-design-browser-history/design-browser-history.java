class BrowserHistory {
    List<String> history;
    int count;
    public BrowserHistory(String homepage) {
        this.history = new ArrayList<>();
        history.add(homepage);
        count=0;
    }
    
    public void visit(String url) {
        while(history.size()!=0 && history.size()>count+1) history.remove(history.size()-1);
        history.add(url);
        count++;
    }
    
    public String back(int steps) {
        count = Math.max(0,count-steps);
        return history.get(count);
    }
    
    public String forward(int steps) {
        count = Math.min(history.size()-1,count+steps);
        return history.get(count);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */