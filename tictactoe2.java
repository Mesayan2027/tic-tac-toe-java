import java.util.Random;
import java.util.Scanner;

public class tictactoe2 {
    static Scanner s = new Scanner(System.in);
    static int ch = 1, cnf=1 , cn = 0;
    static String turnstate, g, d;
    static int row,col,dd,ro,c;
    static Random r = new Random();

    public static void main(String[] args) {
        System.out.println("enter 1 for pvp or 2 for cvp");
        int gt = s.nextInt();
        switch (gt) {
            case 1:
                pvp();
                break;
            case 2:
                cvp();
                break;
        }
    }

    public static void pvp() {
        System.out.println("this is player vs player");
        String[][] board = new String[3][3];
        System.out.println("here is your board");
        boardp(board);
        String in = "-";
        int ts = r.nextInt(2);
        if (ts == 1) {
            System.out.println("X won toss ");
            turnstate = "X";
        } else {
            System.out.println("O won toss");
            turnstate = "O";
        }
        while (ch < 8) {
            if (turnstate.equals("X")) {
                tsX(in, board);
            } else if (turnstate.equals("O")) {
                tsO(in, board);
            }
        }
    }

    public static void tsX(String in, String[][] board) {
        if (ch <= 9) {
            System.out.println("chance of Cross X");
            in = "X";
            System.out.println("enter row no");
            row = s.nextInt();
            System.out.println("enter col no");
            col = s.nextInt();
            turnstate = "X";
            String m = check(row - 1, col - 1, board, turnstate);
            if (!m.equals("X")) {
                update(board, row - 1, col - 1, in);
                turnstate = "O";
            }
        }
    }

    public static void tsO(String in, String[][] board) {
        if (ch <= 9) {
            System.out.println("chance of NoUGHT O");
            in = "O";
            System.out.println("enter row no");
            row = s.nextInt();
            System.out.println("enter col no");
            col = s.nextInt();
            turnstate = "O";
            String m = check(row - 1, col - 1, board, turnstate);
            if (!m.equals("O")) {
                update(board, row - 1, col - 1, in);
                turnstate = "X";
            }
        }
    }

    public static void update(String[][] board, int row, int col, String in) {
        board[row][col] = in;
        bupdate(board);
    }

