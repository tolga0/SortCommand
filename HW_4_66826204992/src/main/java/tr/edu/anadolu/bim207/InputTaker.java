package tr.edu.anadolu.bim207;

import com.lexicalscope.jewel.cli.Option;
import com.lexicalscope.jewel.cli.Unparsed;

public interface InputTaker{
	@Option(shortName="l",longName = "locale",defaultValue = "en-US")
	String getLocale();

	@Option(shortName = "r",longName = "reverse")
	boolean getReversed();

	@Option(shortName = "i",longName = "ignore-case")
	boolean getIgnoredCase();

	@Option(shortName = "o",longName = "output",defaultValue = "sorted.txt")
	String getOutputFile();

	@Unparsed
	String getFile();
}
