package com.example.familydb;

import java.io.Serializable;

public class Child implements Serializable {

    int id;
    String nFather;
    String nMother;
    String nChild;
    String childAge;
    String mobile;
    String caseR;

    public Child(int id, String nFather, String nMother, String nChild, String childAge, String mobile, String caseR) {
        this.id = id;
        this.nFather = nFather;
        this.nMother = nMother;
        this.nChild = nChild;
        this.childAge = childAge;
        this.mobile = mobile;
        this.caseR = caseR;
    }

    public Child(String nFather, String nMother, String nChild, String childAge, String mobile, String caseR) {
        this.nFather = nFather;
        this.nMother = nMother;
        this.nChild = nChild;
        this.childAge = childAge;
        this.mobile = mobile;
        this.caseR = caseR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnFather() {
        return nFather;
    }

    public void setnFather(String nFather) {
        this.nFather = nFather;
    }

    public String getnMother() {
        return nMother;
    }

    public void setnMother(String nMother) {
        this.nMother = nMother;
    }

    public String getnChild() {
        return nChild;
    }

    public void setnChild(String nChild) {
        this.nChild = nChild;
    }

    public String getChildAge() {
        return childAge;
    }

    public void setChildAge(String childAge) {
        this.childAge = childAge;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCaseR() {
        return caseR;
    }

    public void setCaseR(String caseR) {
        this.caseR = caseR;
    }
}
