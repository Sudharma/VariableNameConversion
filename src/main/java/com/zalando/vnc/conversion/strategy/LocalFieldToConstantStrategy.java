package com.zalando.vnc.conversion.strategy;

import japa.parser.ast.body.FieldDeclaration;

import com.google.common.base.CaseFormat;

/**
 * Strategy to convert from LocalField to Constant Strategy
 * <p>
 * 
 * delegates visting to {@link FieldConversionStrategy}
 * 
 * @author spuranik
 */
public class LocalFieldToConstantStrategy extends FieldConversionStrategy {

	public CaseFormat getInputCaseFormat() {
		return CaseFormat.LOWER_CAMEL;
	};

	@Override
	public CaseFormat getOutputCaseFormat() {
		return CaseFormat.UPPER_UNDERSCORE;
	}

	@Override
	public void visit(FieldDeclaration fd, Object arg) {
		super.visit(fd, arg);
	}

}
