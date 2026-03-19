public class Codec {
    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String,String> longUrlToShortCode = new HashMap<>(), shortCodeToLongURL=new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longUrlToShortCode.containsKey(longUrl)) return longUrlToShortCode.get(longUrl);
        String code = getCode();
        while(shortCodeToLongURL.containsKey(code)){
            code = getCode();
        }
        shortCodeToLongURL.put(code,longUrl);
        longUrlToShortCode.put(longUrl,code);
        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortCodeToLongURL.get(shortUrl);
    }

    private String getCode(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<6;i++){
            sb.append(chars.charAt((int)(Math.random()*62)));
        }
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));