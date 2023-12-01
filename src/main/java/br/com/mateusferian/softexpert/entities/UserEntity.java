package br.com.mateusferian.softexpert.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String cpf;

    private String telephone;

    public UserEntity(String name, String cpf, String telephone) {
        this.name = name;
        this.cpf = cpf;
        this.telephone = telephone;
    }
}
