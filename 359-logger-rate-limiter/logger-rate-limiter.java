class Logger {

    HashMap<String,Integer> hm;

    public Logger() {
        this.hm = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if((timestamp-hm.getOrDefault(message,-10))>=10){
            hm.put(message,timestamp);
            // System.out.println(message);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */