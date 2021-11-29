package DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_트리 {
    static int T;
    static int[] pArr,iArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine().trim());
            pArr = new int[N];
            iArr = new int[N];
            st = new StringTokenizer(br.readLine().trim());
            for(int i = 0; i < N; i++){
                pArr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine().trim());
            for(int i = 0; i < N; i++){
                iArr[i] = Integer.parseInt(st.nextToken());
            }
            self = 0;
            Node root = makeTree(0,N-1);
            postOrder(root, sb);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static void postOrder(Node node, StringBuilder sb){
        if(node.left != null) postOrder(node.left, sb);
        if(node.right != null) postOrder(node.right, sb);
        sb.append(node.data).append(" ");
    }
    static int self;
    static Node makeTree(int start, int end){
        if(start > end) return null;

        int index = self++;
        Node node = new Node(pArr[index]);
        node.left = makeTree(start, getIindex(index) - 1);
        node.right = makeTree( getIindex(index) + 1, end);
        
        return node;
    }

    static int getIindex(int self){
        for(int i=0;i<iArr.length;i++){
            if(pArr[self]==iArr[i]) return i;
        }
        return -1;
    }

    static class Node {
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }
}