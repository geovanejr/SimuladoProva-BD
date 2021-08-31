package br.com.geovanejunior.SimuladoProva.config;

import br.com.geovanejunior.SimuladoProva.entity.*;
import br.com.geovanejunior.SimuladoProva.entity.enums.Pais;
import br.com.geovanejunior.SimuladoProva.entity.enums.TipoTelefone;
import br.com.geovanejunior.SimuladoProva.repository.FuncionarioRepository;
import br.com.geovanejunior.SimuladoProva.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Configuration
@EnableJpaRepositories("br.com.geovanejunior.SimuladoProva.repository")
@ComponentScan("br.com.geovanejunior.SimuladoProva.service")
@EnableTransactionManagement
public class TestConfig {

    private static final Logger log = LoggerFactory.getLogger(TestConfig.class);

    private int obtemNumAleatorio(Integer num) {

        Random random = new Random();
        int numAleatorio = 0;

        if (num == 87654) {

            numAleatorio = random.nextInt(num) + 38000001;
        } else {

            numAleatorio = random.nextInt(num) + 999000001;
        }

        return numAleatorio;
    }

    private int obtemDependenteAleatorio(Integer num) {

        Random random = new Random();

        int numAleatorio = random.nextInt(num);
        return numAleatorio;
    }

    // Método responsável pela configuração do BD utilizado, usuário, senha e pool de conexão
//    @Bean
//    public DataSource dataSource() {
//
//        DataSourceBuilder ds = DataSourceBuilder.create();
//
//        ds.driverClassName("com.mysql.jdbc.Driver");
//        ds.url("jdbc:mysql://localhost:3306/atividade05");
//        ds.username("root");
//        ds.password("");
//
//        return ds.build();
//
//    }
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//
//        LocalContainerEntityManagerFactoryBean factory =
//                new LocalContainerEntityManagerFactoryBean();
//
//        HibernateJpaVendorAdapter vendorAdapter =
//                new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        vendorAdapter.setShowSql(true);
//
//        factory.setDataSource(dataSource());
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("br.com.geovanejunior");
//        factory.afterPropertiesSet();
//
//        return factory.getObject();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//
//        JpaTransactionManager manager = new JpaTransactionManager();
//        manager.setEntityManagerFactory(entityManagerFactory());
//        manager.setJpaDialect(new HibernateJpaDialect());
//
//        return manager;
//    }

    @Bean
    public CommandLineRunner cargaPessoa(PessoaService pessoaService) {

        return args -> {

            pessoaService.save(new Pessoa("Anna"));
            pessoaService.save(new Pessoa("Barbosa"));
            pessoaService.save(new Pessoa("Carlos"));
            pessoaService.save(new Pessoa("Daniela"));
            pessoaService.save(new Pessoa("Danilo"));
            pessoaService.save(new Pessoa("Edileuza"));
            pessoaService.save(new Pessoa("Flavia"));
            pessoaService.save(new Pessoa("Fatima"));
            pessoaService.save(new Pessoa("Geovane"));
            pessoaService.save(new Pessoa("Glaucia"));
        };
    }

