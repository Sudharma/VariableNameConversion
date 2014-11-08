package com.zalando.vnc.visitor.VoidVisitor;

import japa.parser.ast.body.FieldDeclaration;

import com.zalando.vnc.conversion.strategy.FieldConversionStrategy;

@SuppressWarnings("rawtypes")
/**
 * This is a delegator of the FieldConversionStrategy
 * @author spuranik
 *
 */
public class FieldNameChanger extends FieldConversionStrategy {

	FieldConversionStrategy fcs;

	public FieldNameChanger(FieldConversionStrategy fcs) {
		this.fcs = fcs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void visit(FieldDeclaration fd, Object arg1) {
//		System.out.println(fd.getVariables());
		fcs.visit(fd, arg1);
	}

}
