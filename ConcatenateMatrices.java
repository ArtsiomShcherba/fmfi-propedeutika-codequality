import java.util.*;
import java.io.*;


public class ConcatenateMatrices {

    public static class IncorrectInputException extends Exception{
        IncorrectInputException(){
            super("INCORRECT INPUT, PLEASE CHECK README.TXT OR RUN ConcatenateMatrices.help() FOR ASSISTANCE");
        }
    }

    private static Matrix read_next_matrix(int n,int m,Scanner scanner) throws IncorrectInputException {
        Matrix next = new Matrix(n,m);

        for(int i=0;i<n;i++){
            if(!scanner.hasNextLine())
                throw new IncorrectInputException();
            String line = scanner.nextLine();
            String[] row = line.split(" ");
            if(row.length!=m)
                throw new IncorrectInputException();

            for(int j=0;j<m;j++)
                next.elems[i][j]=row[j];
        }

        return next;
    }

    private static List<Matrix> read(String filename) throws IncorrectInputException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("vstup.txt"));
        } catch (FileNotFoundException e) {
            throw new IncorrectInputException();
        }
        try {
            PrintStream output = new PrintStream("vystup.txt");
        } catch (FileNotFoundException e) {
            throw new IncorrectInputException();
        }

        int n=0,m=0;
        if(!scanner.hasNextInt())
            throw new IncorrectInputException();
        n=scanner.nextInt();

        if(!scanner.hasNextInt())
            throw new IncorrectInputException();
        m=scanner.nextInt();

        List<Matrix> input_matrices = new ArrayList<Matrix>();
        while (scanner.hasNextLine())
            input_matrices.add(read_next_matrix(n,m,scanner));

        return input_matrices;
    }

    public static void main(String[] args) throws IOException {

    }
}
