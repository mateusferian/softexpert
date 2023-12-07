package br.com.mateusferian.softexpert.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "{white.field}")
    @Size(min = 3,max = 50, message = "{size.invalid}")
    private String name;

    @NotBlank(message = "{white.field}")
    @Size(min = 11,max = 11, message = "{size.invalid}")
    private String cpf;

    @NotBlank(message = "{white.field}")
    @Size(min = 11,max = 11, message = "{size.invalid}")
    private String telephone;

    @Override
    public String toString() {
        return "UserEntity{" +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
