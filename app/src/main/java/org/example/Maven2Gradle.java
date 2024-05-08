package org.example;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Maven2Gradle {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception("参数错误");
        }
        String path = args[0];
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File(path));
        Element root = doc.getRootElement();
        StringBuilder builder = new StringBuilder();
        root.elements().forEach(ele -> {
            String groupId = ele.attributeValue("groupId");
            String artifactId = ele.attributeValue("artifactId");
            String version = ele.attributeValue("groupId");
            builder.append("implementation(\"")
                    .append(groupId).append(":")
                    .append(artifactId).append(":")
                    .append(version)
                    .append("\")")
                    .append("\r\n");
        });
        OutputStream os = new FileOutputStream("out.txt");
        os.write(builder.toString().getBytes());
        os.flush();
        os.close();
    }
}
