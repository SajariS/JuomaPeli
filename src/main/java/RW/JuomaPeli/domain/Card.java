package RW.JuomaPeli.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	private String title;
	
	private String desc;
	
	private Boolean userMade;
	
	// Yhdistykset puuttuu, tehdään myöhemmin kun muut taulut tulevat

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Boolean getUserMade() {
		return userMade;
	}

	public void setUserMade(Boolean userMade) {
		this.userMade = userMade;
	}

	public Card(String title, String desc, Boolean userMade) {
		super();
		this.title = title;
		this.desc = desc;
		this.userMade = userMade;
	}

	public Card() {
		super();
	}
	
	
}
