package com.system.pojo;

import java.util.ArrayList;
import java.util.List;

public class TeacherExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public TeacherExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTnoIsNull() {
            addCriterion("Tno is null");
            return (Criteria) this;
        }

        public Criteria andTnoIsNotNull() {
            addCriterion("Tno is not null");
            return (Criteria) this;
        }

        public Criteria andTnoEqualTo(String value) {
            addCriterion("Tno =", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotEqualTo(String value) {
            addCriterion("Tno <>", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThan(String value) {
            addCriterion("Tno >", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThanOrEqualTo(String value) {
            addCriterion("Tno >=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThan(String value) {
            addCriterion("Tno <", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThanOrEqualTo(String value) {
            addCriterion("Tno <=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLike(String value) {
            addCriterion("Tno like", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotLike(String value) {
            addCriterion("Tno not like", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoIn(List<String> values) {
            addCriterion("Tno in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotIn(List<String> values) {
            addCriterion("Tno not in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoBetween(String value1, String value2) {
            addCriterion("Tno between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotBetween(String value1, String value2) {
            addCriterion("Tno not between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andTnameIsNull() {
            addCriterion("Tname is null");
            return (Criteria) this;
        }

        public Criteria andTnameIsNotNull() {
            addCriterion("Tname is not null");
            return (Criteria) this;
        }

        public Criteria andTnameEqualTo(String value) {
            addCriterion("Tname =", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotEqualTo(String value) {
            addCriterion("Tname <>", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThan(String value) {
            addCriterion("Tname >", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThanOrEqualTo(String value) {
            addCriterion("Tname >=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThan(String value) {
            addCriterion("Tname <", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThanOrEqualTo(String value) {
            addCriterion("Tname <=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLike(String value) {
            addCriterion("Tname like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotLike(String value) {
            addCriterion("Tname not like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameIn(List<String> values) {
            addCriterion("Tname in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotIn(List<String> values) {
            addCriterion("Tname not in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameBetween(String value1, String value2) {
            addCriterion("Tname between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotBetween(String value1, String value2) {
            addCriterion("Tname not between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTsexIsNull() {
            addCriterion("Tsex is null");
            return (Criteria) this;
        }

        public Criteria andTsexIsNotNull() {
            addCriterion("Tsex is not null");
            return (Criteria) this;
        }

        public Criteria andTsexEqualTo(String value) {
            addCriterion("Tsex =", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexNotEqualTo(String value) {
            addCriterion("Tsex <>", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexGreaterThan(String value) {
            addCriterion("Tsex >", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexGreaterThanOrEqualTo(String value) {
            addCriterion("Tsex >=", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexLessThan(String value) {
            addCriterion("Tsex <", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexLessThanOrEqualTo(String value) {
            addCriterion("Tsex <=", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexLike(String value) {
            addCriterion("Tsex like", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexNotLike(String value) {
            addCriterion("Tsex not like", value, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexIn(List<String> values) {
            addCriterion("Tsex in", values, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexNotIn(List<String> values) {
            addCriterion("Tsex not in", values, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexBetween(String value1, String value2) {
            addCriterion("Tsex between", value1, value2, "tsex");
            return (Criteria) this;
        }

        public Criteria andTsexNotBetween(String value1, String value2) {
            addCriterion("Tsex not between", value1, value2, "tsex");
            return (Criteria) this;
        }

        public Criteria andTageIsNull() {
            addCriterion("Tage is null");
            return (Criteria) this;
        }

        public Criteria andTageIsNotNull() {
            addCriterion("Tage is not null");
            return (Criteria) this;
        }

        public Criteria andTageEqualTo(Short value) {
            addCriterion("Tage =", value, "tage");
            return (Criteria) this;
        }

        public Criteria andTageNotEqualTo(Short value) {
            addCriterion("Tage <>", value, "tage");
            return (Criteria) this;
        }

        public Criteria andTageGreaterThan(Short value) {
            addCriterion("Tage >", value, "tage");
            return (Criteria) this;
        }

        public Criteria andTageGreaterThanOrEqualTo(Short value) {
            addCriterion("Tage >=", value, "tage");
            return (Criteria) this;
        }

        public Criteria andTageLessThan(Short value) {
            addCriterion("Tage <", value, "tage");
            return (Criteria) this;
        }

        public Criteria andTageLessThanOrEqualTo(Short value) {
            addCriterion("Tage <=", value, "tage");
            return (Criteria) this;
        }

        public Criteria andTageIn(List<Short> values) {
            addCriterion("Tage in", values, "tage");
            return (Criteria) this;
        }

        public Criteria andTageNotIn(List<Short> values) {
            addCriterion("Tage not in", values, "tage");
            return (Criteria) this;
        }

        public Criteria andTageBetween(Short value1, Short value2) {
            addCriterion("Tage between", value1, value2, "tage");
            return (Criteria) this;
        }

        public Criteria andTageNotBetween(Short value1, Short value2) {
            addCriterion("Tage not between", value1, value2, "tage");
            return (Criteria) this;
        }

        public Criteria andTdeptIsNull() {
            addCriterion("Tdept is null");
            return (Criteria) this;
        }

        public Criteria andTdeptIsNotNull() {
            addCriterion("Tdept is not null");
            return (Criteria) this;
        }

        public Criteria andTdeptEqualTo(String value) {
            addCriterion("Tdept =", value, "tdept");
            return (Criteria) this;
        }

        public Criteria andTdeptNotEqualTo(String value) {
            addCriterion("Tdept <>", value, "tdept");
            return (Criteria) this;
        }

        public Criteria andTdeptGreaterThan(String value) {
            addCriterion("Tdept >", value, "tdept");
            return (Criteria) this;
        }

        public Criteria andTdeptGreaterThanOrEqualTo(String value) {
            addCriterion("Tdept >=", value, "tdept");
            return (Criteria) this;
        }

        public Criteria andTdeptLessThan(String value) {
            addCriterion("Tdept <", value, "tdept");
            return (Criteria) this;
        }

        public Criteria andTdeptLessThanOrEqualTo(String value) {
            addCriterion("Tdept <=", value, "tdept");
            return (Criteria) this;
        }

        public Criteria andTdeptLike(String value) {
            addCriterion("Tdept like", value, "tdept");
            return (Criteria) this;
        }

        public Criteria andTdeptNotLike(String value) {
            addCriterion("Tdept not like", value, "tdept");
            return (Criteria) this;
        }

        public Criteria andTdeptIn(List<String> values) {
            addCriterion("Tdept in", values, "tdept");
            return (Criteria) this;
        }

        public Criteria andTdeptNotIn(List<String> values) {
            addCriterion("Tdept not in", values, "tdept");
            return (Criteria) this;
        }

        public Criteria andTdeptBetween(String value1, String value2) {
            addCriterion("Tdept between", value1, value2, "tdept");
            return (Criteria) this;
        }

        public Criteria andTdeptNotBetween(String value1, String value2) {
            addCriterion("Tdept not between", value1, value2, "tdept");
            return (Criteria) this;
        }

        public Criteria andTsalaryIsNull() {
            addCriterion("Tsalary is null");
            return (Criteria) this;
        }

        public Criteria andTsalaryIsNotNull() {
            addCriterion("Tsalary is not null");
            return (Criteria) this;
        }

        public Criteria andTsalaryEqualTo(Integer value) {
            addCriterion("Tsalary =", value, "tsalary");
            return (Criteria) this;
        }

        public Criteria andTsalaryNotEqualTo(Integer value) {
            addCriterion("Tsalary <>", value, "tsalary");
            return (Criteria) this;
        }

        public Criteria andTsalaryGreaterThan(Integer value) {
            addCriterion("Tsalary >", value, "tsalary");
            return (Criteria) this;
        }

        public Criteria andTsalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("Tsalary >=", value, "tsalary");
            return (Criteria) this;
        }

        public Criteria andTsalaryLessThan(Integer value) {
            addCriterion("Tsalary <", value, "tsalary");
            return (Criteria) this;
        }

        public Criteria andTsalaryLessThanOrEqualTo(Integer value) {
            addCriterion("Tsalary <=", value, "tsalary");
            return (Criteria) this;
        }

        public Criteria andTsalaryIn(List<Integer> values) {
            addCriterion("Tsalary in", values, "tsalary");
            return (Criteria) this;
        }

        public Criteria andTsalaryNotIn(List<Integer> values) {
            addCriterion("Tsalary not in", values, "tsalary");
            return (Criteria) this;
        }

        public Criteria andTsalaryBetween(Integer value1, Integer value2) {
            addCriterion("Tsalary between", value1, value2, "tsalary");
            return (Criteria) this;
        }

        public Criteria andTsalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("Tsalary not between", value1, value2, "tsalary");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table teacher
     *
     * @mbg.generated do_not_delete_during_merge Sun Nov 06 18:52:56 CST 2022
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table teacher
     *
     * @mbg.generated Sun Nov 06 18:52:56 CST 2022
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}