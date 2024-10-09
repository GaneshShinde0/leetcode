public class EncodeDecodeTinyUrl {

    Map<String, String> urlMap = new HashMap<>(), codeDB = new HashMap<>();
    static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private String getCode(){
        char[] code = new char[6];
        for(int i=0;i<6;i++){
            code[i] = chars.charAt((int) (Math.random()*62));
        }
        return "http://tinyurl.com/"+String.valueOf(code);
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        // return longUrl;
        if (urlMap.containsKey(longUrl)) return urlMap.get(longUrl);
        String code = getCode();
        while(codeDB.containsKey(code)) code = getCode();
        codeDB.put(code, longUrl);
        urlMap.put(longUrl,code);
        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        // return shortUrl
        return codeDB.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
