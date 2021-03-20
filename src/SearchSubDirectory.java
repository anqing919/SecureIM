import java.io.File;

public class SearchSubDirectory {
    static String path = "D:\\创作桌面\\Reverse\\可执行文件";  // 目录
    static String extension = ".exe";                     // 扩展名
    public static void findFile(File file, String extension) {           //测试：abstract | boolean
        if(file.isDirectory()){
            File[] list = file.listFiles();
            for (File fileInDirectory:list) {
                findFile(fileInDirectory, extension);
            }
        }else{
            if(file.getName().endsWith(extension)){
                System.out.println(file.toString().replace(path+"\\",""));
                //System.out.println(file);
            }
        }
    }

    public static void main(String[] args) {
        File f = new File(path);
        findFile(f, extension);
    }
}
