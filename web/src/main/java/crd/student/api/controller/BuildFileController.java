package crd.student.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
@RequestMapping(value = "buildText")
public class BuildFileController {


    @RequestMapping(value = "/index")
    @ResponseBody
    public void index() {
        String name = "Score";
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        String udir = System.getProperty("user.dir");
        File filePath = new File(udir);
        String basePath = filePath.getPath();
        buildController(basePath,name);
        buildService(basePath,name);
        buildDao(basePath,name);
    }

    /**
     * 快速创建控制器
     */
    public void buildController(String basePath,String name){
        //service
        String Service = name + "Service";
        //controller
        String controllers =  name + "Controller";
        String path =  basePath+"\\web\\src\\main\\java\\crd\\student\\api\\controller\\"+controllers;
        createFile(path,"package crd.student.api.controller;\n\nimport crd.student.api.service.I"+Service+";" +
                "\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.stereotype.Controller;\n" +
                "import org.springframework.web.bind.annotation.RequestMapping;\n\n@Controller\n@RequestMapping(value=\""+name.toLowerCase()+"\")\npublic class "+controllers+"{\n\n" +
                "   @Autowired\n    private I"+Service+" i"+Service+";\n\n}");
    }

    /**
     * 快速创建service
     * @param basePath
     * @param name
     */
    public void buildService(String basePath,String name){
        //Iservice
        String iService = "I" + name + "Service";
        String path =  basePath+"\\service\\src\\main\\java\\crd\\student\\api\\service\\"+iService;
        createFile(path,"package crd.student.api.service;\n\npublic interface "+iService+"{\n\n}");
        //service
        String service = name + "Service";
        String servicepath =  basePath+"\\service\\src\\main\\java\\crd\\student\\api\\service\\impl\\"+service;
        createFile(servicepath,"package crd.student.api.service.impl;\n\nimport org.springframework.stereotype.Service;\nimport crd.student.api.service."+iService+";" +
                "\n\n@Service\npublic class "+service+" implements "+iService+"{\n\n}");
    }


    public void buildDao(String basePath,String name){
        //dao
        String dao = name + "Dao";
        String path =  basePath+"\\dao\\src\\main\\java\\crd\\student\\api\\dao\\"+dao;
        createFile(path,"package crd.student.api.dao;\n\nimport crd.student.api.mapper."+name+"Mapper;\n\npublic interface "+dao+" extends "+name+"Mapper {\n\n}");
    }

    /**
     * 创建文件
     *
     * @param fileName    文件名称
     * @param filecontent 文件内容
     * @return 是否创建成功，成功则返回true
     */
    public static boolean createFile(String fileName, String filecontent) {
        //文件路径+名称
        String filenameTemp;
        Boolean bool = false;
        filenameTemp = fileName + ".java";//文件路径+名称+文件类型
        File file = new File(filenameTemp);
        try {
            //如果文件不存在，则创建新的文件
            if (!file.exists()) {
                file.createNewFile();
                bool = true;
                System.out.println("success create file,the file is " + filenameTemp);
                //创建文件成功后，写入内容到文件里
                writeFileContent(filenameTemp, filecontent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bool;
    }

    /**
     * 向文件中写入内容
     *
     * @param filepath 文件路径与名称
     * @param newstr   写入的内容
     * @return
     * @throws IOException
     */
    public static boolean writeFileContent(String filepath, String newstr) throws IOException {
        Boolean bool = false;
        String filein = newstr + "\r\n";//新写入的行，换行
        String temp = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();

            //文件原有内容
            for (int i = 0; (temp = br.readLine()) != null; i++) {
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            //不要忘记关闭
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }


}