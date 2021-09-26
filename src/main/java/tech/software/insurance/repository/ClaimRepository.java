package tech.software.insurance.repository;

import org.springframework.data.repository.CrudRepository;
import tech.software.insurance.domain.Claim;

public interface ClaimRepository extends CrudRepository<Claim, Integer> {
}
