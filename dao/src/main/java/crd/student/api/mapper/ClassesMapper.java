package crd.student.api.mapper;

import crd.student.api.model.Classes;

public interface ClassesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classes
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classes
     *
     * @mbg.generated
     */
    int insert(Classes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classes
     *
     * @mbg.generated
     */
    int insertSelective(Classes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classes
     *
     * @mbg.generated
     */
    Classes selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classes
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Classes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classes
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Classes record);
}