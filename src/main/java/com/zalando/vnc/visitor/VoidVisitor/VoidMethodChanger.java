package com.zalando.vnc.visitor.VoidVisitor;

import japa.parser.ASTHelper;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;

import com.zalando.vnc.conversion.strategy.MethodConversionStrategy;

public class VoidMethodChanger extends MethodConversionStrategy {

	@Override
	public void visit(MethodDeclaration n, Object arg) {
		// change the name of the method to upper case
		n.setName(n.getName().toUpperCase());

		// create the new parameter
		Parameter newArg = ASTHelper.createParameter(ASTHelper.INT_TYPE,
				"value");

		// add the parameter to the method
		ASTHelper.addParameter(n, newArg);
	}

}
