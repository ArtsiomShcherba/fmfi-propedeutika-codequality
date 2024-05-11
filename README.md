This class is needed to concatenate matrices of a given size. For simple use it is enough to create input.txt file in (specified format)*, and run ConcatenateMatrices.java, the obtained result will be in output.txt file. The input and output file can be changed by changing the value of the inputfile and outputfile variables in the main() function, respectively. In addition, you can specify "console" as the value of both variables, in which case input/output will be performed from the console.
 !Note that if the input is performed from the console, you must also specify the number of matrices!

Input Data Format:
--The first line contains the numbers n,m, which stand for the number of rows and columns in each matrix, respectively. If the input is performed from the console, it is also necessary to specify the number k, which will mean the number of matrices (In this case the input will not finish until n*k rows are entered).
---There follow k*n rows, the i-th row of which contains (i%n)+1 row of the matrix ceil(i/n), where ceil is an upward rounding operation. 
---Each row after 1 must contain exactly m space-separated elements. 
--Each element is a string that does not contain punctuation marks.
--The last line must not contain an end-of-line character
Example of correct input:
2 5
askkrk o2 43 0203 ri
eqwoj 9 1 2 d
1 2 3 4 5

Output Data Format:
Each string is of the form 
[i,j]: value
where value is an element at position i,j of the response matrix

Matrix Structure:
To represent matrices in code, the Matrix class is used to store the dimensions of a matrix and a two-dimensional array of its elements. 
The class has 3 constructors:
1) Matrix(int n,int m) - creates an empty matrix with dimensions n,m
2) Matrix(int n,int m,String[][] els) - creates a matrix with dimensions n,m and fills it with els elements.
3) Matrix(Matrix a) - creates a copy of matrix a.
It has a static method to create a random matrix of given sizes. And also methods for writing (in output format) to file and console.

Static class methods:
run(String i, String o) - performs concatenation of matrices in input format* from file i and writes the result in output format* to file o.
concatenate(Matrix a, Matrix b) - concatenates matrices a and b and returns the result matrix by an instance of Matrix class.
concatenate_all(List<Matrix>) - similar to concatenate(a,b), but concatenates all matrices in the list.
random_test(int n,int m,int cnt) - creates an input file test.txt, which contains cnt matrices of size n*m filled with random values, and then concatenates them and writes the result to the file text_res.txt.
