import java.util.*;
import java.io.*;


public class ConcatenateMatrices {

    private static class IncorrectInputException extends Exception{
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

    public static Matrix concatenate(Matrix a, Matrix b) throws IncorrectInputException {
        Matrix res = new Matrix(a);
        if(res.n!=b.n||res.m!=b.m)
            throw new IncorrectInputException();
        for(int i=0;i<res.n;i++){
            for(int j=0;j<res.m;j++)
                res.elems[i][j]+=b.elems[i][j];
        }
        return res;
    }

    public static Matrix concatenate_all(List<Matrix> matrices) throws IncorrectInputException {
        if(matrices.isEmpty())
            throw new IncorrectInputException();
        Matrix res = new Matrix(matrices.get(0));

        for(int i=1;i<matrices.size();i++)
            res = concatenate(res,matrices.get(i)); //we concatenate matrices 1 by 1
        return res;
    }

    public static void main(String[] args) throws IOException {

    }
}
