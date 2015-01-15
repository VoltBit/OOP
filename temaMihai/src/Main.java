import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import gameoflife.Cell;
import gameoflife.BoundedField;
import gameoflife.BoundlessField;
import gameoflife.GameField;
import gameoflife.Game;

/**
 * The Main class of the homework. It contains a main method that takes command line arguments
 * in order to determine the type of game as well as the initial configuration of the game field.
 * @author Dumitru Mihai-Valentin - 325 CB
 */
public class Main {
    private static ArrayList<Cell> readArrListFromFile(Scanner in) {
        ArrayList<Cell> result;
        int sz = in.nextInt();
        
        result = new ArrayList<>(sz);
        for (int i = 0; i < sz; ++i) {
            result.add(new Cell(in.nextInt(), in.nextInt()));
        }
        return result;
    }
    
    /**
     * The main function must receive exactly three command line arguments: the game field type
     * ("bounded"/"boundless"), the input file and the output file.
     * The input file must contain a minimum height and a minium width of the game field,
     * a number of steps to be simulated, a number of cells present in the zeroth generation and
     * all the cells, defined as two integers (line, column).
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Game gameOfLife = Game.getInstance();
        GameField gameField;
        ArrayList<Cell> initialConfig;
        Scanner in;
        FileWriter out;
        int minHeight;
        int minWidth;
        int steps;
        
        if (args.length != 3) {
            throw new RuntimeException(args.length + "Insufficient command line arguments");
        }
        
        in = new Scanner(new File(args[1]));
        minHeight = in.nextInt();
        minWidth = in.nextInt();
        steps = in.nextInt();
        initialConfig = readArrListFromFile(in);
        
        if (args[0].equals("bounded")) {
            gameField = new BoundedField(initialConfig, minHeight, minWidth);
        } else if (args[0].equals("boundless")) {
            gameField = new BoundlessField(initialConfig);
        } else {
            throw new RuntimeException("Invalid first argument!");
        }
        
        gameOfLife.associateField(gameField);
        gameOfLife.next(steps);
        
        out = new FileWriter(new File(args[2]).getAbsoluteFile());
        out.write(gameOfLife.getField().toString());
        out.close();
    }
}
