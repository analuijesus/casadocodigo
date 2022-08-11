package br.com.casadocodigo.category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String name;

    public Category(String name) {
        this.name = name;
    }

    @Deprecated
    public Category() {}

    @Override
    public String toString() {
        return super.toString();
    }
}
