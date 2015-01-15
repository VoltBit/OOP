package oop_lab10;

public class ImageCommandFactory {
    static ImageCommand com;
    static ImageCommand makeCommand(String type){
        switch (type){
            case "resize":
                com = new ResizeCommand();
                break;
            case "crop":
                com = new CropCommand();
                break;
            case "filter":
                com = new BlurFilterCommand();
                break;
        }
        return com;
    }
}
