package crd.student.api.reponse;

import crd.student.api.model.Score;

public class StudentScore extends Score {

    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
