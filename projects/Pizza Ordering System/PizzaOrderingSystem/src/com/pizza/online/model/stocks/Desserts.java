package com.pizza.online.model.stocks;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pos_desserts", catalog = "posdb")
public class Desserts extends Item {

	private static final long serialVersionUID = -8229023470719985547L;

}
