package localization;

/**
 * Román nyelvi csomag.
 */
public class Romanian extends Language{

    /**
     * Lehetséges román eszkimó nevek.
     */
        private String[] naEskimo = new String[] {
                "Andrei Zăpadescu",
                "Mihai Pingvinescu",
                "Mariana Gheaţăescu",
                "Ludovic Iarnă-escu",
                "Ion de Urs Polarescu",
                "Nicoleai Eskimescu"
        };

    /**
     * Lehetséges román kutató nevek.
     */
        private String[] naExplorer = new String[] {
                "Dr. Popa Iancu Eneida ",
                "Dr. Professor",
                "Dr. Radu Radulescu",
                "Dr. Cercetător",
                "Dr. Romanescu",
                "Dr. Tăran"
        };

    /**
     * A hóvihar szövegát adja meg
     * @return a hóvihar szövege
     */
    @Override
    public String BlizzardShort() {
        return "Viscol";
    }

    /**
     * A hóvihar szövegát adja meg, hosszabban
     * @return a hóvihar szövege, hosszabban
     */
    @Override
    public String BlizzardLong() {
        return "Viscolul a bătut câmpuri";
    }

    /**
     * Az eszkimó nevekből adja meg a kiválasztottat
     * @param c a kivásztott eszkimó indexe
     * @return a kiválaszott név
     */
    @Override
    public String EskimoName(int c) {
        return naEskimo[c];
    }

    /**
     * A sarkkutató nevekből adja meg a kiválasztottat
     * @param c a kivásztott sarkkutató indexe
     * @return a kiválaszott név
     */
    @Override
    public String ExplorerName(int c) {
        return naExplorer[c];
    }

    /**
     * Üzenet arra az esetre ha a játékos meghal egy
     * jegesmedve álltal
     * @return Az üzenet
     */
    @Override
    public String BearDeathMSG() {
        return "Ursul polar ucide";
    }

    /**
     * Üzenet arra az esetre ha a játékos meghal mert
     * megfagy
     * @return Az üzenet
     */
    @Override
    public String ColdDeathMSG() {
        return "Tu a îngheţat și a murit.";
    }

    /**
     * Üzenet arra az esetre ha a játékos meghal mert
     * megfulladt
     * @return Az üzenet
     */
    @Override
    public String DrownDeathMSG() {
        return "Tu a înecat";
    }

    /**
     * Üzenet arra az esetre ha a játékosok nyernek
     * @return Az üzenet
     */
    @Override
    public String WinMSG() {
        return "Victorie!";
    }

    /**
     * Üzenet arra az esetre ha a sarkkutató használja
     * a speciális képességét
     * @return Az üzenet
     */
    @Override
    public String ResearchMSG() {
        return "Rezultatea cercetărilor";
    }

    /**
     * Az Inventory neve
     * @return Az Inventory neve
     */
    @Override
    public String Inventory() {
        return "Depozitor";
    }

    /**
     * A játékos nevének kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String PlayerName() {
        return "Nume: ";
    }

    /**
     * A játékos életerejének kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String PlayerHP() {
        return "Vitalitate: ";
    }

    /**
     * A játékos akciópontjainak kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String PlayerAP() {
        return "Energia: ";
    }

    /**
     * Egy kör kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String Round() {
        return "Rundă: ";
    }

    /**
     * Egy játékos kör átugrásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionPass() {
        return "Pasare";
    }

    /**
     * Egy játékos mozgásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionMove() {
        return "Înaintare";
    }

    /**
     * Egy játékos ásásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionDig() {
        return "Săpare";
    }

    /**
     * Egy játékos balra furdulásához tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionTurnLeft() {
        return "Stânga";
    }

    /**
     * Egy játékos jobbra furdulásához tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionTurnRight() {
        return "Dreapta";
    }

    /**
     * Egy játékos speciális képességéhez tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionSpecial() {
        return "Specialitate";
    }

    /**
     * Egy játékos tárgyfelvételéhez tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionPickup() {
        return "Ridica";
    }

    /**
     * Egy játékos kimentésekor megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String RescueQuestion() {
        return "Cu cine vrei să salvezi ";
    }

    /**
     * A kilépés gombon lévő szöveg a menüben
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuExit() {
        return "Ieșire";
    }

    /**
     * A start gombon lévő szöveg a menüben
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuStart() {
        return "Startul jocului";
    }

    /**
     * A játékosok számához tartozó szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuPlayerCount() {
        return "Numarul jucatorilor";
    }

    /**
     * A pálya választási listában kiírandó szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuSelectedMap() {
        return "Traseul ales";
    }

    /**
     * A nyelv kiválasztási listában kiírandó szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuChangeLang() {
        return "Schimbare limbajului";
    }

    /**
     * A játékosok száma után megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String Players() {
        return "Jucător";
    }
}

