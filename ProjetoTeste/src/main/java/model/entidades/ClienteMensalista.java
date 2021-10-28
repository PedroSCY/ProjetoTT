package model.entidades;

public class ClienteMensalista extends Pessoa {
	private float creditoDisponivel;

	public ClienteMensalista(String nome, String email, String senha, long cpf, float creditoDisponivel) {
		super(nome, email, senha, cpf);
		this.creditoDisponivel = creditoDisponivel;
	}

	public float getCreditoDisponivel() {
		return creditoDisponivel;
	}

	public void setCreditoDisponivel(float creditoDisponivel) {
		this.creditoDisponivel = creditoDisponivel;
	}
}
