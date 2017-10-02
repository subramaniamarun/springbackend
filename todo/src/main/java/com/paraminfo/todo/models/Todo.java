/**
 * 
 */
package com.paraminfo.todo.models;


import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * @author admin
 *
 */

@Document(collection = "todos")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Todo {

	@Id
	private String id;
	
	@NotBlank
	@Size(max=100)
	@Indexed(unique=true)
	private String title;
	
	private boolean completed = false;
	
	private Date createdAt = new Date();
	
	public Todo() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Todo[id=%s, title='%s', completed='%s']",
                id, title, completed);
    }
}
