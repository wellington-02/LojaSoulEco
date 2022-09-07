module br.ufpb.souleco {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens br.ufpb.souleco to javafx.fxml;
    exports br.ufpb.souleco;
    exports br.ufpb.souleco.bd;
    opens br.ufpb.souleco.bd to javafx.fxml;
    exports br.ufpb.souleco.classes;
    opens br.ufpb.souleco.classes to javafx.fxml;
}