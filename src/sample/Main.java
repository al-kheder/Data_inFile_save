package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.out;

public class Main extends Application {

    public static void main(String[] args)

    //Start my my program
    {
        launch(args);
    }


    @Override
    public void init() {
        out.println("init method has been called ");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //  Parent root = FXMLLoader.load(getClass().getResource("DataSave.fxml"));
        primaryStage.setTitle("Save Info ");
        //Label
        Label studentInfo = new Label("Student Info ");
        Label firstName = new Label("First name :");
        Label lastName = new Label("Last name : ");
        Label email = new Label("E-Mail : ");
        Label phonenumber = new Label("Phone : ");
        Label checkPhon = new Label();
        // Text Field
        TextField textFirstName = new TextField();
        TextField textLastName = new TextField();
        TextField textEmail = new TextField();
        TextField textPhone = new TextField();
        // when the text field empty
        textFirstName.setPromptText("Enter your First name");
        textLastName.setPromptText("Enter your last name");
        textEmail.setPromptText("example@E-mail.com");
        textPhone.setPromptText("+49......");

        //mous focuse
        textFirstName.setFocusTraversable(false);
        textLastName.setFocusTraversable(false);
        textEmail.setFocusTraversable(false);
        textPhone.setFocusTraversable(false);


        //Button
        Button save = new Button("Save");
        Button exit = new Button("Exit");


        //location in the stage
        //label
        studentInfo.setTranslateX(225);
        studentInfo.setTranslateY(50);

        firstName.setTranslateX(100);
        firstName.setTranslateY(100);

        lastName.setTranslateX(100);
        lastName.setTranslateY(140);

        email.setTranslateX(139);
        email.setTranslateY(180);

        phonenumber.setTranslateX(139);
        phonenumber.setTranslateY(220);

        //textField
        textFirstName.setTranslateX(225);
        textFirstName.setTranslateY(100);

        textLastName.setTranslateX(225);
        textLastName.setTranslateY(140);

        textEmail.setTranslateX(225);
        textEmail.setTranslateY(180);

        textPhone.setTranslateX(225);
        textPhone.setTranslateY(220);
        checkPhon.setTranslateX(225);
        checkPhon.setTranslateY(250);


        //button
        save.setTranslateX(170);
        save.setTranslateY(290);

        exit.setTranslateX(250);
        exit.setTranslateY(290);


        //font info
        //label
        studentInfo.setFont(new Font("Cambria", 34));

        firstName.setFont(new Font("Arial", 22));

        lastName.setFont(new Font("Arial", 22));

        email.setFont(new Font("Arial", 22));

        phonenumber.setFont(new Font("Arial", 22));
        checkPhon.setFont(new Font("Arial", 22));
        checkPhon.setTextFill(Color.RED);
        //Text Field

        //button
        save.setFont(new Font("Arial", 18));
        exit.setFont(new Font("Arial", 18));

        //color info
        studentInfo.setTextFill(Color.BLUEVIOLET);
        // creat an object to make it the Root node in the window
        Group root = new Group();

        //add the childeren to the RootNode
        //label
        root.getChildren().add(studentInfo);
        root.getChildren().add(firstName);
        root.getChildren().add(lastName);
        root.getChildren().add(email);
        root.getChildren().add(phonenumber);
        root.getChildren().add(checkPhon);
        //textfild
        root.getChildren().add(textFirstName);
        root.getChildren().add(textLastName);
        root.getChildren().add(textEmail);
        root.getChildren().add(textPhone);

        //button
        root.getChildren().add(save);
        root.getChildren().add(exit);


        Scene scene = new Scene(root, 600, 500);

        primaryStage.setScene(scene);
        primaryStage.show();

        //event
        firstName.setOnMouseEntered((mouseEvent -> {
            firstName.setScaleX(1.2);
        }));
        firstName.setOnMouseExited(mouseEvent -> {
            firstName.setScaleX(1);
        });

        lastName.setOnMouseEntered((mouseEvent -> {
            lastName.setScaleX(1.2);
        }));
        lastName.setOnMouseExited(mouseEvent -> {
            lastName.setScaleX(1);
        });

        email.setOnMouseEntered((mouseEvent -> {
            email.setScaleX(1.2);
        }));
        email.setOnMouseExited(mouseEvent -> {
            email.setScaleX(1);
        });

        phonenumber.setOnMouseEntered((mouseEvent -> {
            phonenumber.setScaleX(1.2);
        }));
        phonenumber.setOnMouseExited(mouseEvent -> {
            phonenumber.setScaleX(1);
        });

        textPhone.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (textPhone.getText().isEmpty()) {
                    checkPhon.setText("Phone Filed is Empty ");
                } else {
                    checkPhon.setText("    ");
                }
            }
        });

        DropShadow shadow = new DropShadow(10, Color.CYAN);

        save.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            save.setEffect(shadow);
        });
        save.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            save.setEffect(null);
        });
        //save the info in a file.txt
        save.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {

            try {
                PrintWriter w = new PrintWriter(textFirstName.getText() + " " + textLastName.getText() + ".txt");
                w.println("Vorname : " + textFirstName.getText());
                w.println("Nachname: " + textLastName.getText());
                w.println("E-mail addresse: " + textEmail.getText());
                w.println("Tel: " + textPhone.getText());
                w.println("*********************************************");
                w.close();
                JOptionPane.showMessageDialog(null, "Information saved");
            } catch (Exception ex) {
                out.println("the text cannot be saved" + ex.getMessage());

            }


        });

        exit.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            exit.setEffect(shadow);
        });
        exit.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            exit.setEffect(null);
        });
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            System.exit(0);
        });


        //when save clicked it will print +1 in console ;  just for test aim
        AtomicInteger x = new AtomicInteger();
        save.setOnAction((ActionEvent e) -> {
            //to do
            x.addAndGet(1);
            out.println("save button is clicked " + x);
        });


    }//start

    @Override
    public void stop() {
        out.println("stop method has been called >>");
    }


}
