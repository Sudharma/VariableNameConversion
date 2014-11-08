package com.vnc.constant;

import com.google.common.base.CaseFormat;
import com.zalando.vnc.conversion.strategy.AbstractStrategy;
import com.zalando.vnc.conversion.strategy.ConstantToLocalFieldStrategy;
import com.zalando.vnc.conversion.strategy.LocalFieldToConstantStrategy;

public enum StrategyTypes {

	LOCAL_TO_CONSTANT(CaseFormat.UPPER_UNDERSCORE), CONSTANT_TO_LOCAL(
			CaseFormat.LOWER_CAMEL);

	CaseFormat cf = CaseFormat.LOWER_CAMEL;

	StrategyTypes(CaseFormat cf) {
		this.cf = cf;
	}

	public AbstractStrategy getStrategy(StrategyTypes st) {
		switch (st) {
		case LOCAL_TO_CONSTANT:
			return new LocalFieldToConstantStrategy();

		case CONSTANT_TO_LOCAL:
			return new ConstantToLocalFieldStrategy();
		default:
			return null;
		}

	}

}
