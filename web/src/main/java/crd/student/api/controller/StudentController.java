package crd.student.api.controller;

import crd.student.api.common.DateUtils;
import crd.student.api.common.DefaultValue;
import crd.student.api.model.Classes;
import crd.student.api.model.Student;
import crd.student.api.reponse.Result;
import crd.student.api.service.IStudentService;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    /**
     * 获取班级学生
     * @param classes
     * @return
     */
    @RequestMapping(value = "/getStudentList")
    @ResponseBody
    public List<Student> getStudentList(Classes classes){
        return iStudentService.getStudentList(classes);
    }

    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    @ResponseBody
    public Result addStudent(@RequestBody Student student){
        if(student.getName() != null){
            return iStudentService.addStudent(student);
        }else{
            return new Result(DefaultValue.REPONSE_FAIL_CODE,"请填写学生姓名");
        }
    }

    /**
     * 删除学生，实际上是删除学生所在的班级
     * @param grade
     * @param student
     * @return
     */
    @RequestMapping(value = "/delStudent",method = RequestMethod.POST)
    @ResponseBody
    public Result delStudent(@Param(value="grade")Integer grade, @RequestBody Student student){
        return iStudentService.delStudent(student,grade);
    }


    @RequestMapping(value = "/exportStudent")
    @ResponseBody
    public void exportStudent(HttpServletResponse response,Classes classes){
        List<Student> studentList = iStudentService.getStudentList(classes);
        try{
            String sheetName=classes.getClassName()+"学生名录";
            // 声明一个工作薄（生成一个excel）
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 生成一个表格（sheet）
            HSSFSheet sheet = workbook.createSheet();
            workbook.setSheetName(0, sheetName);
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth((short) 10);
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);//左右居中
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//上下居中
            HSSFRow row = sheet.createRow(0);
            row.setHeight((short)  (25 * 20));
            row.createCell(0).setCellValue(sheetName);
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));
            row.getCell(0).setCellStyle(cellStyle);
            //栏目
            row = sheet.createRow(1);
            String[] header = {"序号", "姓名", "性别", "出生日期", "民族", "家庭现住址", "家长姓名","联系电话","入学时间","户籍所在地"};
            buildRow(row,header);
            Integer i = 0;
            for(Student student:studentList){
                i++;
                row = sheet.createRow(1+i);
                String sex = student.getSex().equals(1)?"男":"女";
                String[] cellText = {i.toString(), student.getName(),sex, DateUtils.getNeededDateStyle(student.getBirth(),"yyyyMMdd"),
                        student.getNation(),student.getAddress(),student.getParentName(),student.getPhone(),
                        DateUtils.getNeededDateStyle(student.getStartSchool(),"yyyyMMdd"),student.getHukou()};
                buildRow(row,cellText);
            }
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + java.net.URLEncoder.encode(classes.getClassName()+"学生名录.xls", "utf-8"));//默认Excel名称
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 生成一行的数据
     *
     * @param row     行
     * @param rowText 一行数组
     */
    private void buildRow(HSSFRow row, String[] rowText) {
        for (int i = 0; i < rowText.length; i++) {
            HSSFCell cell = row.createCell(i);
            if (rowText[i] != null) {
                HSSFRichTextString text = new HSSFRichTextString(rowText[i]);
                cell.setCellValue(text);
            }
        }
    }


}
