package kz.khaz.camunda.Repo;

import kz.khaz.camunda.entity.BorrowerInformation;
import kz.khaz.camunda.entity.common.Documents;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.inject.Inject;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "borrower", path = "borrower")
public interface BorrowerInformationRepository extends PagingAndSortingRepository<BorrowerInformation, UUID> {

}


