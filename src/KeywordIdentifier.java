import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeywordIdentifier {
    Map<String,Integer> statistics = new TreeMap<String,Integer>();
    String[] kl={"abstract", "class", "extends", "implements", "null", "strictfp", "true", "assert",
            "const", "false", "import", "package", "super", "try", "boolean", "continue", "final", "instanceof",
            "private", "switch", "void", "break", "default", "finally", "int", "protected", "synchronized",
            "volatile", "byte", "do", "float", "interface", "public", "this", "while", "case", "double", "for",
            "long", "return", "throw", "catch", "else", "goto", "native", "short", "throws", "char", "enum", "if",
            "new", "static", "transient"};
    {
        for(String k:kl){
            statistics.put(k,0);
        }
    }
    public void CountNumberOfEveryLine(String line){
        for(String k:kl) {
            Matcher m = Pattern.compile(k).matcher(line);
            Matcher n = Pattern.compile("//.*" + k).matcher(line);
            while(m.find()&&!n.find()){
                if(statistics.get(k)!=null)
                    statistics.put(k,statistics.get(k)+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        KeywordIdentifier ki = new KeywordIdentifier();
        BufferedReader in = new BufferedReader(new FileReader("D:\\Java\\java编程文件\\src\\SearchSubDirectory.java"));
        String s;
        while((s=in.readLine())!=null){
            ki.CountNumberOfEveryLine(s);
        }
        in.close();
        System.out.print(ki.statistics);
    }
}
