package com.zalando.vnc.visitor.VoidVisitor;

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.FieldDeclaration;

import com.zalando.vnc.conversion.strategy.AbstractStrategy;

@SuppressWarnings("rawtypes")
/**
 * This is a delegator of the FieldConversionStrategy
 * @author spuranik
 *
 */
public class FieldNameChanger {

	AbstractStrategy fcs;

	public FieldNameChanger(AbstractStrategy fcs) {
		this.fcs = fcs;
	}

	@SuppressWarnings("unchecked")
	public void visit(FieldDeclaration fd, Object arg1) {
		// System.out.println(fd.getVariables());
		fcs.visit(fd, arg1);
	}

	public void visit(CompilationUnit cu, Object arg1) {
		// System.out.println(fd.getVariables());
		fcs.visit(cu, arg1);
	}

}
