/*
 * generated by Xtext 2.34.0
 */
package at.jku.isse.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class OCLXAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("at/jku/isse/parser/antlr/internal/InternalOCLX.tokens");
	}
}
