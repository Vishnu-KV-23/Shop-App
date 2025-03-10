package com.vishnudev.Shop.App.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Data
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    @Column(name = "phone_number")
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    private UserRole role;
@OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
private List<OrderItem> orderItemList;
@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Address address;
@Column(name = "created_at")
private final LocalDateTime createdAt = LocalDateTime.now();


}
