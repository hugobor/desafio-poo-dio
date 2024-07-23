package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
	
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    
    public Dev() {
    }
    
    public Dev(String nome) {
    	super();
    	this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.addDev(this);
    }

    public boolean progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
            return true;
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
            return false;
        }
    }
    
    /**
     * Progredir em um conteúdo específico.
     */
    public boolean progredir(Conteudo conteudo) {
    	if (conteudosInscritos.contains(conteudo)) {
    		conteudosConcluidos.add(conteudo);
    		conteudosInscritos.remove(conteudo);
    		return true;
    	} else {
            System.err.println("Você não está matriculado no conteúdo " + conteudo.toString() + "!");
            return false;
    	}
    }
    
    /**
     * Se o aluno concluíu o Bootcamp e está apto para receber o certificado.
     */
    public boolean concluiuBootcamp(Bootcamp bootcamp) {
    	return conteudosConcluidos.containsAll(bootcamp.getConteudos());
    }
    
    /**
     * “Imprime” o certificado do Bootcamp se o aluno estiver apto (ele concluíu todos os conteúdos. 
     */
    public void imprimeCertificadoBootcamp(Bootcamp bootcamp) {
    	if (bootcamp.getConteudos().isEmpty()) {
    		System.out.println("Bootcamp vazio!");
    	} else if (concluiuBootcamp(bootcamp)) {
    		System.out.format(
    				"O aluno “%s” concluíu o Bootcamp “%s” de %d horas.%n",
    				getNome(), bootcamp.getNome(), bootcamp.getCargaHorariaTotal());
    	} else {
    		System.out.println("Você ainda não está apto para receber o seu certificado!");
    	}
    }
    
    /**
     * Carga horária que um desenvolvedor já concluíu em um bootcamp.
     */
    public int cargaHorariaParcial(Bootcamp bootcamp) {
    	return bootcamp.getConteudos().stream()
    		.filter(conteudoBootcamp -> conteudosConcluidos.contains(conteudoBootcamp))
    		.mapToInt(Conteudo::getCargaHoraria).sum();
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dev [nome=").append(nome)
			.append(", inscrições=").append(conteudosInscritos.size())
			.append(", conclusões=").append(conteudosConcluidos.size())
			.append("]");
		
		return builder.toString();
	}

}
