import java.io.*;
import java.util.StringTokenizer;

public class bonusEP {
    public static void main(String[] args) {
        String input = in.next();
        char[] inputArr = input.toCharArray();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (inputArr[i] == '(' | inputArr[i] == ')' | inputArr[i] == ',') count++;
        }
        char[] useArr = new char[input.length()-count];
        int pointer = 0;
        for (int i = 0; i < input.length(); i++) {
            char doing = inputArr[i];
            if (inputArr[i] == '(' | inputArr[i] == ')' | inputArr[i] == ',') {
                continue;
            } else {
                useArr[pointer++] = doing;
            }
        }
        node root = new node(useArr[0]);
        buildTree(root,0,useArr);
        traverseNT(root);
        System.out.println();
        traverseF(root);
        System.out.println();
        traverseL(root);
    }
    static int buildTree(node a,int pointer,char[] useArr){
        char doing = useArr[pointer+1];
        a.LeftSon = new node(useArr[pointer+1]);
        pointer++;
        if (doing == '-' | doing == '*' | doing == '+' | doing == '/'){
            pointer = buildTree(a.LeftSon,pointer,useArr);
        }
        doing = useArr[pointer+1];
        a.RightSon = new node(useArr[pointer+1]);
        pointer++;
        if (doing == '-' | doing == '*' | doing == '+' | doing == '/'){
            pointer = buildTree(a.RightSon,pointer,useArr);
        }
        return pointer;
    }
    static void traverseF(node a){
        if (a == null) return;
        System.out.print(a.data);
        traverseF(a.LeftSon);
        traverseF(a.RightSon);
    }
    static void traverseL(node a){
        if (a == null) return;
        traverseL(a.LeftSon);
        traverseL(a.RightSon);
        System.out.print(a.data);
    }
    static void traverseNT(node a){
        if (a == null) return;
        char doing = a.data;
        if (doing == '-' | doing == '*' | doing == '+' | doing == '/'){
            System.out.print("(");
        }
        traverseNT(a.LeftSon);
        System.out.print(doing);
        traverseNT(a.RightSon);
        if (doing == '-' | doing == '*' | doing == '+' | doing == '/'){
            System.out.print(")");
        }
    }
    static class node {
        node LeftSon;
        node RightSon;
        char data;
        node(char a){
            data = a;
        }
    };
    static QReader in = new QReader();

    static class QReader {
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer = new StringTokenizer("");

        private String innerNextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String nextLine = innerNextLine();
                if (nextLine == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(nextLine);
            }
            return true;
        }

        public String nextLine() {
            tokenizer = new StringTokenizer("");
            return innerNextLine();
        }

        public String next() {
            hasNext();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
