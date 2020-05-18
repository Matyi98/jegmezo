package utility;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.HashMap;

/**
 * Textúrák betöltését kezelő osztály.
 */
public class TurboTextureLoader {
    static TurboTextureLoader instance;

    public static void Initialise() {
        instance = new TurboTextureLoader();
    }

    HashMap<EntityTextures, Image> dataET = new HashMap<>();
    HashMap<FieldTextures, Image> dataFT = new HashMap<>();
    HashMap<ItemTextures, Image> dataIT = new HashMap<>();

    public static Image GetEntityTexture(EntityTextures et) {
        return instance.dataET.get(et);
    }

    public static Image GetFieldTexture(FieldTextures ft) {
        return instance.dataFT.get(ft);
    }

    public static Image GetItemTexture(ItemTextures it) {
        return instance.dataIT.get(it);
    }

    private TurboTextureLoader() {
        for (int i = 0; i < cET; i++) {
            Image img = loadImage("textures/entity_textures/"
                    + EntityTextures.values()[i]);
            dataET.put(EntityTextures.values()[i], img);
        }
        for (int i = 0; i < cFT; i++) {
            Image img = loadImage("textures/field_textures/"
                    + FieldTextures.values()[i]);
            dataFT.put(FieldTextures.values()[i], img);
        }
        for (int i = 0; i < cIT; i++) {
            Image img = loadImage("textures/item_textures/"
                    + ItemTextures.values()[i]);
            dataIT.put(ItemTextures.values()[i], img);
        }
    }

    private Image loadImage(String imagePath) {
        Image image = null;
        try(InputStream is = getClass().
                getClassLoader().getResourceAsStream(imagePath+".png")){
            image = new Image(is);
        } catch (Exception e) {
            System.err.println("Reference not found:" + imagePath+".png");
            e.printStackTrace();
        }
        return image;
    }

    private static final int cET = 9;
    public enum EntityTextures { bear,
        eskimo, eskimo_drowning, eskimo_scuba, eskimo_swimming,
        explorer, explorer_drowning, explorer_scuba, explorer_swimming
    }

    private static final int cFT = 4;
    public enum FieldTextures {
        ice, snow, unstableIce, water
    }

    private static final int cIT = 10;
    public enum ItemTextures {
        flare, food, fragile_shovel, igloo_icon,
        patron, pistol, rope, shovel,
        suit, tent
    }

}
