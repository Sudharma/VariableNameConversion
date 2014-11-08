package com.zalando.vnc.conversion.strategy;

import japa.parser.ast.body.MethodDeclaration;

/**
 * Implement here the MethodConversions in a generic way as done similar with
 * {@link FieldConversionStrategy}
 * 
 * @author spuranik
 *
 */
public abstract class MethodConversionStrategy extends AbstractStrategy {

	/**
	 * 
	 */
	public void visit(MethodDeclaration md, Object arg) {
		// Implement here logic of MethodDeclerations
	}

}
