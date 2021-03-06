package crd.student.api.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Exam {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam.exam_name
     *
     * @mbg.generated
     */
    private String examName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam.exam_time
     *
     * @mbg.generated
     */
    private Date examTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam.classes_id
     *
     * @mbg.generated
     */
    private Integer classesId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam.math_avg_score
     *
     * @mbg.generated
     */
    private Float mathAvgScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam.chinese_avg_score
     *
     * @mbg.generated
     */
    private Float chineseAvgScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column exam.english_avg_score
     *
     * @mbg.generated
     */
    private Float englishAvgScore;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam.id
     *
     * @return the value of exam.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam.id
     *
     * @param id the value for exam.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam.exam_name
     *
     * @return the value of exam.exam_name
     *
     * @mbg.generated
     */
    public String getExamName() {
        return examName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam.exam_name
     *
     * @param examName the value for exam.exam_name
     *
     * @mbg.generated
     */
    public void setExamName(String examName) {
        this.examName = examName == null ? null : examName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam.exam_time
     *
     * @return the value of exam.exam_time
     *
     * @mbg.generated
     */
    public Date getExamTime() {
        return examTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam.exam_time
     *
     * @param examTime the value for exam.exam_time
     *
     * @mbg.generated
     */
    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam.classes_id
     *
     * @return the value of exam.classes_id
     *
     * @mbg.generated
     */
    public Integer getClassesId() {
        return classesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam.classes_id
     *
     * @param classesId the value for exam.classes_id
     *
     * @mbg.generated
     */
    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam.math_avg_score
     *
     * @return the value of exam.math_avg_score
     *
     * @mbg.generated
     */
    public Float getMathAvgScore() {
        return mathAvgScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam.math_avg_score
     *
     * @param mathAvgScore the value for exam.math_avg_score
     *
     * @mbg.generated
     */
    public void setMathAvgScore(Float mathAvgScore) {
        this.mathAvgScore = mathAvgScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam.chinese_avg_score
     *
     * @return the value of exam.chinese_avg_score
     *
     * @mbg.generated
     */
    public Float getChineseAvgScore() {
        return chineseAvgScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam.chinese_avg_score
     *
     * @param chineseAvgScore the value for exam.chinese_avg_score
     *
     * @mbg.generated
     */
    public void setChineseAvgScore(Float chineseAvgScore) {
        this.chineseAvgScore = chineseAvgScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column exam.english_avg_score
     *
     * @return the value of exam.english_avg_score
     *
     * @mbg.generated
     */
    public Float getEnglishAvgScore() {
        return englishAvgScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column exam.english_avg_score
     *
     * @param englishAvgScore the value for exam.english_avg_score
     *
     * @mbg.generated
     */
    public void setEnglishAvgScore(Float englishAvgScore) {
        this.englishAvgScore = englishAvgScore;
    }
}