    public static void boardp(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (i == 1 || i == 2) {
                System.out.println("------");
            }
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "-";
                String a = board[i][j];
                System.out.print(a + "|");
            }
            System.out.println("");
        }
    }

    public static void bupdate(String[][] board) {
        //ch++;
        for (int i = 0; i < board.length; i++) {
            if (i == 1 || i == 2) {
                System.out.println("------");
            }
            for (int j = 0; j < board.length; j++) {
                String a = board[i][j];
                System.out.print(a + "|");
            }
            System.out.println("");
        }
        wincheck(board);
    }

    public static String check(int row, int col, String[][] board, String turnstate) {
        if (board[row][col].equals("X") || board[row][col].equals("O")) {
            String g = turnstate;
            //ch-=1;
        } else {
            if (turnstate.equals("X")) {
                g = "O";
                ch++;
            } else {
                g = "X";
                ch++;
            }
        }
        return g;
    }

    public static void wincheck(String[][] a) {
        String line = " ";
        int ee=1;
        for (int i = 0; i <= 8; i++) {
            switch (i) {
                case 1 -> line = a[0][0] + a[0][1] + a[0][2];
                case 2 -> line = a[1][0] + a[1][1] + a[1][2];
                case 3 -> line = a[2][0] + a[2][1] + a[2][2];
                case 4 -> line = a[0][0] + a[1][0] + a[2][0];
                case 5 -> line = a[0][1] + a[1][1] + a[2][1];
                case 6 -> line = a[0][2] + a[1][2] + a[2][2];
                case 7 -> line = a[2][0] + a[1][1] + a[0][2];
                case 8 -> line = a[0][0] + a[1][1] + a[2][2];
            }
            if (line.equals("XXX")) {
                System.out.println("X won");
                ch += 10;
                ee=10;
            } else if (line.equals("OOO")) {
                System.out.println("O won");
                ch += 10;
                ee=10;
            }
        }
    }

    public static void cvp() {
        System.out.println("this is computer vs player");
        String[][] board = new String[3][3];
        System.out.println("here is your board");
        boardp(board);
        String in = "-";
        System.out.println("you are X");
        int ts = r.nextInt(2);
        if (ts == 1) {
            System.out.println("X won toss ");
            turnstate = "X";
        } else {
            System.out.println("O won toss");
            turnstate = "O";
        }
        while (ch < 10) {
            if (turnstate.equals("X")) {
                tsX(in, board);
                //System.out.println(ch);
            } else if (turnstate.equals("O")) {
                tsOc(in, board,row,col,ro,c);
                //System.out.println(ch);
            }
        }
    }
    public static void tsOc(String in, String[][] board,int row,int col,int ro,int c) {
        if (ch <= 9) {
            int max = 2, min = 0;
            System.out.println("chance of NoUGHT O");
            in = "O";
            //System.out.println("cnf"+cnf);
            if(cnf!=10) {
                row = (int) (Math.random() * (max - min + 1) + min);
                col = (int) (Math.random() * (max - min + 1) + min);
                //System.out.println("ramdom in action"+row +" "+ col);
                winalg(board,row,col);
            }
            else if(cnf==10&&ch<=9) {
                row = ro;
                col = c;
                //System.out.println("non random"+row +" "+ col);
                ch=10000;
            }
            turnstate = "O";
            String m = check(row , col , board, turnstate);
            if (!m.equals("O")) {
                update(board, row , col , in);
                turnstate = "X";
            }
        }
    }
    public static void winalg(String[][] a,int row,int col) {
        String line = " ";
        for (int i = 0; i <= 8; i++) {
            switch (i) {
                case 1 -> line = a[0][0] + a[0][1] + a[0][2];
                case 2 -> line = a[1][0] + a[1][1] + a[1][2];
                case 3 -> line = a[2][0] + a[2][1] + a[2][2];
                case 4 -> line = a[0][0] + a[1][0] + a[2][0];
                case 5 -> line = a[0][1] + a[1][1] + a[2][1];
                case 6 -> line = a[0][2] + a[1][2] + a[2][2];
                case 7 -> line = a[2][0] + a[1][1] + a[0][2];
                case 8 -> line = a[0][0] + a[1][1] + a[2][2];
            }
            if (line.equals("OO-") || line.equals("O-O") || line.equals("-OO")) {
                for (int ro = 0; ro < a.length; ro++) {
                    for (int c = 0; c < a[ro].length; c++) {
                        if (a[ro][c].equals("-")) {
                            row=ro;
                            //System.out.println("added"+ro);
                            col=c;
                            //System.out.println("added"+c);
                            a[row][col]="O";
                            int dd=wincheck2(a);
                            if(dd==10){
                                a[row][col]="-";
                                row=ro;
                                col=c;
                                tsOc(null,a,row,col,ro,c);
                                break;
                            }
                            else{
                                a[row][col]="-";
                            }
                            break;
                        }
                    }
                }
            }
            if(i==8||dd>=10){
                break;
            }
        }
    }
    public static int wincheck2(String[][] a) {
        String line=" ";
        for(int i=0;i<=8;i++){
            switch (i) {
                case 1 -> line = a[0][0] + a[0][1] + a[0][2];
                case 2 -> line = a[1][0] + a[1][1] + a[1][2];
                case 3 -> line = a[2][0] + a[2][1] + a[2][2];
                case 4 -> line = a[0][0] + a[1][0] + a[2][0];
                case 5 -> line = a[0][1] + a[1][1] + a[2][1];
                case 6 -> line = a[0][2] + a[1][2] + a[2][2];
                case 7 -> line = a[2][0] + a[1][1] + a[0][2];
                case 8 -> line = a[0][0] + a[1][1] + a[2][2];
            }
            if(line.equals("OOO")){
               // System.out.println("ran");
                cnf=10;
            }
            if(cnf==10){
               // System.out.println("cnf changed");
                dd=10;
                break;
            }
            else{
                cnf=1;
               // System.out.println("cnf remain");
            }
        }
        return cnf;
    }
}