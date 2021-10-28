package model.entidades;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

public class Funcionario extends Pessoa {
	private long matricula;
	private boolean isGerente;
	private Set<RegistroPagamento> registrosRealizados;
	
	public Funcionario(String nome, String email, String senha, long cpf, long matricula, boolean isGerente) {
		super(nome, email, senha, cpf);
		this.matricula = matricula;
		this.isGerente = isGerente;
		this.registrosRealizados = new LinkedHashSet<RegistroPagamento>();
	}
	
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	
	public boolean isGerente() {
		return isGerente;
	}
	public void setGerente(boolean isGerente) {
		this.isGerente = isGerente;
	}
	
	public Set<RegistroPagamento> getRegistrosRealizados() {
		return registrosRealizados;
	}
	public void setRegistrosRealizados(Set<RegistroPagamento> registrosRealizados) {
		this.registrosRealizados = registrosRealizados;
	}
	
	public void addRegistroPagamento(RegistroPagamento registro) {
		this.registrosRealizados.add(registro);
	}
	
	//TODO - autualizar UML
	public RegistroPagamento registrarPagamento(float valorPago, String placaVeiculo, Funcionario funcionario) {
		
		RegistroPagamento registroPagamento = new RegistroPagamento(valorPago, funcionario, LocalDateTime.now(), placaVeiculo);
		registroPagamento.setIsNoEstacionamento(true);
		
		registrosRealizados.add(registroPagamento);
		
		return registroPagamento;
	}
	
}