    @Bean
    public CommandLineRunner cargaTelefone(PessoaService pesServ, TelefoneService telServ) {

        return args -> {

            List<Pessoa> lstPessoa = pesServ.findAll();

            for (Pessoa lst : lstPessoa) {
                log.info("Say hello!");
                Pessoa pes = pesServ.findById(lst.getCodPessoa());

                if (pes != null) {
                    String ddd = String.valueOf(pes.getCodPessoa());
                    if (pes.getCodPessoa() % 5 == 0) {

                        Telefone tel1 = new Telefone(null, ddd + "1" + String.valueOf(obtemNumAleatorio(987654)), TipoTelefone.CELULAR, lst);
                        Telefone tel2 = new Telefone(null, ddd + "1" + String.valueOf(obtemNumAleatorio(87654)), TipoTelefone.RESIDENCIAL, lst);
                        pes.getTelefones().addAll(Arrays.asList(tel1, tel2));
                        pesServ.save(pes);
                        telServ.save(tel1);
                        telServ.save(tel2);
                    } else if (pes.getCodPessoa() % 3 == 0) {

                        Telefone tel1 = new Telefone(null, ddd + "1" + String.valueOf(obtemNumAleatorio(987654)), TipoTelefone.CELULAR, lst);
                        Telefone tel2 = new Telefone(null, ddd + "1" + String.valueOf(obtemNumAleatorio(87654)), TipoTelefone.COMERCIAL, lst);
                        Telefone tel3 = new Telefone(null, ddd + "1" + String.valueOf(obtemNumAleatorio(87654)), TipoTelefone.RESIDENCIAL, lst);
                        pes.getTelefones().addAll(Arrays.asList(tel1, tel2, tel3));
                        pesServ.save(pes);
                        telServ.save(tel1);
                        telServ.save(tel2);
                        telServ.save(tel3);
                    } else if (pes.getCodPessoa() % 2 == 0) {

                        Telefone tel1 = new Telefone(null, ddd + "1" + String.valueOf(obtemNumAleatorio(987654)), TipoTelefone.CELULAR, lst);
                        Telefone tel2 = new Telefone(null, ddd + "1" + String.valueOf(obtemNumAleatorio(87654)), TipoTelefone.COMERCIAL, lst);
                        Telefone tel3 = new Telefone(null, ddd + "1" + String.valueOf(obtemNumAleatorio(87654)), TipoTelefone.RESIDENCIAL, lst);
                        Telefone tel4 = new Telefone(null, ddd + "1" + String.valueOf(obtemNumAleatorio(87654)), TipoTelefone.OUTRO, lst);
                        pes.getTelefones().addAll(Arrays.asList(tel1, tel2, tel3, tel4));
                        pesServ.save(pes);
                        telServ.save(tel1);
                        telServ.save(tel2);
                        telServ.save(tel3);
                        telServ.save(tel4);
                    } else {

                        Telefone tel1 = new Telefone(null, ddd + "1" + String.valueOf(obtemNumAleatorio(987654)), TipoTelefone.CELULAR, lst);
                        pes.getTelefones().addAll(Arrays.asList(tel1));
                        pesServ.save(pes);
                        telServ.save(tel1);
                    }
                }
            }
        };
    }

    @Bean
    public CommandLineRunner cargaCategorias(CategoriaService categServ) {

        return args -> {
            categServ.save(new Categoria("MPB"));
            categServ.save(new Categoria("Rock"));
            categServ.save(new Categoria("Vira"));
            categServ.save(new Categoria("Bossa Nova"));
            categServ.save(new Categoria("Jazz"));
            categServ.save(new Categoria("Pop Rock"));
            categServ.save(new Categoria("Eletronic"));
            categServ.save(new Categoria("Pop"));
        };
    }

