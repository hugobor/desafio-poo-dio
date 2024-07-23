package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
	
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    
    public Bootcamp() {
    }
    
    public Bootcamp(String nome, String descricao) {
    	super();
    	this.nome = nome;
    	this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return Set.copyOf(devsInscritos);
    }
    
    /**
     * Adiciona novo desenvolvedor.
     */
    public boolean addDev(Dev dev) {
    	return devsInscritos.add(dev);    	
    }
    
    /**
     * Remove desenvolvedor.
     */
    public boolean removeDev(Dev dev) {
    	return devsInscritos.remove(dev);
    }

    public Set<Conteudo> getConteudos() {
        return Set.copyOf(conteudos);
    }
    
    public boolean addConteudo(Conteudo conteudo) {
    	return conteudos.add(conteudo);
    }
    
    
    /**
     * Carga horária total do bootcamp em horas.
     */
    public int getCargaHorariaTotal() {
    	return conteudos.stream().mapToInt(Conteudo::getCargaHoraria).sum();
    }
    
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao) && Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dataFinal, bootcamp.dataFinal) && Objects.equals(devsInscritos, bootcamp.devsInscritos) && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
			.append("Bootcamp [nome=").append(nome)
			.append(", descricao=").append(descricao)
			.append(", dataInicial=").append(dataInicial)
			.append(", dataFinal=").append(dataFinal)
			.append(", desenvolvedores=").append(devsInscritos.size())
			.append(", conteudos=").append(conteudos.size())
			.append("]");
		return builder.toString();
	}
    
    
}
