package kz.khaz.camunda.entity.common;

import kz.khaz.camunda.entity.common.enum_folder.DocumentType;
import kz.khaz.camunda.entity.common.enum_folder.OwnershipType;
import kz.khaz.camunda.entity.common.enum_folder.Roles;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Component
@Data
public class CommonEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    private OwnershipType ownership_type;


    @Column(length = 20)
    private String organization_BIN;
    private String organization_name;

    @OneToMany(mappedBy="id")
    private Set<Documents> documents;

    private String address;

    @Column(length = 6)
    private String address_index;

    private String password;
//
    @Column(columnDefinition = "boolean default false")
    private Boolean collection_consent;

    @Column(columnDefinition = "boolean default false")
    private Boolean pkb_request_consent;

    @Column(columnDefinition = "boolean default false")
    private Boolean read_private_policy;
}
