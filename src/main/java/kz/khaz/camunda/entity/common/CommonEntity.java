package kz.khaz.camunda.entity.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import kz.khaz.camunda.entity.common.enum_folder.DocumentType;
import kz.khaz.camunda.entity.common.enum_folder.OwnershipType;
import kz.khaz.camunda.entity.common.enum_folder.Roles;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CommonEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @JsonIgnore
    @CreatedDate
    private Date createdTime;

    @JsonIgnore
    @LastModifiedDate
    private Date modifiedTime;

}
