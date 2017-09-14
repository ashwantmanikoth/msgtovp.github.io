package com.pizza.online.model.stocks;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pos_sides", catalog = "posdb")
public class Sides extends Item {
	private static final long serialVersionUID = -3342715320297109844L;

}
