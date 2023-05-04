class Main {
    public static void main(String[] args) {
        System.out.println(search("asdahdfjhsjdfhuisatusvf3fdgfgdfgxzcvgzdfkszfgsf3", "f3fdgfgdfg"));
    }

    public static String createString(int n) {
        return "";
    }

    public static int search(String str, String search) {
        int iteracoes = 0;
        int lenSearch = search.length();
        
        if (lenSearch > str.length()) {
            System.out.println("iteracoes: "+ iteracoes);
            return -1;
        }

        for (int x = 0; x <= str.length() - lenSearch; x++) {
            if (search.equals(str.substring(x, x+lenSearch))) {
                System.out.println("iteracoes: "+ iteracoes);
                return x;
            }
            iteracoes++;
        }
        
        System.out.println("iteracoes: "+ iteracoes);
        return -1;
    }
}