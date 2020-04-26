package items;

import scene.GameController;

public class FragileShovel extends Item {

    private int durability = 3;
    private int shovelSpeedIncrease = 2;

    @Override
    protected void showPickup() {
        GameController.OutStream.println("FragileShovel picked up");
    }


    @Override
    public void use() {
        owner.shovel(shovelSpeedIncrease);
        --durability;
        if(durability == 0)
            owner.removeItem(this);
    }

    public void Show() {
        GameController.OutStream.print("FragileShovel");
    }
    public void ShowShort() { GameController.OutStream.print("g"); }
}
