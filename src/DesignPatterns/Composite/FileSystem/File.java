package DesignPatterns.Composite.FileSystem;

public class File implements FileSystem{
    String fileName;

    public File(String fileName){
        this.fileName = fileName;
    }
    @Override
    public String showPath() {
        return this.fileName;
    }
}
