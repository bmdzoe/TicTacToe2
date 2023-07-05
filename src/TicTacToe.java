import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class TicTacToe {
    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> CPUPosition = new ArrayList<Integer>();
    public static void main (String [] args){
        char [] [] gameboard = {{' ' ,'|' , ' ' , '|', ' '},
                {'-' ,'+' , '-' , '+', '-'} ,
                { ' ' ,'|' , ' ' , '|', ' '} ,
                { '-' ,'+' , '-' , '+', '-'} ,
                { ' ' ,'|' , ' ' , '|', ' '}};
        printGameBoard(gameboard);
        while(true){
            Scanner myScan = new Scanner(System.in);
            System.out.println("Enter your placement 1-9");
            int post = myScan.nextInt();
            while(playerPosition.contains(post) ||  CPUPosition.contains(playerPosition)){
                System.out.println("Postion taken! Enter a correct postion");
                post = myScan.nextInt();
            }
            placePiece(gameboard,post,"player");
            String result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
            Random myrand = new Random();
            int cpupos = myrand.nextInt(9) + 1;
            while(playerPosition.contains(cpupos) ||  CPUPosition.contains(cpupos)){
                cpupos = myrand.nextInt(9) + 1;
            }
            placePiece(gameboard,cpupos,"cpu");
            printGameBoard(gameboard);
             result = checkWinner();
             if(result.length() > 0){
                 System.out.println(result);
                 break;
             }
            System.out.print(result);
        }
    }
    public static void printGameBoard(char [] [] gameboard){
        for(char [] row : gameboard){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void placePiece(char [] [] gameboard, int post, String user){
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'X';
            playerPosition.add(post);
        }else if(user.equals("cpu")){
            symbol = 'O';
            CPUPosition.add(post);
        }
        switch (post){
            case 1:
                gameboard[0][0] = symbol;
                break;
            case 2:
                gameboard[0][2] = symbol;
                break;
            case 3:
                gameboard[0][4] = symbol;
                break;
            case 4:
                gameboard[2][0] = symbol;
                break;
            case 5:
                gameboard[2][2] = symbol;
                break;
            case 6:
                gameboard[2][4] = symbol;
                break;
            case 7:
                gameboard[4][0] = symbol;
                break;
            case 8:
                gameboard[4][2] = symbol;
                break;
            case 9:
                gameboard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List middleRow = Arrays.asList(4,5,6);
        List bottomeRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List diagonal = Arrays.asList(1,5,9);
        List adiaganoal = Arrays.asList(7,5,3);
        List<List> winningconditions = new ArrayList<>();
        winningconditions.add(topRow);
        winningconditions.add(middleRow);
        winningconditions.add(bottomeRow);
        winningconditions.add(leftCol);
        winningconditions.add(midCol);
        winningconditions.add(rightCol);
        winningconditions.add(diagonal);
        winningconditions.add(adiaganoal);
        for(List l : winningconditions){
            if(playerPosition.containsAll(l)){
                return "Congratulaions you won";
            }else if(CPUPosition.containsAll(l)){
                return "CPU wins! Sorry.";
            }else if(playerPosition.size() + CPUPosition.size() == 9){
                return "TIE";
            }
        }
        return "";
    }
}
