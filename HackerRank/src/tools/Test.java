package tools;

/**
 * Created by yuantian on 6/20/14.
 */

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        String fileName = "/home/yuantian/IdeaProjects/MyAlg/HackerRank/src/tools/input.txt";

        /***************************
           read with Scanner - slow
         ****************************/
        long start = System.currentTimeMillis();
        Scanner inScanner = new Scanner(new FileInputStream(fileName));
        int n = inScanner.nextInt();
        while(n-- > 1) {
            int x = inScanner.nextInt();
            long y = inScanner.nextLong();
            String c = inScanner.nextLine();

            //System.out.println("x = " + x + " y = " + y + " c = " + c);
        }
        System.out.println("total for Scanner = " + (System.currentTimeMillis() - start));


        /***************************
          input - fast
        ****************************/
        start = System.currentTimeMillis();
        Input input = new Input(new BufferedReader(new FileReader(fileName)));
        n = input.nextInt();
        while(n-- > 1) {
            int x = input.nextInt();
            long y = input.nextLong();
            String c = input.next();
        }
        System.out.println("total for Input = " + (System.currentTimeMillis() - start));


        /***************************
          input reader - fastest
         ****************************/
        start = System.currentTimeMillis();
        //InputReader in = new InputReader(System.in);
        InputReader in = new InputReader(new FileInputStream(fileName));
        n = in.nextInt();
        while(n-- > 1) {
            int x = in.nextInt();
            long y = in.nextLong();
            String c = in.nextString();
            //System.out.println("x = " + x + " y = " + y + " c = " + c);
        }
        System.out.println("total for InputReader = " + (System.currentTimeMillis() - start));
    }

    static class Input {
        BufferedReader in;
        StringBuilder sb = new StringBuilder();

        public Input(BufferedReader in) {
            this.in = in;
        }

        public String next() throws IOException {
            sb.setLength(0);
            while (true) {
                int c = in.read();
                if (c == -1) {
                    return null;
                }
                if (" \n\r\t".indexOf(c) == -1) {
                    sb.append((char)c);
                    break;
                }
            }
            while (true) {
                int c = in.read();
                if (c == -1 || " \n\r\t".indexOf(c) != -1) {
                    break;
                }
                sb.append((char)c);
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder sb = new StringBuilder(1024);
            do {
                sb.append((char)c);
                c = read();
            } while (!isSpaceChar(c));
            return sb.toString();
        }

        public static boolean isSpaceChar(int c) {
            switch (c) {
                case -1:
                case ' ':
                case '\n':
                case '\r':
                case '\t':
                    return true;
                default:
                    return false;
            }
        }
    }
}