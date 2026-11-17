package br.com.invistoplus.repository;

import br.com.invistoplus.domain.InvestmentEntity;
import br.com.invistoplus.domain.InvestmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repository JPA para a entidade InvestmentEntity.
 * Permite operações CRUD e consultas personalizadas.
 */
@Repository
public interface InvestmentRepository extends JpaRepository<InvestmentEntity, UUID> {
    
    /**
     * Encontra todos os investimentos de um tipo específico.
     */
    List<InvestmentEntity> findByInvestmentType(InvestmentType investmentType);
    
    /**
     * Encontra investimentos pelo nome (case-insensitive).
     */
    List<InvestmentEntity> findByNameContainingIgnoreCase(String name);
}