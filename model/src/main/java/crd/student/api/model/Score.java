package crd.student.api.model;

public class Score {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column score.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column score.exam_id
     *
     * @mbg.generated
     */
    private Integer examId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column score.student_id
     *
     * @mbg.generated
     */
    private Integer studentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column score.math_score
     *
     * @mbg.generated
     */
    private Float mathScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column score.chinese_score
     *
     * @mbg.generated
     */
    private Float chineseScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column score.english_score
     *
     * @mbg.generated
     */
    private Float englishScore;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column score.id
     *
     * @return the value of score.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column score.id
     *
     * @param id the value for score.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column score.exam_id
     *
     * @return the value of score.exam_id
     *
     * @mbg.generated
     */
    public Integer getExamId() {
        return examId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column score.exam_id
     *
     * @param examId the value for score.exam_id
     *
     * @mbg.generated
     */
    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column score.student_id
     *
     * @return the value of score.student_id
     *
     * @mbg.generated
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column score.student_id
     *
     * @param studentId the value for score.student_id
     *
     * @mbg.generated
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column score.math_score
     *
     * @return the value of score.math_score
     *
     * @mbg.generated
     */
    public Float getMathScore() {
        return mathScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column score.math_score
     *
     * @param mathScore the value for score.math_score
     *
     * @mbg.generated
     */
    public void setMathScore(Float mathScore) {
        this.mathScore = mathScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column score.chinese_score
     *
     * @return the value of score.chinese_score
     *
     * @mbg.generated
     */
    public Float getChineseScore() {
        return chineseScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column score.chinese_score
     *
     * @param chineseScore the value for score.chinese_score
     *
     * @mbg.generated
     */
    public void setChineseScore(Float chineseScore) {
        this.chineseScore = chineseScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column score.english_score
     *
     * @return the value of score.english_score
     *
     * @mbg.generated
     */
    public Float getEnglishScore() {
        return englishScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column score.english_score
     *
     * @param englishScore the value for score.english_score
     *
     * @mbg.generated
     */
    public void setEnglishScore(Float englishScore) {
        this.englishScore = englishScore;
    }
}