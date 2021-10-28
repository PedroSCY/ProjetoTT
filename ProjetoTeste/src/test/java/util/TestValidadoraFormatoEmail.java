package util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestValidadoraFormatoEmail {

	@Test
	public void testValidarEmailComEmailValido() {
		String teste = "admin@admin.com";
		
		assertTrue(ValidadoraFormatoEmail.validarEmail(teste));
	}
	
	@Test
	public void testValidarEmailComEmailInvalido() {
		String teste = "@mail.com@meu";
		
		assertFalse(ValidadoraFormatoEmail.validarEmail(teste));
	}
}
