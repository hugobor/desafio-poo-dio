package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    @Override
    public double calcularXp() {
        return getXp() * cargaHoraria;
    }

    public Curso() {
    	super();
    }
    
	public Curso(String titulo, String descricao, Double xp, int cargaHoraria) {
		super(titulo, descricao, xp);
		this.cargaHoraria = cargaHoraria;
	}
	
	public Curso(String titulo, String descricao, int cargaHoraria) {
		super(titulo, descricao);
		this.cargaHoraria = cargaHoraria;
	}
    
	@Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
