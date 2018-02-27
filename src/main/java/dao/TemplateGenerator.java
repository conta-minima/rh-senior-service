package dao;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.*;

public class TemplateGenerator {

        private String template;
        private Object dataProvider;

        public void setTemplateAsString(String template){
            this.template = template;
        }

        public void setTemplate(String template) throws IOException {
            this.setTemplate(this.getClass().getResourceAsStream(template));
        }

        public void setTemplate(InputStream template) throws IOException{
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(template));

            String line;
            while((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }

            br.close();
            this.template = sb.toString();
        }

        public void setDataProvider(Object provider){
            this.dataProvider = provider;
        }

        public String generate() throws IOException{
            MustacheFactory mf = new DefaultMustacheFactory();
            Mustache mustache = mf.compile(new StringReader(template), "template");
            StringWriter sw = new StringWriter();
            mustache.execute( sw, this.dataProvider ).flush();
            return sw.toString();
        }
}
