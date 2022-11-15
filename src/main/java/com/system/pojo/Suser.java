package com.system.pojo;

public class Suser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suser.username
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suser.password
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suser.type
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    private String type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suser.username
     *
     * @return the value of suser.username
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suser.username
     *
     * @param username the value for suser.username
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suser.password
     *
     * @return the value of suser.password
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suser.password
     *
     * @param password the value for suser.password
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suser.type
     *
     * @return the value of suser.type
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suser.type
     *
     * @param type the value for suser.type
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Suser(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public Suser() {
    }

    @Override
    public String toString() {
        return "Suser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}