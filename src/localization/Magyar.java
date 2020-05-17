package localization;

/**
 * Magyar nyelvi csomag.
 */
public class Magyar extends Language {

    /**
     * Lehetséges magyar eszkimó nevek.
     */
    private String[] naEskimo = new String[] {
            "Jég Aladár",
            "Rozmár Béla",
            "Havasi Csaba",
            "Pingvin Dávid",
            "Bálnazsír Ernő",
            "Lék Ferenc"
    };

    /**
     * Lehetséges magyar kutató nevek.
     */
    private String[] naExplorer = new String[] {
            "Dr. Jégkaparó Richárd",
            "Dr. Fagyálló Feri",
            "Dr. Mischlen",
            "Dr. Wernher von Braun",
            "Доктор Андраш Kрасный",
            "Dr. Balage Goldschmidt"
    };

    /**
     * A hóvihar szövegát adja meg
     * @return a hóvihar szövege
     */
    @Override
    public String BlizzardShort() {
        return "Hóvihar";
    }

    /**
     * A hóvihar szövegát adja meg, hosszabban
     * @return a hóvihar szövege, hosszabban
     */
    @Override
    public String BlizzardLong() {
        return "Hóvihar sújtotta a jégmezőt!";
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

    @Override
    public String BearDeathMSG() {
        return "Széttépett egy jegesmedve.";
    }

    @Override
    public String ColdDeathMSG() {
        return "Halálra fagytál egy hóviharban.";
    }

    @Override
    public String DrownDeathMSG() {
        return "Vízbefulltál.";
    }

    @Override
    public String WinMSG() {
        return "Sikeresen megmenekültetek!";
    }

    @Override
    public String ResearchMSG() {
        return "Kutatás eredménye";
    }

    @Override
    public String Inventory() {
        return "Táska";
    }

    @Override
    public String PlayerName() {
        return "Név: ";
    }

    @Override
    public String PlayerHP() {
        return "Életerőpont: ";
    }

    @Override
    public String PlayerAP() {
        return "Akciópont: ";
    }

    @Override
    public String Round() {
        return "Kör: ";
    }

    @Override
    public String ActionPass() {
        return "Passz";
    }

    @Override
    public String ActionMove() {
        return "Mozgás";
    }

    @Override
    public String ActionDig() {
        return "Ásás";
    }

    @Override
    public String ActionTurnLeft() {
        return "Balra";
    }

    @Override
    public String ActionTurnRight() {
        return "Jobbra";
    }

    @Override
    public String ActionSpecial() {
        return "Speciális";
    }

    @Override
    public String ActionPickup() {
        return "Felvesz";
    }

    @Override
    public String RescueQuestion() {
        return "Kit mentesz ki?";
    }

    @Override
    public String MenuExit() {
        return "Kilépés";
    }

    @Override
    public String MenuStart() {
        return "Indítás";
    }

    @Override
    public String MenuPlayerCount() {
        return "Játékosok száma";
    }

    @Override
    public String MenuSelectedMap() {
        return "Kiválasztott pálya";
    }

    @Override
    public String MenuSchangeLang() {
        return "Nyelv megváltoztatása";
    }

    @Override
    public String Players() {
        return "játékos";
    }
}