    @Bean
    public CommandLineRunner cargaMusica(MusicaService musicaServ,
                                         CategoriaService categoriaServ) {

        return args -> {
            var lstCateg = categoriaServ.findAll();
            musicaServ.saveMusica(240, "Amor I love you", lstCateg.get(0).getCodCategoria());
            musicaServ.saveMusica(300, "Nao e facil", lstCateg.get(0).getCodCategoria());
            musicaServ.saveMusica(250, "Gentileza", lstCateg.get(0).getCodCategoria());

            musicaServ.saveMusica(500, "Daniel na cova dos leoes", lstCateg.get(1).getCodCategoria());
            musicaServ.saveMusica(322, "Fábrica", lstCateg.get(1).getCodCategoria());
            musicaServ.saveMusica(440, "Tempo Perdido", lstCateg.get(1).getCodCategoria());
            musicaServ.saveMusica(312, "Acrilic on canvas", lstCateg.get(1).getCodCategoria());

            musicaServ.saveMusica(298, "Vira-vira", lstCateg.get(2).getCodCategoria());

            musicaServ.saveMusica(348, "Chega de saudade", lstCateg.get(3).getCodCategoria());
            musicaServ.saveMusica(231, "Luiza", lstCateg.get(3).getCodCategoria());
            musicaServ.saveMusica(355, "Aguas de marco", lstCateg.get(3).getCodCategoria());
            musicaServ.saveMusica(250, "Wave", lstCateg.get(3).getCodCategoria());

            musicaServ.saveMusica(333, "Politik", lstCateg.get(5).getCodCategoria());
            musicaServ.saveMusica(225, "Green eyes", lstCateg.get(5).getCodCategoria());
            musicaServ.saveMusica(440, "A Rush of Blood to the head", lstCateg.get(5).getCodCategoria());
            musicaServ.saveMusica(320, "Clocks", lstCateg.get(5).getCodCategoria());
            musicaServ.saveMusica(300, "Codinome beija-flor", lstCateg.get(5).getCodCategoria());
            musicaServ.saveMusica(290, "Faz parte do meu show", lstCateg.get(5).getCodCategoria());

            musicaServ.saveMusica(446, "New York", lstCateg.get(4).getCodCategoria());
            musicaServ.saveMusica(299, "Solitudine", lstCateg.get(7).getCodCategoria());
            musicaServ.saveMusica(430, "Oceano", lstCateg.get(0).getCodCategoria());
            musicaServ.saveMusica(511, "With or without you", lstCateg.get(1).getCodCategoria());
            musicaServ.saveMusica(300, "Beautiful day", lstCateg.get(1).getCodCategoria());
            musicaServ.saveMusica(458, "Bullet The Blue Sky", lstCateg.get(1).getCodCategoria());
            musicaServ.saveMusica(300, "Sua", lstCateg.get(0).getCodCategoria());

        };
    }

    @Bean
    public CommandLineRunner cargaGravadora(GravadoraService gravadoraServ) {

        return args -> {
            gravadoraServ.save(new Gravadora("Sony Music", Pais.ESTADOSUNIDOS));
            gravadoraServ.save(new Gravadora("Som Livre", Pais.BRASIL));
            gravadoraServ.save(new Gravadora("EMI", Pais.ESTADOSUNIDOS));
            gravadoraServ.save(new Gravadora("Globo", Pais.BRASIL));
            gravadoraServ.save(new Gravadora("Trama", Pais.BRASIL));
        };
    }

    @Bean
    public CommandLineRunner cargaCantor(CantorService cantorServ) {

        return args -> {

            cantorServ.save(new Cantor("Marisa Monte", Pais.BRASIL));
            cantorServ.save(new Cantor("Coldplay", Pais.INGLATERRA));
            cantorServ.save(new Cantor("U2", Pais.IRLANDA));
            cantorServ.save(new Cantor("Djavan", Pais.BRASIL));
            cantorServ.save(new Cantor("Laura Pausini", Pais.ITALIA));
            cantorServ.save(new Cantor("Roberto Leal", Pais.PORTUGAL));
            cantorServ.save(new Cantor("The Corrs", Pais.ESTADOSUNIDOS));
            cantorServ.save(new Cantor("Legiao Urbana", Pais.BRASIL));
            cantorServ.save(new Cantor("Cazuza", Pais.BRASIL));
            cantorServ.save(new Cantor("Tom Jobim", Pais.BRASIL));
            cantorServ.save(new Cantor("Frank Sinatra", Pais.ESTADOSUNIDOS));

            log.info("Busca cantor por ID: " + cantorServ.findById(1L));
        };
    }

    @Bean
    public CommandLineRunner cargaGravacao(GravacaoService gravacaoServ) {

        return args -> {

            gravacaoServ.save(LocalDate.parse("2000-07-10"), Long.valueOf(1), Long.valueOf(1), Long.valueOf(1));
            gravacaoServ.save(LocalDate.parse("2000-12-07"), Long.valueOf(1), Long.valueOf(1), Long.valueOf(2));
            gravacaoServ.save(LocalDate.parse("2001-05-30"), Long.valueOf(1), Long.valueOf(8), Long.valueOf(3));
            gravacaoServ.save(LocalDate.parse("2005-12-29"), Long.valueOf(3), Long.valueOf(8), Long.valueOf(4));
            gravacaoServ.save(LocalDate.parse("1993-04-25"), Long.valueOf(3), Long.valueOf(8), Long.valueOf(5));
            gravacaoServ.save(LocalDate.parse("1989-01-31"), Long.valueOf(3), Long.valueOf(8), Long.valueOf(6));
            gravacaoServ.save(LocalDate.parse("1991-12-01"), Long.valueOf(3), Long.valueOf(8), Long.valueOf(7));
            gravacaoServ.save(LocalDate.parse("1988-07-30"), Long.valueOf(3), Long.valueOf(6), Long.valueOf(7));


        };
    }

