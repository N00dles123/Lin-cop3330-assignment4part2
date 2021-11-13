/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jason Lin
 */
module ucf.assignments {
    requires javafx.controls;
    requires javafx.fxml;


    opens ucf.assignments.lincop3330assignment4 to javafx.fxml;
    opens ucf.assignments to javafx.base;
    exports ucf.assignments.lincop3330assignment4;
}