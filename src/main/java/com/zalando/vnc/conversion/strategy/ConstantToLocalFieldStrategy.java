package com.zalando.vnc.conversion.strategy;

import japa.parser.ast.body.FieldDeclaration;

import com.google.common.base.CaseFormat;

/**
 * Strategy to convert from ConstantToLocalFieldStrategy
 * <p>
 * 
 * delegates visting to {@link FieldConversionStrategy}
 * 
 * @author spuranik
 *
 */
public class ConstantToLocalFieldStrategy extends FieldConversionStrategy {

	@Override
	public CaseFormat getInputCaseFormat() {
		return CaseFormat.UPPER_UNDERSCORE;
	}

	@Override
	public CaseFormat getOutputCaseFormat() {
		return CaseFormat.LOWER_CAMEL;
	}

	@Override
	public void visit(FieldDeclaration fd, Object arg) {
		super.visit(fd, arg);
	}
}