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
@Table(name = "auth_user_role")
public class AuthUserRole implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "auth_user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "auth_role_id", nullable = false)
	private Role role;

	@Builder.Default
	private Integer status = 1;
}