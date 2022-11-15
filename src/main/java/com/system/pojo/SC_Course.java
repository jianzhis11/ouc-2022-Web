package com.system.pojo;

public class SC_Course {
    private String cno;
    private Short grade;
    private String cname;
    private String cpno;
    private Short ccredit;

    public SC_Course(String cno, Short grade, String cname, String cpno, Short ccredit) {
        this.cno = cno;
        this.grade = grade;
        this.cname = cname;
        this.cpno = cpno;
        this.ccredit = ccredit;
    }

    public SC_Course() {
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCpno() {
        return cpno;
    }

    public void setCpno(String cpno) {
        this.cpno = cpno;
    }

    public Short getCcredit() {
        return ccredit;
    }

    public void setCcredit(Short ccredit) {
        this.ccredit = ccredit;
    }

    @Override
    public String toString() {
        return "SC_Course{" +
                "cno='" + cno + '\'' +
                ", grade=" + grade +
                ", cname='" + cname + '\'' +
                ", cpno='" + cpno + '\'' +
                ", ccredit=" + ccredit +
                '}';
    }
}
