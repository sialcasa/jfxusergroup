import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import de.saxsys.presentation.codeeditor.CodeEditor;
import de.saxsys.presentation.pageslider.SlideComponent;
import de.saxsys.presentation.pageslider.SlidePage;

public class Main extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 600, 600);

		pane.minWidthProperty().bind(scene.widthProperty());
		pane.minHeightProperty().bind(scene.heightProperty());

		stage.setScene(scene);
		stage.setTitle("Creating an Application Window");

		stage.show();
		SlideComponent slideComponent = new SlideComponent(7) {

			@Override
			public SlidePage createPage(int i) {
				switch (i) {
				case 0: {
					SlidePage slidePage = createSlideComponent();
					return slidePage;
				}
				case 1: {
					SlidePage slidePage = createSlideComponent();
					return slidePage;
				}
				case 2: {
					SlidePage slidePage = createSlideComponent();
					return slidePage;
				}
				case 3: {
					SlidePage slidePage = createSlideComponent();
					return slidePage;
				}
				case 4: {
					SlidePage slidePage = createSlideComponent();
					return slidePage;
				}
				case 5: {
					SlidePage slidePage = createSlideComponent();
					return slidePage;
				}
				case 6: {
					SlidePage slidePage = createSlideComponent();
					return slidePage;
				}
				default:
					return null;
				}
			}

			private SlidePage createSlideComponent() {
				SlidePage slidePage = new SlidePage();
//				Rectangle e = new Rectangle();
//				e.setWidth(100);
//				e.setHeight(100);
//				slidePage.getChildren().add(e);
				CodeEditor codeEditor = new CodeEditor();
				String sourceCode = "public static void main(String[] args) {\n"
						+ "\tRectangle r = RectangleBuilder.create().width(#%i).height(#%i).build();\n"
						+ "}";
				List<Property<?>> properties = new ArrayList<>();
				properties.add(new SimpleIntegerProperty(50));
				properties.add(new SimpleIntegerProperty(100));
				codeEditor.displaySourceCode(sourceCode, properties);
				slidePage.getChildren().add(codeEditor);
				return slidePage;
			}
		};
		slideComponent.minWidthProperty().bind(stage.widthProperty());
		slideComponent.minHeightProperty().bind(stage.heightProperty());
		pane.getChildren().add(slideComponent);
	}

}
