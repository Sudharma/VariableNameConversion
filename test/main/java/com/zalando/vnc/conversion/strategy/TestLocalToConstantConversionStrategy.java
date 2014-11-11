package com.zalando.vnc.conversion.strategy;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.zalando.vnc.visitor.VoidVisitor.FieldNameChanger;

/**
 * TestCaseAssumes that the variablename is always correct else it does not make
 * any sense
 * 
 * @author spuranik
 *
 */
public class TestLocalToConstantConversionStrategy {

	@Test
	public void testVisit() throws ParseException, IOException {
		String variableName = "someVariable";
		/** create a strategy for which you want to have conversion */
		FieldConversionStrategy constantToLocalFieldStrategy = new LocalFieldToConstantStrategy();
		/** visit and change the FieldName */
		FieldNameChanger fmc = new FieldNameChanger(
				constantToLocalFieldStrategy);

		CompilationUnit output = JavaParser.parse(new File(
				"src/main/resources/TestCase2.java"));
		CompilationUnit input = JavaParser.parse(new File(
				"src/main/resources/TestCase2.java"));
		fmc.visit(output, variableName);
		/**
		 * Checking equals because variable comparison via JavaParser is not
		 * exposed
		 */
		/** I know its not really helpful but it checks the class modification */
		Assert.assertNotEquals(output, input);

	}

	@Test
	public void testVisitNegative() throws ParseException, IOException {
		String variableName = "someVariable1";// some wrong variable name
		/** create a strategy for which you want to have conversion */
		FieldConversionStrategy constantToLocalFieldStrategy = new LocalFieldToConstantStrategy();
		/** visit and change the FieldName */
		FieldNameChanger fmc = new FieldNameChanger(
				constantToLocalFieldStrategy);

		CompilationUnit output = JavaParser.parse(new File(
				"src/main/resources/TestCase2.java"));
		CompilationUnit input = JavaParser.parse(new File(
				"src/main/resources/TestCase2.java"));
		fmc.visit(output, variableName);
		Assert.assertEquals(output, input);

	}

}