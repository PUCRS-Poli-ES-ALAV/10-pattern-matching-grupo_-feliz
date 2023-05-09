import java.util.Set;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        // System.out.println(search("asdahdfjhsjdfhuisatusvf3fdgfgdfgxzcvgzdfkszfgsf3", "f3fdgfgdfg"));

        // String txt = createString(400000) + "asw4" + createString(100000);
        // String search = "asw4";
        String txt = "aaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String search = "aab";
        System.out.println(search(txt, search));
        System.out.println(search2(txt, search));
        
    }

    public static String createString(int n) {
        String Alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"abcdefghijklmnopqrstuvwxyz";

        StringBuilder sb = new StringBuilder(n);

        for(int i = 0; i < n; i++){
            int index = (int)(Alfabeto.length()*Math.random());
            sb.append(Alfabeto.charAt(index));
        }

        return sb.toString();
    }

    public static int search(String str, String search) {
        int iteracoes = 0;
        int lenSearch = search.length();
        
        if (lenSearch > str.length()) {
            System.out.println("iteracoes: "+ iteracoes);
            return -1;
        }

        for (int x = 0; x <= str.length() - lenSearch; x++) {
            iteracoes++;
            if (search.equals(str.substring(x, x+lenSearch))) {
                System.out.println("iteracoes: "+ iteracoes);
                return x;
            }
        }
        
        System.out.println("iteracoes: "+ iteracoes);
        return -1;
    }

    // static private int Q = 2147483629;
    static private long Q = 9223372036854775783L;
    static private int R = 0;
    public static int search2(String str, String search) {
        int iteracoes = 0;
        int lenStr = str.length();
        int lenSearch = search.length();
        calculeR(str);
        long hashSearch = hash(search, lenSearch);
        
        if (lenSearch > lenStr) {
            System.out.println("iteracoes: "+ iteracoes);
            return -1;
        }

        for (int x = 0; x <= lenStr - lenSearch; x++) {
            iteracoes++;
            long txtHash = hash(str.substring(x, x+lenSearch), lenSearch);
            if (hashSearch == txtHash) {
                System.out.println("iteracoes: "+ iteracoes);
                return x;
            }
        }
        
        System.out.println("iteracoes: "+ iteracoes);
        return -1;
    }

    static private long hash(String s, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
           h = (h * R + s.charAt(j)) % Q;
        return h;
    }

    static private void calculeR(String s) {
        Set<Character> set = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (set.add(s.charAt(i))) {
                R = R + 1;
            }
        }
    }
}