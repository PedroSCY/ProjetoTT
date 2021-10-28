package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author NPG
 * Classe utilitaria usada para validar formatos de emails
 * usando regex.
 */
// TODO [UML] update class name
public class ValidadoraFormatoEmail {
	
	
	public static boolean validarEmail(String login) {
		String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(login);	
		return matcher.find() && matcher.group().equals(login);
	}
	
}
