class Main {
    public static void main(String[] args) {
        // System.out.println(search("asdahdfjhsjdfhuisatusvf3fdgfgdfgxzcvgzdfkszfgsf3", "f3fdgfgdfg"));
        System.out.println(search(createString(400000) + "asw4" + createString(100000), "asw4"));
        
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