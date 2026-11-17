package br.com.invistoplus;

import br.com.invistoplus.controller.InvestmentController;
import br.com.invistoplus.service.InvestmentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testes de integração usando H2 em memória (sem Docker).
 * Perfil 'test' usa H2 Database em vez de PostgreSQL.
 */
@SpringBootTest
@ActiveProfiles("test")
class InvestmentControllerIntegrationTest {

    @Autowired
    private InvestmentController investmentController;
    
    @Autowired
    private InvestmentService investmentService;
    
    @Test
    void contextLoads() {
        // Verifica que o contexto Spring carregou corretamente
        assertThat(investmentController).isNotNull();
        assertThat(investmentService).isNotNull();
    }
}