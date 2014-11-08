package com.zalando.vnc.main;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.vnc.constant.StrategyTypes;
import com.zalando.vnc.conversion.strategy.AbstractStrategy;
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
			// FieldConversionStrategy constantToLocalFieldStrategy = new
			// LocalFieldToConstantStrategy();
			StrategyTypes inputStrategy = StrategyTypes.valueOf(args[1]);
			AbstractStrategy fcs = inputStrategy.getStrategy(inputStrategy);
			/** visit and change the FieldName */
			FieldNameChanger fmc = new FieldNameChanger(fcs);

			String variableName = args[2];

			fmc.visit(cu, variableName);

			System.out.println("############# OUTPUT IS #####################");
			// prints the changed compilation unit
			System.out.println(cu.toString());

		} catch (FileNotFoundException | ParseException e) {
			System.err
					.println("Unable to read the JavaFile, Possible Reasons :: "
							+ e.getMessage());
		} catch (IllegalArgumentException iae) {
			System.err
					.println("Illegal strategy Given :: "
							+ iae.getMessage());
		}

	}

	private static CompilationUnit readInputs(String[] args)
			throws FileNotFoundException, ParseException {

		if (args.length == 0 || args.length != 3) {
			System.err
					.println("Please input fileName and variable for conversion");
			System.out.println("press --help or -h for details");
			System.exit(0);
		}
		if ("-h".equals(args[0]) || "--help".equals(args[0])) {
			System.out
					.println("argument should be as :  <fileName> <StrategyType> <variableName>");
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
