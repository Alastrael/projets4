package application;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {	
	
	static boolean gauche = false, droite = false;
	
	public void start(Stage primaryStage) {
		try {
			ImageView background = new ImageView(new Image("Jeu2dJAVA/01.png"));
			Player p = new Player("Mario", new Image(
					"Jeu2dJAVA/link_right.png"));
			p.setX(10);
			Camera c = new PerspectiveCamera();	
			
			Group root = new Group();
			Scene scene = new Scene(root,600,400);
			scene.setCamera(c);
			
			p.setY(scene.getHeight()-61);
			
			background.setFitWidth(scene.getWidth()*2);
			background.setFitHeight(scene.getHeight());
			
			Group sol = Bloc.sol(30, scene);
			Group player = new Group();
			
			player.getChildren().addAll(c, p);
			
			Player.scene = scene;
			
			root.getChildren().addAll(
					background,
					sol,
					player
					);

			AnimationTimer a = new AnimationTimer() {
				@Override
				public void handle(long now) {
					if(droite) {
						p.setX(p.getX()+5);
						c.setTranslateX(c.getTranslateX()+5);
					}
					if(gauche) {
						p.setX(p.getX()-5);
						c.setTranslateX(c.getTranslateX()-5);
					}
				}
			};
						
			scene.setOnKeyPressed(e->{
				switch(e.getCode()) {
				case LEFT : 
					gauche = true;
					break;
				case RIGHT : 
					droite = true;
					break;
				default:
					break;
				}
			});
			scene.setOnKeyReleased(e->{
				switch(e.getCode()) {
				case LEFT : 
					gauche = false;
					break;
				case RIGHT : 
					droite = false;
					break;
				default:
					break;
				}
			});
			
			a.start();
			primaryStage.setScene(scene);
			primaryStage.setResizable(true);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
