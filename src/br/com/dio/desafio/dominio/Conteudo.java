package br.com.dio.desafio.dominio;


/**
 * Classe abstrata representando um conteúdo do bootcamp.
 */
public abstract class Conteudo {

    protected static final double XP_PADRAO = 10.0;

    private String titulo;
    private String descricao;
    private Double xp = XP_PADRAO;
	protected int cargaHoraria;
    
    public Conteudo() {
    }
    
    public Conteudo(String titulo, String descricao) {
    	this.titulo = titulo;
    	this.descricao = descricao;
    }

    public Conteudo(String titulo, String descricao, Double xp) {
    	this(titulo, descricao);
    	this.xp = xp;
    }
    
    public abstract double calcularXp();
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	public Double getXp() {
		return xp;
	}

	public void setXp(Double xp) {
		this.xp = xp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
			.append("Conteudo [titulo=").append(titulo)
			.append(", descricao=").append(descricao)
			.append(", xp=").append(xp)
			.append("]");
		return builder.toString();
	}

	public int getCargaHoraria() {
	    return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria, Curso curso) {
	    this.cargaHoraria = cargaHoraria;
	}
    
    
}
