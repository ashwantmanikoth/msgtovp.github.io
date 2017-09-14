package com.pizza.online.model.stocks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "pos_drinks")
public class Drinks extends Item {

	private Capacity capacity;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	public Capacity getCapacity() {
		return capacity;
	}

	public void setCapacity(Capacity capacity) {
		this.capacity = capacity;
	}

	private static final long serialVersionUID = -2364250000679774905L;

}
