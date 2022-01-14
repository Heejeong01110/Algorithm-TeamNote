import java.io.*;
import java.util.*;

public class Solution64064 {
    private static Set<Set<String>> result;
    public static void main(String[] args) throws IOException {
        String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] banned_id = { "*rodo", "*rodo", "******" };

        result = new HashSet<>();
        dfs(user_id, banned_id, new LinkedHashSet<>());
        result.size();
    }

    static void dfs(String[] user_id, String[] banned_id, Set<String> set) {
        if (set.size() == banned_id.length) {
            if (validateUsers(set, banned_id)) {
                result.add(new HashSet<>(set));
            }
        }

        for(String user : user_id){
            if(!set.contains(user)){
                set.add(user);
                dfs(user_id, banned_id, set);
                set.remove(user);
            }
        }
         
        return;
    }
    
    static public boolean validateUsers(Set<String> set, String[] banned_id) {
        int i = 0;
        for (String item : set) {
            if (!validateUser(item, banned_id[i++])) {
                return false;
            }
        }
        return true;
    }

    static public boolean validateUser(String user, String ban) {
        if (ban.length() != user.length())
            return false;
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) != '*' && ban.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
