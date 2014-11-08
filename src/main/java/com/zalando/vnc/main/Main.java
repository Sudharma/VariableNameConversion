package com.zalando.vnc.main;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.zalando.vnc.conversion.strategy.ConstantToLocalFieldStrategy;
import com.zalando.vnc.visitor.VoidVisitor.FieldNameChanger;

/**
 * Main Methods for running the class
 * 
 * @author spuranik
 *
 */
public class Main {

	public static void main(String[] args) {

		try {
			
			CompilationUnit cu = readInputs(args);

			System.out.println("############# INPUT IS #####################");
			System.out.println(cu.toString());
			/** create a strategy for which you want to have conversion */
			ConstantToLocalFieldStrategy constantToLocalFieldStrategy = new ConstantToLocalFieldStrategy();
			/** visit and change the FieldName */
			FieldNameChanger fmc = new FieldNameChanger(
					constantToLocalFieldStrategy);

			String variableName = args[1];
			fmc.visit(cu, variableName);

			System.out.println("############# OUTPUT IS #####################");
			// prints the changed compilation unit
			System.out.println(cu.toString());

		} catch (FileNotFoundException | ParseException e) {
			System.err
					.println("Unable to read the JavaFile, Possible Reasons :: "
							+ e.getMessage());

		}

	}

	private static CompilationUnit readInputs(String[] args)
			throws FileNotFoundException, ParseException {

		if (args.length == 0 || args.length != 2) {
			System.err
					.println("Please input fileName and variable for conversion");
			System.out.println("press --help or -h for details");
			System.exit(0);
		}
		if ("-h".equals(args[0]) || "--help".equals(args[0])) {
			System.out
					.println("argument should be as :  <fileName> <variableName>");
			System.exit(0);
		}

		System.out
				.println("----Check the Console for the updated Java file with changes------");
		String fileName = args[0];
		FileInputStream in = null;
		CompilationUnit cu = null;
		try {
			// creates an input stream for the file to be parsed
			in = new FileInputStream(fileName);

			// parse the file
			cu = JavaParser.parse(in);
		} finally {

			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

		return cu;

	}

}
