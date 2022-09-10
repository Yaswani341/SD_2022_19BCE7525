import java.util.*;

public class Chess {
    public static void main(String[] args) {
        String[][] chess=new String[5][5];
        for (int row=1;row<4;row++)
            for (int col=0;col<5;col++)
                chess[row][col]= "    ";
        for (int col=0;col<5;col++) {
            chess[0][col] ="B-P" + (col + 1);
            chess[4][col]= "A-P" + (col + 1);
        }
        printChessBoardStatus(chess);

            String str="";
        Scanner in=new Scanner(System.in);
            do{
                System.out.println("Enter you pawn number and move(<player_name>-<character_name>:<move>)");
                String combInput=in.next();
                String[] combInputArr=combInput.split(":");
                String pawn=combInputArr[0];
                String[] pawnSplit=pawn.split("-");
                String player=pawnSplit[0];
                String move=combInputArr[1];
                int pos[]=searchPos(chess,pawn);
                int rowPos=pos[0];
                int colPos=pos[1];
                System.out.println("ROW POS: "+rowPos);
                System.out.println("COL POS: "+colPos);
                if (updateChess(chess,move,rowPos,colPos,pawn,player))
                    chess[rowPos][colPos]="    ";
                printChessBoardStatus(chess);
            }while (str!="exit");
    }

    private static boolean updateChess(String[][] chess, String move, int rowPos, int colPos, String pawn,String player) {
        if (player.equals("B")) {
            if (move.equalsIgnoreCase("F")) {
                if (rowPos==4){
                    System.out.println("This move is not allowed");
                    return false;
                }
                chess[rowPos + 1][colPos] = pawn;
            }
            else if (move.equalsIgnoreCase("R")) {
                if (colPos==4){
                    System.out.println("This move is not allowed");
                    return false;
                }
                chess[rowPos][colPos + 1] = pawn;
            }
            else if (move.equalsIgnoreCase("L")) {
                if (colPos==0){
                    System.out.println("This move is not allowed");
                    return false;
                }
                chess[rowPos][colPos - 1] = pawn;
            }
            else if (move.equalsIgnoreCase("B")) {
                if (rowPos==0) {
                    System.out.println("This move is not allowed");
                    return false;
                }
                chess[rowPos - 1][colPos] = pawn;
            }
        }else if (player.equals("A")){
            if (move.equalsIgnoreCase("F")) {
                if (rowPos==0){
                    System.out.println("This move is not allowed");
                    return false;
                }
                chess[rowPos - 1][colPos] = pawn;
            }
            else if (move.equalsIgnoreCase("R")) {
                if (colPos==4){
                    System.out.println("This move is not allowed");
                    return false;
                }
                chess[rowPos][colPos + 1] = pawn;
            }
            else if (move.equalsIgnoreCase("L")) {
                if (colPos==0){
                    System.out.println("This move is not allowed");
                    return false;
                }
                chess[rowPos][colPos - 1] = pawn;
            }
            else if (move.equalsIgnoreCase("B")) {
                if (rowPos==4){
                    System.out.println("This move is not allowed");
                    return false;
                }
                chess[rowPos + 1][colPos] = pawn;
            }
        }
        return true;
    }

    private static boolean checkIfSquareEmpty(int rowPos, int colPos, String[][] chess) {
        if (chess[rowPos][colPos]=="")
            return true;
        else
            return false;
    }

    private static int[] searchPos(String[][] chess, String sc) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++)
                if (chess[row][col].equals(sc))
                    return new int[]{row, col};
        }
        return new int[]{};
    }

    public static void printChessBoardStatus(String[][] chess){
        for (int row=0;row<5;row++) {
            for (int col = 0; col < 5; col++)
                System.out.print(chess[row][col]+" ");
            System.out.println();
        }
    }
}
