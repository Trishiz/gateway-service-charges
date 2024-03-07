package zw.co.nbs.gatewayservicecharges.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(using = ToStringSerializer.class)
@JsonDeserialize
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Charge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
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
    private int version;
    private Date createdAt;
    private Date updatedAt;
    private Long createdBy;
    private Long updatedBy;


}
