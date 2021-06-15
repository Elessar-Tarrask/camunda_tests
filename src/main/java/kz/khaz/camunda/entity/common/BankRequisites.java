package kz.khaz.camunda.entity.common;

import kz.khaz.camunda.entity.BorrowerInformation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class BankRequisites extends CommonEntity {

    @NotNull
    private String iik;

    @NotNull
    private String bik;

    @OneToOne(mappedBy = "bankRequisites")
    private BorrowerInformation borrowerInformation;

    @NotNull
    private String bank_name;

    @NotNull
    private String office_phone_number;

    @NotNull
    private String office_email;
}
