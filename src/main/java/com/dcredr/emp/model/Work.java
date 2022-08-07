package com.dcredr.emp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "works_with")
@IdClass(Work.class)
public class Work implements Serializable {

    private static final long serialVersionUID = 10L;
    @Id
    private int emp_id;


    @Id
    private int client_id;

    @Column(name = "total_sales")
    private int totalSales;


//    @Id
////    @ManyToMany(fetch = FetchType.LAZY,
////            cascade = {
////                    CascadeType.PERSIST,
////                    CascadeType.MERGE
////            })
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @JoinColumn(name = "emp_id",referencedColumnName = "emp_id")
//    private Employee employee;
//    @JoinTable(name = "emp_id",
//            joinColumns = { @JoinColumn(name = "emp_id") },
//            inverseJoinColumns = { @JoinColumn(name = "client_id") })
//    private Set<Employee> employees = new HashSet<>();


////    @ManyToMany(fetch = FetchType.LAZY,
////            cascade = {
////                    CascadeType.PERSIST,
////                    CascadeType.MERGE
////            })
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
//    private Client client;

//    @JoinTable(name = "client_id",
//            joinColumns = { @JoinColumn(name = "client_id") },
//            inverseJoinColumns = { @JoinColumn(name = "emp_id") })
//    private Set<Client> clients = new HashSet<>();




}
