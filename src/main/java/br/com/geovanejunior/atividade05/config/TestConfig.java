package br.com.geovanejunior.atividade05.config;

import br.com.geovanejunior.atividade05.entity.Departamento;
import br.com.geovanejunior.atividade05.entity.Funcionario;
import br.com.geovanejunior.atividade05.service.DepartamentoService;
import br.com.geovanejunior.atividade05.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Configuration
@EnableJpaRepositories("br.com.geovanejunior.atividade05.repository")
@ComponentScan("br.com.geovanejunior.atividade05.service")
@EnableTransactionManagement
public class TestConfig {

    private static final Logger log = LoggerFactory.getLogger(TestConfig.class);

    private int obtemNumAleatorio(Integer num) {

        Random random = new Random();

        int numAleatorio = random.nextInt(num) + 1;
        return numAleatorio;
    }

    private int obtemDependenteAleatorio(Integer num) {

        Random random = new Random();

        int numAleatorio = random.nextInt(num);
        return numAleatorio;
    }

    // Método responsável pela configuração do BD utilizado, usuário, senha e pool de conexão
    @Bean
    public DataSource dataSource() {

//        DataSourceBuilder ds = DataSourceBuilder.create();

//        ds.driverClassName("org.h2.Driver");
//        ds.url("jdbc:h2:mem:testdb");
//        ds.username("sa");
//        ds.password("");
//
//        return ds.build();
//
        DataSourceBuilder ds = DataSourceBuilder.create();

        ds.driverClassName("com.mysql.jdbc.Driver");
        ds.url("jdbc:mysql://localhost:3306/atividade05");
        ds.username("root");
        ds.password("");

        return ds.build();

    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("br.com.geovanejunior");
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory());
        manager.setJpaDialect(new HibernateJpaDialect());

        return manager;
    }

    @Bean
    public CommandLineRunner cargaDepartamento(DepartamentoService deptoService) {
        return args -> {

            deptoService.save(new Departamento("Recursos Humanos"));
            deptoService.save(new Departamento("Jurídico"));
            deptoService.save(new Departamento("Diretoria de Tecnologia da Informação"));
            deptoService.save(new Departamento("Diretoria Financeira"));
            deptoService.save(new Departamento("Vendas"));
            deptoService.save(new Departamento("Diretoria Comercial"));
        };
    }

    @Bean
    public CommandLineRunner listaTodosDepartamento(DepartamentoService deptoService) {

        return args -> {

            List<Departamento> listDepto = deptoService.findAll();

            log.info("Tam lista: " + listDepto.size());
            for (Departamento x : listDepto) {
                log.info(x.toString());
            }
        };

    }

    @Bean
    public CommandLineRunner cargaFuncionario(FuncionarioService funcService,
                                              DepartamentoService deptoService) {

        return args -> {

            List<Departamento> listDepto = deptoService.findAll();

            int qtdeDepto = listDepto.size();

            for (int i = 1; i <= 20; i++) {

                Long idDepto = Long.valueOf(obtemNumAleatorio(qtdeDepto));
                Integer numDepend = obtemDependenteAleatorio(3);

                Optional<Departamento> depto = deptoService.findById(idDepto);

                if (!depto.isEmpty()) {

                    log.info(depto.toString());
                    Departamento newDepto = depto.get();

                    Funcionario func = new Funcionario("Funcionário " + i, numDepend, (1000F + (1200F * numDepend)), "", newDepto);
                    funcService.save(func);
                    log.info("OK");
                }
            }
        };
    }

    @Bean
    public CommandLineRunner listaTodosFuncionarios(FuncionarioService funcService) {

        return args -> {

            List<Funcionario> listaFunc = funcService.findAll();

            for (Funcionario x : listaFunc) {

                log.info(x.toString());
            }
        };
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        Date dtCadastro = new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-15");
//
//        Endereco end1 = new Endereco();
//        end1.setTipoEndereco(Endereco.TipoEndereco.RESIDENCIAL);
//        end1.setLogradouro("Av. 1");
//        end1.setCidade("São Paulo");
//        end1.setEstado("SP");
//
//        Contato c1 = new Contato();
//        c1.setNome("Geovane");
//        c1.setIdade(48);
//        c1.setDtCadastro(dtCadastro);
//        c1.setEndereco(end1);
//
////        enderecoRepository.save(end1);
//    }
}
