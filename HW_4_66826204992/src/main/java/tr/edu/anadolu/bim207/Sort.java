package tr.edu.anadolu.bim207;

import com.lexicalscope.jewel.cli.ArgumentValidationException;
import com.lexicalscope.jewel.cli.CliFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Sort{
	public static void main(String[] args){
		try{InputParser inputs=CliFactory.parseArguments(InputParser.class, args);
		List<String> lines;

		try{
			lines=Files.readAllLines(Paths.get(inputs.getFile()));
		}catch(MalformedInputException e){
			lines=Files.readAllLines(Paths.get(inputs.getFile()),StandardCharsets.ISO_8859_1);
		}

		Comparator comparator=(Collator.getInstance(Locale.forLanguageTag(inputs.getLocale())));
		((Collator) comparator).setStrength(Collator.TERTIARY);
		Collections.sort(lines);

		if(inputs.getReversed()) comparator=comparator.reversed();
		if(inputs.getIgnoreCase()) Collections.sort(lines, comparator);

		Files.write(Paths.get(inputs.getOutputFile()), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		}catch(FileNotFoundException e){
			System.out.println(args[0]+" file not found!");
		}catch(IOException e){
			System.out.println("There were some IO exception");
			e.printStackTrace();
		}catch(ArgumentValidationException e){
			System.out.println("missing arguments");
		}
	}
}
