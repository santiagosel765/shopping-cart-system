package com.shopping.common.entity.user;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_status")
public class UserStatus implements Serializable {

    @Id
    @Column(name = "status_id")
    private Integer statusId;

    @Column(nullable = false)
    private String name;

    private String description;

    public UserStatus(Integer statusId) {
        this.statusId = statusId;
    }
}
