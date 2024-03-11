package zw.co.nbs.gatewayservicecharges.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import zw.co.nbs.utils.common.model.generic.UpdatableModel;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(using = ToStringSerializer.class)
@JsonDeserialize
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Charge extends UpdatableModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String adviceCreditCode;
    private String adviceDebitCode;
    private String debitCode;
    private String creditCode;
    private String description;
    private String currencyMnemonic;
    private String reversalCreditCode;
    private String reversalDebitCode;
    private Long value;
    private Long maximum;
    private Long minimum;
    private Long transactionalLimit;
//    private int version;
//    private Date createdAt;
//    private Date updatedAt;
//    private Long createdBy;
//    private Long updatedBy


}
