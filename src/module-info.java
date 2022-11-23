module javafx {
	requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.swt;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires java.base;
	
	opens views to javafx.graphics, javafx.fxml;
	opens controllers to javafx.fxml;
}
