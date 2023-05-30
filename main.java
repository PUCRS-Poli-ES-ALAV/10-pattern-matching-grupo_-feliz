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

        // System.out.println(search(txt, search));
        System.out.println(KMPSearch(search, txt));
       
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

    public static int KMPSearch(String pat, String txt){
        int M = pat.length();
        int N = txt.length();

        int lps[] = new int [M];
        int j = 0;

        // Calcula lps[] 
		computeLPSArray(pat, M, lps); 

		int i = 0; // index for txt[] 
		while (i < N) { 
			if (pat.charAt(j) == txt.charAt(i)) { 
				j++; 
				i++; 
			} 
			if (j == M) { 
				System.out.println("Found pattern "
								+ "at index " + (i - j)); 
                                // j = lps[j - 1]; 
                                return i-j;
			} 

			// mismatch após j matches 
			else if (i < N && pat.charAt(j) != txt.charAt(i)) { 
				// Não faz match dos caracteres lps[0..lps[j-1]], 
				// não é necesssário, eles combinarão 
				if (j != 0) 
					j = lps[j - 1]; 
				else
					i = i + 1; 
			} 
		} 
        return -1;

    }

    public static void computeLPSArray(String pat, int M, int lps[]) 
	{ 
		// tamanho do maior prefixo sufixo anterior 
		int len = 0; 
		int i = 1; 
		lps[0] = 0; // lps[0] is always 0 

		// loop calcula lps[i] for i = 1 to M-1 
		while (i < M) { 
			if (pat.charAt(i) == pat.charAt(len)) { 
				len++; 
				lps[i] = len; 
				i++; 
			} 
			else // (pat[i] != pat[len]) 
			{ 
				if (len != 0) { 
					len = lps[len - 1]; 
				} 
				else // if (len == 0) 
				{ 
					lps[i] = len; 
					i++; 
				} 
			} 
		} 
    }
}