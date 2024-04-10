package com.bonifacio.shorty_link.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_url")
@AllArgsConstructor
@Data
public class UserUrl extends Url{
    @NotEmpty
    @NotBlank
    @Size(max = 150)
    private String name;
    @Size(max = 500,min = 50)
    private String description;

    public UserUrl(){
        super();
    }

}
