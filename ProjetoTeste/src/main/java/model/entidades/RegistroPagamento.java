package model.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegistroPagamento {
	private float valorPago;
	private Funcionario funcionario;
	private LocalDateTime data;
	private String placaVeiculo;
	private boolean isNoEstacionamento; //TODO - atualizar UML
	private long id;
	
	public RegistroPagamento() {
		System.out.println("OPA CHEGUEI AQUI");
		this.id = System.currentTimeMillis();
		System.out.println(System.currentTimeMillis());
		System.out.println(getId());
	}

	public float getValorPago() {
		return valorPago;
	}

	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isNoEstacionamento() {
		return isNoEstacionamento;
	}

	public void setIsNoEstacionamento(boolean isNoEstacionamento) {
		this.isNoEstacionamento = isNoEstacionamento;
	}

	public RegistroPagamento(float valorPago, Funcionario funcionario, LocalDateTime data, String placaVeiculo) {
		this.valorPago = valorPago;
		this.funcionario = funcionario;
		this.data = data;
		this.placaVeiculo = placaVeiculo;
		this.id = System.currentTimeMillis();
	}
}
