package DesignPatterns.Composite.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{

    String dirName;
    List<FileSystem> direContents = new ArrayList<>();
    public Directory(String dirName){
        this.dirName = dirName;
    }

    public void addComponent(FileSystem component) {
        direContents.add(component);
    }

    public void removeComponent(FileSystem component) {
        direContents.remove(component);
    }
    @Override
    public String showPath() {
        return this.dirName;
    }
}
