package kz.khaz.camunda.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import kz.khaz.camunda.entity.common.BankRequisites;
import kz.khaz.camunda.entity.common.CommonEntity;
import kz.khaz.camunda.entity.common.Documents;
import kz.khaz.camunda.entity.common.enum_folder.OwnershipType;
import kz.khaz.camunda.entity.common.enum_folder.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class BorrowerInformation extends CommonEntity {

    private String registration_certificate;

    private String entrepreneur_procuration;           // доверенность

    @Column(columnDefinition = "boolean default false")
    private Boolean active_account;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "borrower_id")
    private Set<Documents> documents;

    @Column(length = 32, columnDefinition = "varchar(32) default 'borrower'")
    @Enumerated(value = EnumType.STRING)
    private Roles role = Roles.borrower;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private BankRequisites bankRequisites;

    @NotNull
    private OwnershipType ownership_type;


    @Column(length = 20)
    private String organization_BIN;
    private String organization_name;

    private String address;

    @Column(length = 6)
    private String address_index;

//    @JsonIgnore
//    private String password;

    @JsonIgnore
    @Column(insertable = false, updatable = false)
    private Boolean collection_consent;

    @JsonIgnore
    @Column(insertable = false, updatable = false)
    private Boolean pkb_request_consent;

    @JsonIgnore
    @Column(insertable = false, updatable = false)
    private Boolean read_private_policy;

    @JsonIgnore
    @Column(insertable = false, updatable = false)
    private Boolean is_director_as_guarantor;

    @JsonIgnore
    @Column(insertable = false, updatable = false)
    private Boolean provide_founder_personal_data;

    @JsonIgnore
    @Column(insertable = false, updatable = false)
    private Boolean is_founder_legal_entity;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String guarantor_IIN;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String guarantor_FIO;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String guarantor_email;
}
