package com.example.dulich.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Status_Tour")
public class StatusTourEntity {

        private static final long serialVersionUID = 1L;
        @Id
        @Column(name = "Status_ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer status_Id;

        @Column(name = "Type_Status")
        private String type_Status;

}
