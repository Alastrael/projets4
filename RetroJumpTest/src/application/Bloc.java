package application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Bloc extends Rectangle{

	public Bloc(double x, double y) {
		this.setX(x);this.setY(y);
		this.setHeight(20);
		this.setWidth(20);
		this.setFill(new ImagePattern(new Image
				("Jeu2dJAVA/Brick_Block.png")));
		this.fillProperty();
	}
	
	public static Group sol(int longueur, Scene scene){
		Group sol = new Group();		
		for(int i = 0; i < longueur; i++) {
			sol.getChildren().add(new Bloc(
					20*i,scene.getHeight()-20));
		}
		return sol;
	}
}
