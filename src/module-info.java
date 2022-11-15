module javafx {
	requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
	
	opens views to javafx.graphics, javafx.fxml;
	opens controllers to javafx.fxml;
}
