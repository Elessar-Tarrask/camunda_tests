package kz.khaz.camunda.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import kz.khaz.camunda.entity.common.BankRequisites;
import kz.khaz.camunda.entity.common.CommonEntity;
import kz.khaz.camunda.entity.common.Documents;
import kz.khaz.camunda.entity.common.enum_folder.OwnershipType;
import kz.khaz.camunda.entity.common.enum_folder.Roles;
import kz.khaz.camunda.repositoryrestconfigurationvalidation.ValidateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class BorrowerInformation extends CommonEntity {

    @NotNull
    private String registration_certificate;

    private String entrepreneur_procuration;           // доверенность

    @Column(columnDefinition = "boolean default false")
    private Boolean active_account = false;

    @Valid
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "borrower_id")
    private Set<Documents> documents;

    @Column(length = 32, columnDefinition = "varchar(32) default 'borrower'")
    @Enumerated(value = EnumType.STRING)
    private Roles role = Roles.borrower;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bankRequisites_id", referencedColumnName = "id")
    private BankRequisites bankRequisites;

    @NotNull
    @ValidateEnum(targetClassType = OwnershipType.class, message = "Please select right String type ['IE', 'LLP']")
    private String ownership_type;


    @Size(min = 12, max = 12)
    @NotNull
    private String organization_BIN;
    @NotNull
    private String organization_name;

    @NotNull
    private String address;

    @Size(min = 6, max = 6)
    @NotNull
    private String address_index;

//    @JsonIgnore
//    private String password;

    @JsonIgnore
    @AssertTrue
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean collection_consent;

    @JsonIgnore
    @AssertTrue
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean pkb_request_consent;

    @JsonIgnore
    @AssertTrue
    @NotNull
    private Boolean read_private_policy;

    @JsonIgnore
    @AssertTrue
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean is_director_as_guarantor;

    @JsonIgnore
    @AssertTrue
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean provide_founder_personal_data;

    @JsonIgnore
    private Boolean is_founder_legal_entity;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String guarantor_IIN;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String guarantor_FIO;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String guarantor_email;
}
