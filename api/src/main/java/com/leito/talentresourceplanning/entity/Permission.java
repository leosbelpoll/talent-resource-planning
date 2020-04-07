package com.leito.talentresourceplanning.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity(name = Permission.COLLECTION)
@NoArgsConstructor
@Setter
@Getter
public class Permission extends BaseEntity{
    public static final String COLLECTION = "permissions";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    private String description;

    @ManyToMany(mappedBy = "permissions")
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    public Permission(String name) {
        this.name = name;
    }

    public Permission(String name, String description) {
        this(name);
        this.description = description;
    }
}
