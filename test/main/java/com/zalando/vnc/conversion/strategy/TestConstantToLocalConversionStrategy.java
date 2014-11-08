package com.zalando.vnc.conversion.strategy;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.zalando.vnc.visitor.VoidVisitor.FieldNameChanger;

/**
 * TestCaseAssumes that the variablename is always correct else it does not make
 * any sense
 * 
 * @author spuranik
 *
 */
public class TestConstantToLocalConversionStrategy {

	@Test
	public void testVisit() throws ParseException, IOException {
		String variableName = "SOME_VARIABLE";
		/** create a strategy for which you want to have conversion */
		FieldConversionStrategy constantToLocalFieldStrategy = new ConstantToLocalFieldStrategy();
		/** visit and change the FieldName */
		FieldNameChanger fmc = new FieldNameChanger(
				constantToLocalFieldStrategy);

		CompilationUnit cu = JavaParser.parse(new File(
				"src/main/resources/TestCase1.java"));
		fmc.visit(cu, variableName);
	}

}
