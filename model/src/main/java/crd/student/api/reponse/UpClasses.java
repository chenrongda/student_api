package crd.student.api.reponse;

import crd.student.api.model.Classes;

public class UpClasses {

    private Classes oldUpClasses;

    private Classes upClasses;

    public Classes getOldUpClasses() {
        return oldUpClasses;
    }

    public void setOldUpClasses(Classes oldUpClasses) {
        this.oldUpClasses = oldUpClasses;
    }

    public Classes getUpClasses() {
        return upClasses;
    }

    public void setUpClasses(Classes upClasses) {
        this.upClasses = upClasses;
    }
}
