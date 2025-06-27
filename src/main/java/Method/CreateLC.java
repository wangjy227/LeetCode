package Method;

import java.io.FileWriter;
import java.io.IOException;
public class CreateLC {
    private static final String FILEPATH = "D:\\Desktop\\i-java\\LeetCode\\src\\main\\java\\LeetCode\\LC.java";
    public static void main (String [] args) {
// 定义要生成的 Java 代码内容
        String javaCode =
                "package LeetCode;\n\n\n\n" +
                "public class LC {\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\tSolution solution = new Solution();\n" +
                "\t\tSystem.out.println(solution);\n" +
                "\t}\n" +
                "}";
        // 指定文件生成路径
        String filePath = FILEPATH;

        // 确保文件后缀为.java
        if (!filePath.endsWith (".java")) {
            filePath += ".java";
            System.out.println ("已自动添加.java 后缀，最终路径：" + filePath);
        }
        try {
            // 创建文件并写入内容
            FileWriter writer = new FileWriter (filePath);
            writer.write (javaCode);
            writer.close ();
            System.out.println ("文件生成成功：" + filePath);
        } catch (IOException e) {
            System.out.println ("文件生成失败：" + e.getMessage ());
            e.printStackTrace ();
        }
    }
}