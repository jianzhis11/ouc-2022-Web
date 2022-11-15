package com.system.pojo;

public class Student {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.Sno
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    private String sno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.Sname
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    private String sname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.Ssex
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    private String ssex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.Sage
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    private Short sage;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.Sdept
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    private String sdept;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.Sclass
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    private String sclass;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.Sno
     *
     * @return the value of student.Sno
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public String getSno() {
        return sno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.Sno
     *
     * @param sno the value for student.Sno
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.Sname
     *
     * @return the value of student.Sname
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public String getSname() {
        return sname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.Sname
     *
     * @param sname the value for student.Sname
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.Ssex
     *
     * @return the value of student.Ssex
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public String getSsex() {
        return ssex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.Ssex
     *
     * @param ssex the value for student.Ssex
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void setSsex(String ssex) {
        this.ssex = ssex == null ? null : ssex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.Sage
     *
     * @return the value of student.Sage
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public Short getSage() {
        return sage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.Sage
     *
     * @param sage the value for student.Sage
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void setSage(Short sage) {
        this.sage = sage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.Sdept
     *
     * @return the value of student.Sdept
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public String getSdept() {
        return sdept;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.Sdept
     *
     * @param sdept the value for student.Sdept
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void setSdept(String sdept) {
        this.sdept = sdept == null ? null : sdept.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.Sclass
     *
     * @return the value of student.Sclass
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public String getSclass() {
        return sclass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.Sclass
     *
     * @param sclass the value for student.Sclass
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void setSclass(String sclass) {
        this.sclass = sclass == null ? null : sclass.trim();
    }

    public Student(String sno, String sname, String ssex, Short sage, String sdept, String sclass) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.sdept = sdept;
        this.sclass = sclass;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", sdept='" + sdept + '\'' +
                ", sclass='" + sclass + '\'' +
                '}';
    }
}