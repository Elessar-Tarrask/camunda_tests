package kz.khaz.camunda.entity;

import kz.khaz.camunda.entity.common.BankRequisites;
import kz.khaz.camunda.entity.common.CommonEntity;
import kz.khaz.camunda.entity.common.enum_folder.OwnershipType;
import kz.khaz.camunda.entity.common.enum_folder.Roles;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
public class BorrowerInformation extends CommonEntity {

    private String registration_certificate;

    private String entrepreneur_procuration;

    @Column(columnDefinition = "boolean default false")
    private Boolean active_account;

    private Roles role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private BankRequisites bankRequisites;

    @Column(columnDefinition = "boolean default false")
    private Boolean agreement_being_guarantor;
}
