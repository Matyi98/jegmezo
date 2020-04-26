package items;

import scene.writer.SceneWriter;

public class FragileShovel extends Item {

    private int durability = 3;
    private int shovelSpeedIncrease = 2;

    @Override
    protected void showPickup() {
        SceneWriter.OutStream.println("FragileShovel picked up");
    }


    @Override
    public void use() {
        owner.shovel(shovelSpeedIncrease);
        --durability;
        if(durability == 0)
            owner.removeItem(this);
    }

    public void Show() {
        SceneWriter.OutStream.print("FragileShovel");
    }
    public void ShowShort() { SceneWriter.OutStream.print("g"); }
}
