class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int login = (getTime(loginTime)+14)/15;
        int logout = getTime(logoutTime)/15;
        if(getTime(logoutTime)<getTime(loginTime)) 
        return (logout+96-login);
        else return Math.max(0,(logout-login));
    }
    private int getTime(String time){
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
    }
}