    @Bean
    public CommandLineRunner listaTodasPessoas(PessoaService pessoaServ) {
        return args -> {

            List<Pessoa> lstPessoa = pessoaServ.findAll();

            for (Pessoa lst : lstPessoa) {
                log.info(lst.toString());
            }
        };
    }

//    @Bean
//    public CommandLineRunner cargaDepartamento(DepartamentoService deptoService) {
//        return args -> {
//
//            deptoService.save(new Departamento("Recursos Humanos"));
//            deptoService.save(new Departamento("Jurídico"));
//            deptoService.save(new Departamento("Diretoria de Tecnologia da Informação"));
//            deptoService.save(new Departamento("Diretoria Financeira"));
//            deptoService.save(new Departamento("Vendas"));
//            deptoService.save(new Departamento("Diretoria Comercial"));
//        };
//    }
//
//    @Bean
//    public CommandLineRunner listaTodosDepartamento(DepartamentoService deptoService) {
//
//        return args -> {
//
//            List<Departamento> listDepto = deptoService.findAll();
//
//            log.info("Tam lista: " + listDepto.size());
//            for (Departamento x : listDepto) {
//                log.info(x.toString());
//            }
//        };
//
//    }
//
//    @Bean
//    public CommandLineRunner cargaFuncionario(FuncionarioService funcService,
//                                              DepartamentoService deptoService) {
//
//        return args -> {
//
//            List<Departamento> listDepto = deptoService.findAll();
//
//            int qtdeDepto = listDepto.size();
//
//            for (int i = 1; i <= 100; i++) {
//
//                Long idDepto = Long.valueOf(obtemNumAleatorio(qtdeDepto));
//                Integer numDepend = obtemDependenteAleatorio(3);
//
//                Optional<Departamento> depto = deptoService.findById(idDepto);
//
//                if (!depto.isEmpty()) {
//
//                    log.info(depto.toString());
//                    Departamento newDepto = depto.get();
//
//                    Funcionario func = new Funcionario("Funcionario" + i, numDepend, (1000F + (1200F * numDepend) + (i * 100)), "Cargo " + newDepto.getId(), newDepto);
//                    funcService.save(func);
//                    log.info("OK");
//                }
//            }
//        };
//    }
//
////    @Bean
////    public CommandLineRunner listaTodosFuncionarios(FuncionarioService funcService) {
////
////        return args -> {
////
////            List<Funcionario> listaFunc = funcService.findAll();
////
////            for (Funcionario x : listaFunc) {
////
////                log.info(x.toString());
////            }
////        };
////    }
//
////    @Bean
////    public CommandLineRunner listaFuncionarioPorDepto(FuncionarioRepository funcRepository) {
////
////        return args -> {
////
////            log.info("\nEntrando no método listaFuncionarioPorDepto\n");
////            List<Funcionario> listaFunc = funcRepository.findByDepartamento_Id(Long.parseLong("1"));
////
////            for (Funcionario x : listaFunc) {
////
////                log.info(x.toString());
////            }
////        };
////    }
//
//    // Uma consulta que lista todos os funcionários de um determinado departamento
//    // que não possuam dependentes utilizando parâmetros nomeados.
//    @Bean
//    public CommandLineRunner listFuncionarioWithoutDepend(FuncionarioRepository funcionarioRepository) {
//
//        return args -> {
//
//            log.info("\nEntrando no método listFuncionarioWithoutDepend\n");
//            List<Funcionario> listFunc = funcionarioRepository.listFuncionarioWithoutDepend(1L);
//
//            for (Funcionario x: listFunc) {
//
//                log.info(x.toString());
//            }
//        };
//    }
}
