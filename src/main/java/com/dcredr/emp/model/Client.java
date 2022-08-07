package com.dcredr.emp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "client")
@IdClass(Client.class)
public class Client implements Serializable {

    private static final long serialVersionUID = 10L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int id;

    @Column(name = "client_name")
    private String clientName;

}
