package oop_lab10;

public class BlurFilterCommand extends ImageCommand{

    @Override
    public void execute() {
        System.out.println("Blured image");
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
