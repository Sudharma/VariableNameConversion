package com.zalando.vnc.conversion.strategy;

import japa.parser.ast.body.FieldDeclaration;

import com.google.common.base.CaseFormat;

/**
 * Stragety for visting FieldConversions, All subclass delegate the task to this
 * class
 * 
 * @author spuranik
 *
 */
public abstract class FieldConversionStrategy extends AbstractStrategy {

	public abstract CaseFormat getInputCaseFormat();

	public abstract CaseFormat getOutputCaseFormat();

	@Override
	public void visit(FieldDeclaration fd, Object arg) {

		String variable = fd.getVariables().get(0).getId().getName();
		if (variable.equals(String.valueOf(arg))) {
			String newVariable = getInputCaseFormat().converterTo(
					getOutputCaseFormat()).convert(variable);
			fd.getVariables().get(0).getId().setName(newVariable);
		}

	}

}
