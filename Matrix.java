import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Matrix{
    int n,m;
    String[][] elems;
    public Matrix(int n, int m){
        this.n=n;
        this.m=m;
        elems = new String[n][m];
    }

    public Matrix(int n, int m,String[][] els){
        this(n,m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                elems[i][j]=els[i][j];
        }
    }

    public Matrix(Matrix a){
        this(a.n,a.m,a.elems);
    }

    public void print(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                System.out.println("["+i+","+j+"]: "+elems[i][j]);
        }
    }

    public void print_to_file(String filename) throws ConcatenateMatrices.IncorrectInputException {
        try {
            PrintStream output = new PrintStream(filename);
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++)
                    output.println("["+i+","+j+"]: "+elems[i][j]);
            }
        } catch (FileNotFoundException e) {
            throw new ConcatenateMatrices.IncorrectInputException();
        }
    }
}