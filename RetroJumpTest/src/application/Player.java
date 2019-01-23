package application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends ImageView {
	
	public static Scene scene;
	
	private final String nom;
	public String getNom() {return this.nom;}
	
	private final Player ancetre;
	public Player getAncetre() {return this.ancetre;}
	
	public Player(String nom, Image image) {
		this.setFitHeight(40);
		this.setFitWidth(30);
//		this.setX(20);
//		this.setY(scene.getHeight()-20);
		this.nom = nom;
		this.ancetre = null;
		this.setImage(image);
	}
	
	public Player(String nom, Image image, Player ancetre) {
		this.setFitHeight(20);
		this.setFitWidth(20);
		this.setX(20);
		this.setY(scene.getHeight()-20);
		this.nom = nom;
		this.ancetre = ancetre;
		this.setImage(image);
	}
}
