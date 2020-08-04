package kr.or.ddit.widu.util;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Util {
	
	public AnchorPane itemBoxChildren(String itemName) {
		
		AnchorPane children = new AnchorPane();
		children.setPrefSize(440, 139);
		
		ImageView itemimage = new ImageView();
		itemimage.setFitHeight(89);
		itemimage.setFitWidth(94);
		itemimage.setLayoutX(27);
		itemimage.setLayoutY(25);
		
		Label itemNameLabel = new Label(itemName);
		itemNameLabel.setPrefSize(150, 55);
		itemNameLabel.setLayoutX(137);
		itemNameLabel.setLayoutY(42);
		
		Button infoBtn = new Button("상세 보기");
		infoBtn.setPrefSize(725, 43);
		infoBtn.setLayoutX(295);
		infoBtn.setLayoutY(48);
		
		children.getChildren().addAll(itemimage, itemNameLabel, infoBtn);
		
		return children;
	}
	
	
}
