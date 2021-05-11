module ni.edu.uni.fcys.programacion2.depreciacionfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ni.edu.uni.fcys.programacion2.depreciacionfx to javafx.fxml;
    exports ni.edu.uni.fcys.programacion2.depreciacionfx;
    exports ni.edu.uni.fcys.programacion2.depreciacionfx.controllers;
}
