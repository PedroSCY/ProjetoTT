package util;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



public class TestValidadoraFormatoEmail {

	@Test
	public void testValidarEmailComEmailValido() {
		String teste = "admin@admin.com";
		
		assertTrue(ValidadoraFormatoEmail.validarEmail(teste));
	}
	
	@Test
	public void testVelidarEmailVazioInvalido() {
		String teste = "";
		
		assertFalse(ValidadoraFormatoEmail.validarEmail(teste));
	}
	
	@Test
	public void testValidarEmailComEmailInvalido() {
		String teste = "@mail.com@meu";
		
		assertFalse(ValidadoraFormatoEmail.validarEmail(teste));
	}
}
