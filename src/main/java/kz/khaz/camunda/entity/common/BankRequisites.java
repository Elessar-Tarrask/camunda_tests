package kz.khaz.camunda.entity.common;

import kz.khaz.camunda.entity.BorrowerInformation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class BankRequisites extends CommonEntity {

    @Column(length = 20)
    private String IIK;

    @Column(length = 20)
    private String BIK;

    @OneToOne(mappedBy = "bankRequisites")
    private BorrowerInformation borrowerInformation;

    private String bank_name;

    private String office_phone_number;

    private String office_email;
}
