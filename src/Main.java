import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Desafio;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8, curso1);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4, curso2);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.addConteudo(curso1);
        bootcamp.addConteudo(curso2);
        bootcamp.addConteudo(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());

        System.out.println("-------");
        Dev devHugo = new Dev("Hugo");
        Bootcamp santanderBootcamp = new Bootcamp("Bootcamp Santander Coders Backend", "Bootcamp de desenvolvimento com o Java, Spring Framework, patrocinado pelo Banco Santander!!!!");
        System.out.println(devHugo);
        System.out.println(santanderBootcamp);
        System.out.format("Carga horária total: %d h.%n", santanderBootcamp.getCargaHorariaTotal());
        
        Conteudo cursoIntroSpring = new Curso("Introdução ao Spring", "", 12);
        Conteudo cursoPostgres = new Curso("Postgres Avançado", "", 10);
        Conteudo cursoNoSql = new Curso("MongoDB para Devs", "", 5);
        
        Conteudo mentoMento = new Mentoria("Mentoria de Mentorias", "", "Hugo", 2);
        
        Conteudo desafioPoo = new Desafio("Desafio POO", "", 2, 100.0);
        Conteudo desafioBanco = new Desafio("Desafio Banco Digital", "", 4, 200.0);
        
        santanderBootcamp.addConteudo(cursoIntroSpring);
        santanderBootcamp.addConteudo(cursoPostgres);
        santanderBootcamp.addConteudo(cursoNoSql);
        santanderBootcamp.addConteudo(mentoMento);
        santanderBootcamp.addConteudo(desafioPoo);
        santanderBootcamp.addConteudo(desafioBanco);
        
        System.out.println(santanderBootcamp);
        System.out.format("Carga horária total: %d h.%n", santanderBootcamp.getCargaHorariaTotal());
        
        devHugo.inscreverBootcamp(santanderBootcamp);
        
        devHugo.imprimeCertificadoBootcamp(santanderBootcamp);
        System.out.format("Carga horária cumprida: %d h.%n", devHugo.cargaHorariaParcial(santanderBootcamp));
        
        devHugo.progredir(cursoNoSql);
        devHugo.progredir(mentoMento);
        devHugo.imprimeCertificadoBootcamp(santanderBootcamp);
        System.out.format("Carga horária cumprida: %d h.%n", devHugo.cargaHorariaParcial(santanderBootcamp));
        devHugo.progredir();
        devHugo.progredir();
        devHugo.progredir();
        devHugo.progredir();
        
        devHugo.imprimeCertificadoBootcamp(santanderBootcamp);
        System.out.format("Carga horária cumprida: %d h.%n", devHugo.cargaHorariaParcial(santanderBootcamp));
        
        
    }

}
