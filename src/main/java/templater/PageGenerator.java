package templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Created by alterG on 15.07.2017.
 */
public class PageGenerator {
    private final String htmlDir = "templates";
    private static PageGenerator instance;
    private final Configuration cfg;

    public static PageGenerator getInstance() {
        if (instance == null) {
            instance = new PageGenerator();
        }
        return instance;
    }

    public String getPage(String fileName, Map<String, Object> data) {
        Writer writer = new StringWriter();
        try {
            Template template = cfg.getTemplate(htmlDir + File.separator + fileName);
            template.process(data, writer);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    private PageGenerator() {
        this.cfg = new Configuration();
    }
}
