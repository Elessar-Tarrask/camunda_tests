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

    private OwnershipType ownership_type;

    private String organization_name;

    @Column(length = 50)
    private String email_address;

    @Column(length = 11)
    private String phone_number;
    private DocumentType executive_document_type;

    private String document_identifier_front;
    private String document_identifier_back;

    private String entrepreneur_permission;

    private String entrepreneur_procuration;

    private String address;

    @Column(length = 6)
    private String address_index;

    @Column(length = 20)
    private String IIK;

    @Column(length = 20)
    private String BIK;

    private String bank_name;

    private String office_phone_number;

    private String office_email;

    private Roles role;

    @Column(columnDefinition = "boolean default false")
    private Boolean active_account;

    private String password;

    @Column(columnDefinition = "boolean default false")
    private Boolean collection_consent;

    @Column(columnDefinition = "boolean default false")
    private Boolean pkb_request_consent;

    @Column(columnDefinition = "boolean default false")
    private Boolean read_private_policy;

    @Column(columnDefinition = "boolean default false")
    private Boolean agreement_being_guarantor;
}
