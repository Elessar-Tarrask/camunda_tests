package kz.khaz.camunda.Repo;

import kz.khaz.camunda.entity.common.Documents;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@RepositoryRestResource(collectionResourceRel = "docs", path = "docs", exported=false)
public interface DocumentsRepository extends PagingAndSortingRepository<Documents, UUID> {
}