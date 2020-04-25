package entities;

import fields.Field;
import scene.GameController;
import scene.writer.SceneWriter;

public class Bear extends Entity {


    @Override
    public void step(){

    }

    @Override
    public void ShowShort() {
        SceneWriter.OutStream.print("M");
    }

    @Override
    public void collideWith(Entity otherEntity){

    }
}
