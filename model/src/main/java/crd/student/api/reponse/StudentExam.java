package crd.student.api.reponse;

import crd.student.api.model.Exam;

import java.util.List;

public class StudentExam {

    private String gradeName;

    private List<Exam>  examList;

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }
}
