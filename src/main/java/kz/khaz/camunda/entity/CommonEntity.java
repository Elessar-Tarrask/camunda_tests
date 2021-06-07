package kz.khaz.camunda.entity;

import jdk.jfr.DataAmount;
import kz.khaz.camunda.entity.enum_folder.OwnershipType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Component
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
    private Long executives_identification_number;
    private String executives_full_name;
    private String email_address;
    private String phone_number;
    private String executive_document_type;

}
