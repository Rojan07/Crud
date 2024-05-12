package com.teacher.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherModel {

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles" , joinColumns = @JoinColumn(name = "user_id" ,referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

}
