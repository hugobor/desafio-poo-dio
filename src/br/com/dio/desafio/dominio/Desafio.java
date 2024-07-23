package br.com.dio.desafio.dominio;

public class Desafio extends Conteudo {
	
	public Desafio(String titulo, String descr, int cargaHoraria, Double xpHora) {
		super(titulo, descr, xpHora);
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public double calcularXp() {
		return cargaHoraria * getXp();
	}

}
