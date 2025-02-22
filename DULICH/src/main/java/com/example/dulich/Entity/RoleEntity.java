package com.example.dulich.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "[Role]")
public class RoleEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;

    @Column(name = "role_name")
    private String role_name;


    public void add(Optional<RoleEntity> defaultRole) {
    }
}
