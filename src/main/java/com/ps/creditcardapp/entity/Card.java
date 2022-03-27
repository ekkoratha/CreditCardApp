package com.ps.creditcardapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    @NotNull(message = "Name cannot be null")
    private String name;

    @Size(min=12, max = 19, message= "Card max length 19")
    private String number;

    private Long limitoncard;

    private long balance;
}
