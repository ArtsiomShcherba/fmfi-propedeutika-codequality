import java.util.*;
import java.io.*;


public class ConcatenateMatrices {

    protected static class IncorrectInputException extends Exception{
        IncorrectInputException(){
            super("INCORRECT INPUT, PLEASE CHECK README.TXT");
        }
    }

    //READING INPUT SECTION

    private static Matrix read_next_matrix(int n,int m,Scanner scanner) throws IncorrectInputException {
        Matrix next = new Matrix(n,m);

        for(int i=0;i<n;i++){
            if(!scanner.hasNextLine())
                throw new IncorrectInputException();
            String line = scanner.nextLine();
            String[] row = line.split(" ");
            if(row.length!=m) {
                throw new IncorrectInputException();
            }

            for(int j=0;j<m;j++)
                next.elems[i][j]=row[j];
        }

        return next;
    }

    private static List<Matrix> read(String filename) throws IncorrectInputException {
        Scanner scanner = null;
        int cnt = -1;
        boolean consoleRead = false;
        if (filename.toLowerCase()=="console") {
            scanner = new Scanner(System.in);
            consoleRead = true;
        }
        else try {
            scanner = new Scanner(new File(filename));
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

        if(consoleRead){  //if console inpute we also should read count of matrices
            if(!scanner.hasNextInt())
                throw new IncorrectInputException();
            cnt=scanner.nextInt();
            if(cnt<1)
                throw new IncorrectInputException();
        }

        scanner.nextLine(); //we should skip the first line to continue reading

        List<Matrix> input_matrices = new ArrayList<Matrix>();
        while (cnt>0&&scanner.hasNextLine()) {
            input_matrices.add(read_next_matrix(n, m, scanner));
            cnt--;
        }

        return input_matrices;
    }

    //FUNCTIONAL SECTION
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

    public static void run(String input, String output) throws IncorrectInputException {
        List<Matrix> input_matrices = read(input);
        Matrix ans = concatenate_all(input_matrices);
        if(output.toLowerCase()=="console"){
            ans.print();
        }
        else
            ans.print_to_file(output);
    }

    //TESTING SECTION

    public static void random_test(int n,int m,int cnt) {
        try {
            PrintStream output = new PrintStream("test.txt");
            output.println(n+" "+m);
            for(int i=0;i<cnt;i++){ //add matrix to test.txt
                Matrix next = Matrix.random_matrix(n,m);
                for(int a=0;a<next.n;a++){
                    String row = "";
                    for(int b=0;b<next.m;b++) {
                        row += next.elems[a][b];
                        if(b<next.m-1)
                            row+=" ";
                    }
                    output.println(row);
                }
            }
            run("test.txt","test_res.text");
        } catch (Exception e) {
            throw new RuntimeException("Impossible to write into test.txt");
        }
    }


    public static void main(String[] args) throws IOException, IncorrectInputException {
        String inputfile = "input.txt";
        String outputfile = "output.txt";
        run(inputfile,outputfile);
    }
}
