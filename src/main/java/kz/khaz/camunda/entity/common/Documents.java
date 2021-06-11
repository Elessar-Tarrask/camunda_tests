package kz.khaz.camunda.entity.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.khaz.camunda.entity.BorrowerInformation;
import kz.khaz.camunda.entity.common.enum_folder.DocumentType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;


/**
 * Таблица хранения внутренних документов директоров и руководителей подвязана
 * <p>
 * id - идентификатор
 * executive_document_name - наименование роли человека, учредитель или же руководитель, или же директор
 * executive_document_code - код для вышестоящего имени (если требуется)
 * executive_document_type - тип документа (удостоверение или паспорт)
 * document_identifier_front - ссылка на передную часть изображение в хранилище
 * document_identifier_back -  ссылка на заднюю часть изображение в хранилище
 * city - Город
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Documents extends CommonEntity {
    @NotNull
    private String executives_identification_number;
    @NotNull
    private String executives_full_name;

    @Column(length = 50)
    @NotNull
    private String email_address;

    @Column(length = 11)
    @NotNull
    private String phone_number;

    // added this params
    @NotNull
    private String executive_document_name;
    private Integer executive_document_code;

    @NotNull
    private String executive_document_type;

    @NotNull
    private String document_identifier_front;
    @NotNull
    private String document_identifier_back;

    @ManyToOne
    @JsonIgnore
    private BorrowerInformation borrowerInformation;
}
