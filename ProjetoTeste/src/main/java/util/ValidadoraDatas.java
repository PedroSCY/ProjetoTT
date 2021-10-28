package util;

import java.time.Duration;
import java.time.LocalDate;

import java.time.LocalDateTime;

/**
 * @author NPG
 *
 * Essa classe foi criada com o intuito de centralizar os m�todos capazes de manipular datas,
 * mas especificamente, retornar valores booleanos a apartir de entradas de datas (LocalDate).
 */
public class ValidadoraDatas {

	/*
	 * O m�todo a abaixo recebe um data e verifica se a data de hoje �
	 * igual ou � anterior, ou seja, menor, que a data recebida no
	 * par�metro de entrada. Caso seja retorna verdadeiro, caso n�o 
	 * seja retorna falso.
	 */
	public static boolean validarDataHojeMenorQueDataRecebida(LocalDate data) {
		
		LocalDate dataAgora = LocalDate.now();
		
		if(!dataAgora.isAfter(data) ) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/*
	 * O m�todo a baixo verifica se a data atual est� entre o pe�rodo da data
	 * de in�cio e o per�odo da data de t�rmino passadas como par�metro de entrada.
	 * Caso esteja retorna verdadeiro, caso n�o, retorna falso.
	 */
	public static boolean validarExistenciaDeDataEntreDuasDatas(LocalDate data1, LocalDate data2) {
		
		LocalDate dataAgora = LocalDate.now();
		
		if((dataAgora.equals(data2) || dataAgora.isAfter(data1)) && (dataAgora.equals(data2) || dataAgora.isBefore(data2))) {
			
			return true;
		}
		return false;
	}
	
	/*
	 * O metodo a abixo verifica se as datas passadas por parametro sao iguais
	 */
	public static boolean data1IguaData2(LocalDateTime dataHora1, LocalDateTime dataHora2) {
		
		LocalDate data1 = LocalDate.of(dataHora1.getYear(), dataHora1.getMonthValue(), dataHora1.getDayOfMonth());
		LocalDate data2 = LocalDate.of(dataHora2.getYear(), dataHora2.getMonthValue(), dataHora2.getDayOfMonth());
		
		
		return data1.equals(data2);
	}
	
	public static LocalDate criarData(String dataString) throws Exception{
		
		if(dataString == null) {
			
			throw new Exception("Data incorreta");
		}
		
		String[] data = dataString.split("/");
		
		if(data[0] != null && data[1] != null && data[2] != null) {
			
			try {
				
				int dia = Integer.parseInt(data[0]);
				int mes = Integer.parseInt(data[1]);
				int ano = Integer.parseInt(data[2]);
				
				return LocalDate.of(ano, mes, dia);
				
			}catch (Exception e) {
				throw new Exception("Essa data não existe");
			}
			
		}else {
			throw new Exception("Data incompleta");
		}
		
		
	}
	
	public static LocalDateTime criarDataTime(String dataString) throws Exception{
		
		if(dataString == null) {
			
			throw new Exception("Data incorreta");
		}
		
		String[] data = dataString.split("/");
		
		if(data[0] != null && data[1] != null && data[2] != null) {
			
			try {
				
				int dia = Integer.parseInt(data[0]);
				int mes = Integer.parseInt(data[1]);
				int ano = Integer.parseInt(data[2]);
				
				return LocalDateTime.of(ano, mes, dia, 0, 0);
				
			}catch (Exception e) {
				throw new Exception("Essa data não existe");
			}
			
		}else {
			throw new Exception("Data incompleta");
		}
		
		
	}
	
	/*
	 *Esse metodo verifica se uma data esta vazia, ou seja, nula 
	 */
	public static boolean dataIsVazia(LocalDateTime dataHora) {
		
		return dataHora == null;
	}
	
	public static String transformarDataEmString(LocalDate data) {
		
		
		String dataString[] = String.valueOf(data).split("-");
	
		return dataString[2]+"/"+dataString[1]+"/"+dataString[0];
		
	}
	
	public static float calcularQuantidadeDeHoraEntreDatas(LocalDateTime data1, LocalDateTime data2) throws Exception{
		
		Duration duracao = Duration.between(data1, data2);
		return duracao.toHours();
		
	}
}
