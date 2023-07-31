class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase();
        
        char[] step1_arr = new_id.toCharArray();
        StringBuilder step2 = new StringBuilder();
        for (char c : step1_arr) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                step2.append(c);
            }
        }
        
        new_id = step2.toString();
        
        while (new_id.contains("..")){
            new_id = new_id.replace("..", ".");
        }
        
        if (new_id.length() > 0 && new_id.charAt(0) == '.'){
            new_id = new_id.substring(1, new_id.length());

        }
        
        
        if (new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
        }
        
        
        if (new_id.length() == 0){
            new_id = "a";
        }
        
        
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            
            if (new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
            }
        }
        
        
        while (new_id.length() <= 2){
            new_id += new_id.charAt(new_id.length() - 1);
        }
        
        return new_id;
    }
}