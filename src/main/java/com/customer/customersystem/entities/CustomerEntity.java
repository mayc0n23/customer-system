package com.customer.customersystem.entities;

import com.customer.customersystem.domain.Type;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "main_document", nullable = false, unique = true)
    private String mainDocument;

    @Column(name = "secondary_document")
    private String secondaryDocument;

    @Column(name = "registration_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime registrationDate;

    @Column(nullable = false)
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneEntity> phones;

}
