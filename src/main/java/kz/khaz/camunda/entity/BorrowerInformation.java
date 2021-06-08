package kz.khaz.camunda.entity;

import kz.khaz.camunda.entity.common.CommonEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class BorrowerInformation extends CommonEntity {

    @Column(length = 12)
    private String executives_identification_number;

    private String executives_full_name;
}
