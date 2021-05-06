package com.system.beans;

/**
 * @author Alex Ryberg - alexr151
 * CIS175 - Spring 2021
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="user_table")
@AllArgsConstructor
public class UserTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="list_id")
	private long listId;
	public String fName;
	private String lName;
	private String email;
	private long produceId;
	
//	@ManyToMany
//	Set<Produce> produce;
//	
//	@JoinTable(
//			name = "items_on_list",
//			joinColumns = @JoinColumn(name = "listId"),
//			inverseJoinColumns = @JoinColumn(name = "id"))
//	Set<Produce> produceList;
	
	public UserTable() {
		
	}
	
	
}
