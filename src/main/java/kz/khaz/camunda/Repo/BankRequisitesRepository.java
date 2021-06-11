package kz.khaz.camunda.Repo;

import kz.khaz.camunda.entity.common.BankRequisites;
import kz.khaz.camunda.entity.common.Documents;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "bankreq", path = "bankreq", exported=false)
public interface BankRequisitesRepository extends PagingAndSortingRepository<BankRequisites, UUID> {
}
