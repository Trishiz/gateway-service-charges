package zw.co.nbs.gatewayservicecharges.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonDeserialize
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonSerialize
public class ChargeResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("statusCode")
    private int statusCode;
    private boolean success;
    private String message;
    @JsonProperty("responseBody")
    @JsonSerialize
    private T responseBody;

    public ChargeResponse() {
    }

    public ChargeResponse(int statusCode, String message) {
        this.statusCode = statusCode != 200 && statusCode != 0 ? 99 : statusCode;
        this.success = statusCode == 200 || statusCode == 0;
        this.message = message;
        this.responseBody = null;
    }

    public ChargeResponse(int statusCode, boolean success, String message, T responseBody) {
        this.statusCode = statusCode;
        this.success = success;
        this.message = message;
        this.responseBody = responseBody;
    }

    @JsonIgnore
    public ChargeResponse<T> buildErrorResponse(String message) {
        this.message = message;
        this.success = false;
        this.responseBody = null;
        this.statusCode = 99;
        return this;
    }

    @JsonIgnore
    public ChargeResponse<T> buildSuccessResponse(final T data) {
        this.message = "Success";
        this.responseBody = data;
        this.success = true;
        this.statusCode = 0;
        return this;
    }

    @JsonIgnore
    public ChargeResponse<T> buildSuccessResponse(String message, final T data) {
        this.message = message;
        this.responseBody = data;
        this.success = true;
        this.statusCode = 0;
        return this;
    }

    @JsonIgnore
    public ChargeResponse<T> buildErrorResponse() {
        this.message = "fail";
        this.responseBody = null;
        this.success = false;
        this.statusCode = 99;
        return this;
    }

    @JsonIgnore
    public ChargeResponse<T> buildErrorResponse(int code, String message) {
        this.message = message;
        this.responseBody = null;
        this.success = false;
        this.statusCode = code;
        return this;
    }

    @JsonIgnore
    public ChargeResponse<T> buildErrorResponse(String message, final T data) {
        this.message = message;
        this.responseBody = data;
        this.success = false;
        this.statusCode = 99;
        return this;
    }

    @JsonIgnore
    public ChargeResponse<T> buildErrorResponse(int code, String message, final T data) {
        this.statusCode = code;
        this.message = message;
        this.responseBody = data;
        this.success = false;
        return this;
    }

    @JsonIgnore
    public boolean responseBodyEmpty() {
        return this.responseBody == null;
    }

    @JsonProperty("statusCode")
    public void setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    @JsonProperty("responseBody")
    public void setResponseBody(final T responseBody) {
        this.responseBody = responseBody;
    }

    public String toString() {
        return "Response(statusCode=" + this.getStatusCode() + ", success=" + this.isSuccess() + ", message=" + this.getMessage() + ", responseBody=" + this.getResponseBody() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ChargeResponse)) {
            return false;
        } else {
            ChargeResponse<?> other = (ChargeResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getStatusCode() != other.getStatusCode()) {
                return false;
            } else if (this.isSuccess() != other.isSuccess()) {
                return false;
            } else {
                label40: {
                    Object this$message = this.getMessage();
                    Object other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label40;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label40;
                    }

                    return false;
                }

                Object this$responseBody = this.getResponseBody();
                Object other$responseBody = other.getResponseBody();
                if (this$responseBody == null) {
                    if (other$responseBody != null) {
                        return false;
                    }
                } else if (!this$responseBody.equals(other$responseBody)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ChargeResponse;
    }


}

