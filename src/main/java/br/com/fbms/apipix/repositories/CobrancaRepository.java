package br.com.fbms.apipix.repositories;

import br.com.fbms.apipix.models.EntCobranca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CobrancaRepository extends JpaRepository<EntCobranca, String> {
}
