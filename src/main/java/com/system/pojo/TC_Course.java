package com.system.pojo;

public class TC_Course {
    private String tno;
    private String cname;
    private String cpno;
    private Short ccredit;

    public TC_Course(String tno, String cname, String cpno, Short ccredit) {
        this.tno = tno;
        this.cname = cname;
        this.cpno = cpno;
        this.ccredit = ccredit;
    }

    public TC_Course() {
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
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
        return "TC_Course{" +
                "tno='" + tno + '\'' +
                ", cname='" + cname + '\'' +
                ", cpno='" + cpno + '\'' +
                ", ccredit=" + ccredit +
                '}';
    }
}
