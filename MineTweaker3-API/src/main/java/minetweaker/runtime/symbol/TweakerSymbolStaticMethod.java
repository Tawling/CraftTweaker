/*
 * This file is part of MineTweaker API, licensed under the MIT License (MIT).
 * 
 * Copyright (c) 2014 MineTweaker <http://minetweaker3.powerofbytes.com>
 */
package minetweaker.runtime.symbol;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.openzen.zencode.symbolic.scope.IScopeGlobal;
import org.openzen.zencode.symbolic.symbols.IZenSymbol;
import org.openzen.zencode.runtime.IAny;
import org.openzen.zencode.symbolic.method.JavaMethod;
import org.openzen.zencode.symbolic.symbols.SymbolStaticMethod;

/**
 *
 * @author Stan
 */
public class TweakerSymbolStaticMethod implements ITweakerSymbol {
	private final Method method;
	
	public TweakerSymbolStaticMethod(Method method) {
		if ((method.getModifiers() & Modifier.STATIC) == 0)
			throw new IllegalArgumentException("Method must be static");
		
		this.method = method;
	}

	@Override
	public IZenSymbol convert(IScopeGlobal scope) {
		return new SymbolStaticMethod(JavaMethod.get(scope.getTypes(), method));
	}

	@Override
	public IAny eval() {
		return null;
	}
}
