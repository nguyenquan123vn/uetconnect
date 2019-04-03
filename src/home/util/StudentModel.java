package home.util;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StudentModel {

    private SimpleIntegerProperty creditsNum;
    private SimpleStringProperty subjectId;
    private SimpleStringProperty subjectName;
    private SimpleStringProperty lecturerName;



    public StudentModel(String subjectId, String subjectName,Integer creditsNum, String lecturerName) {
        this.subjectId = new SimpleStringProperty(subjectId);
        this.subjectName= new SimpleStringProperty(subjectName);
        this.creditsNum = new SimpleIntegerProperty(creditsNum);
        this.lecturerName = new SimpleStringProperty(lecturerName);
    }

    public int getCreditsNum() {
        return creditsNum.get();
    }

    public String getSubjectName() {
        return subjectName.get();
    }

    public SimpleStringProperty subjectNameProperty() {
        return subjectName;
    }

    public String getSubjectId() {
        return subjectId.get();
    }

    public SimpleStringProperty subjectIdProperty() {
        return subjectId;
    }

    public SimpleIntegerProperty creditsNumProperty() {
        return creditsNum;
    }

    public String getLecturerName() {
        return lecturerName.get();
    }

    public SimpleStringProperty lecturerNameProperty() {
        return lecturerName;
    }
}
