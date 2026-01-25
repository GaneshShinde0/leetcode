/*
["TextEditor","addText","deleteText","addText","cursorRight","cursorLeft","deleteText","cursorLeft","cursorRight"]
[[],["leetcode"],[4],["practice"],[3],[8],[10],[2],[6]]

sb = "", cursor = 0
sb = "leetcode", cursor = 8
sb = "leet", cursor = 4 => 4
sb = "leetpractice", cursor = 12 
sb = "leetpractice", cursor = 4 
sb = "practice", cursor = 0 => 4


*/

class TextEditor {

    StringBuilder sb;
    int cursor;
    public TextEditor() {
        sb = new StringBuilder();
        cursor = 0;
    }
    
    public void addText(String text) {
        sb.insert(cursor,text);
        cursor = cursor+text.length();
    }
    
    public int deleteText(int k) {
        int len = cursor;
        int deletedFrom = Math.max(0,cursor-k);
        sb.delete(deletedFrom,cursor);
        cursor = deletedFrom;
        return Math.min(k,len);
    }
    
    public String cursorLeft(int k) {
        cursor = Math.max(0,cursor-k);
        return sb.substring(Math.max(cursor-10,0),cursor);
    }
    
    public String cursorRight(int k) {
        cursor = Math.min(sb.length(),cursor+k);
        return sb.substring(Math.max(cursor-10,0),cursor);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */