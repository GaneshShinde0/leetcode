/*
Approach: Chunked Transfer Encoding:
- It is a method used in data communications protocols to send data in self-contained chunks, each of which is accompanied by its length or size. In the context of our problem, this technique can be very useful.

- In encoding, Instead of just joining all the strings together with a delimeter, we would precede each string with its length, followed by delimiter, and then the string itself. This way, even if our string contains the delimiter, we can correctly identify the string boundaries. 

- During Decode, we know that first item before the delimiter is the length of the string. Consider an example for a list of strings using chunked transfer encoding.

- Suppose we have following list of strings ["Hello", "World","/:Example/:"]. As you cann see our last string even contains /: character sequence that we might choose as our delimiter.
- Lets see hhow we would encode and decode this using chunked transfer encoding.

## Encoding
- For the encoding, we take each strings length, followed by delimiter (we will use/:) and then string itself;
- For "Hello", the length is 5 so encoded string will be 5/: Hello
- Next for "World" 5/:World
- For "/:Example/:" length is 11. We add 11/:/:Example/: to our encoded string. After processing all strings, our encoded string becomes
    5/:Hello5/:World11/:/:Example/:
- We could also use delimiter 5| as well, and it would not cause any issue
## Decoding:
- First we read until we encounter /:, which gives us 5; This tells us that length of our first string is 5. So we read next 5 characters to get Hello
- And so on, finally we will get ["Hello", "World", "/:Example/:"]
- It will also takes care of any String with numberics at end as "hello55" will be saved as "7/:hello55"
*/
public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
       StringBuilder sb = new StringBuilder();
       for(String s: strs){
            sb.append(s.length()).append("|").append(s);
       } 
       return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int delim = s.indexOf("|",i);
            int length = Integer.parseInt(s.substring(i,delim));
            String str = s.substring(delim+1, delim+1+length);
            res.add(str);
            i = delim+length;
        }
        return res;
    }
}

class CodecInitial {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s.replace("|","||")).append("|,");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0;i<s.length();i++){
            if(i<n-1 && s.charAt(i)=='|' && s.charAt(i+1)=='|'){
                sb.append("|");
                i++;
            }else if(i<n-1 && s.charAt(i)=='|' && s.charAt(i+1)==','){
                res.add(sb.toString());
                sb = new StringBuilder();
                i++;
            }else{
                sb.append(s.charAt(i));
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
