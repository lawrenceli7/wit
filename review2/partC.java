package edu.wit.cs.comp1050;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Solution to PA2c
 * 
 * @author Lawrence Li
 *
 */
public class PA2c {

	/**
	 * Error to output if can't open any files
	 */
	public static final String ERR_FILE = "Error opening file(s)";

	/**
	 * Error to output if files open but matrices are of incompatible dimensions for
	 * multiplication
	 */
	public static final String ERR_DIMS = "Bad matrix dimensions";

	private static void _outputMatrix(PrintWriter out, int[][] m, boolean includeDimensions) {
		for (int r = 0; r < m.length; r++) {
			if (includeDimensions && r == 0) {
				out.printf("%d%n%d%n", m.length, m[0].length);
			}
			for (int c = 0; c < m[r].length; c++) {
				out.printf("%d", m[r][c]);
				out.printf((c < m[r].length - 1) ? " " : "%n");
			}
		}
	}

	/**
	 * Prints a matrix to the terminal without dimensions
	 * 
	 * @param m matrix to print
	 */
	public static void printMatrix(int[][] m) {
		_outputMatrix(new PrintWriter(System.out, true), m, false);
	}

	/**
	 * Prints a matrix to a file with associated dimensions
	 * 
	 * @param m  matrix to print
	 * @param pw open file
	 */
	public static void printMatrix(int[][] m, PrintWriter pw) {
		_outputMatrix(pw, m, true);
	}

	/**
	 * Checks if two matrices can be multiplied (i.e. the columns of the first match
	 * the rows of the second)
	 * 
	 * @param m1 matrix 1
	 * @param m2 matrix 2
	 * @return true if m1 x m2 is legal
	 */
	public static boolean canMultiply(int[][] m1, int[][] m2) {
		if (m1.length == 0 || m2.length == 0) {
			return false;
		}
		int m1_column = m1[0].length;
		int m2_row = m2.length;
		if (m1_column == m2_row) {
			return true;
		}
		return false;
	}

	/**
	 * Reads and returns a matrix from a scanner Format: m (# rows) n (# #cols) r0c0
	 * r0c1 ... r0cn (values in row 0, column-by-column) r1c0 r1c1 ... r1cn (values
	 * in row 1, column-by-column) ... rmc0 rmc1 ... rmcn (values in last row,
	 * column-by-column)
	 * 
	 * Results in... int[][] { {r0c0, r0c1, ... r0cn}, {r1c0, r1c1, ... r1cn}, ...
	 * {rmc0, rmc1, ... rmcn} }
	 * 
	 * @param s input source
	 * @return resulting matrix
	 */
	public static int[][] readMatrix(Scanner s) {
		int row = s.nextInt();
		int column = s.nextInt();
		int[][] matrix = new int[row][column];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = s.nextInt();
			}
		}
		return matrix;
	}

	/**
	 * Multiply two matrices and return the result
	 * 
	 * @param m1 matrix 1
	 * @param m2 matrix 2
	 * @return result of m1 x m2
	 */
	public static int[][] matrixMultiply(int[][] m1, int[][] m2) {
		int m1Col = m1[0].length;
		int m3Row = m1.length;
		int m3Col = m2[0].length;
		int[][] result = new int[m3Row][m3Col];
		for (int i = 0; i < m3Row; i++) {
			for (int j = 0; j < m3Col; j++) {
				for (int k = 0; k < m1Col; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return result;
	}

	/**
	 * Program to multiply matrices: 1. Ask for paths for 3 files (2 input, 1
	 * output) 2. Check if inputs can be multiplied 3. If so, multiply! - Output the
	 * full problem to the console - Output only the result matrix to the file
	 * 
	 * @param args command-line arguments, ignored
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		// Hint: paths should be read as an entire line!
		Scanner input = new Scanner(System.in);
		System.out.print("Enter path for matrix 1: ");
		String matrix_1 = input.nextLine();
		System.out.print("Enter path for matrix 2: ");
		String matrix_2 = input.nextLine();
		System.out.print("Enter path for result: ");
		String matrix_result = input.nextLine();
		try (Scanner m1 = new Scanner(new File(matrix_1));
				Scanner m2 = new Scanner(new File(matrix_2));
				PrintWriter pw = new PrintWriter(new File(matrix_result));) {
			int[][] FirstMatrix = readMatrix(m1);
			int[][] SecondMatrix = readMatrix(m2);
			printMatrix(FirstMatrix);
			System.out.println("X");
			printMatrix(SecondMatrix);
			System.out.println("=");
			if (canMultiply(FirstMatrix, SecondMatrix)) {
				int[][] ResultMatrix = matrixMultiply(FirstMatrix, SecondMatrix);
				printMatrix(ResultMatrix);
				printMatrix(ResultMatrix, pw);
			} else {
				System.out.println(ERR_DIMS);
			}

		} catch (IOException ex) {
			System.out.println(ERR_FILE);
			System.exit(0);
		}
		input.close();
	}

}
