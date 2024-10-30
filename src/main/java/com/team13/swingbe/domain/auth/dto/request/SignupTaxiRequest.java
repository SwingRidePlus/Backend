package com.team13.swingbe.domain.auth.dto.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupTaxiRequest {
    @NotBlank
    private String number;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String gender;

    @NotBlank
    private String carNumber;

    @NotBlank
    private String age;
}
