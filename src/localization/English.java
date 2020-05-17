package localization;

/**
 * Angol nyelvi csomag.
 */
public class English extends Language {

    /**
     * Lehetséges angol eszkimó nevek.
     */
    private String[] naEskimo = new String[] {
            "Andrew Snow",
            "Bill Penguin",
            "Charlie Ice",
            "David Whalehunter",
            "Earl Iglubuilder",
            "Ferdinand Polar"
    };


    /**
     * Lehetséges angol kutató nevek.
     */
    private String[] naExplorer = new String[] {
            "Dr. Richard Ice Scraper",
            "Dr. Hensel von Antifreeze",
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
        return "Blizzard";
    }

    /**
     * A hóvihar szövegát adja meg, hosszabban
     * @return a hóvihar szövege, hosszabban
     */
    @Override
    public String BlizzardLong() {
        return "A blizzard hit the icefields.";
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
        return "A polar bear mauled you to death.";
    }

    /**
     * Üzenet arra az esetre ha a játékos meghal mert
     * megfagy
     * @return Az üzenet
     */
    @Override
    public String ColdDeathMSG() {
        return "You've frozen to death.";
    }

    /**
     * Üzenet arra az esetre ha a játékos meghal mert
     * megfulladt
     * @return Az üzenet
     */
    @Override
    public String DrownDeathMSG() {
        return "You've drowned.";
    }

    /**
     * Üzenet arra az esetre ha a játékosok nyernek
     * @return Az üzenet
     */
    @Override
    public String WinMSG() {
        return "You won!";
    }

    /**
     * Üzenet arra az esetre ha a sarkkutató használja
     * a speciális képességét
     * @return Az üzenet
     */
    @Override
    public String ResearchMSG() {
        return "Research result";
    }

    /**
     * Az Inventory neve
     * @return Az Inventory neve
     */
    @Override
    public String Inventory() {
        return "Inventory";
    }

    /**
     * A játékos nevének kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String PlayerName() {
        return "Name: ";
    }

    /**
     * A játékos életerejének kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String PlayerHP() {
        return "HP: ";
    }

    /**
     * A játékos akciópontjainak kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String PlayerAP() {
        return "AP: ";
    }

    /**
     * Egy kör kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String Round() {
        return "Round: ";
    }

    /**
     * Egy játékos kör átugrásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionPass() {
        return "Skip";
    }

    /**
     * Egy játékos mozgásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionMove() {
        return "Move";
    }

    /**
     * Egy játékos ásásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionDig() {
        return "Dig";
    }

    /**
     * Egy játékos balra furdulásához tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionTurnLeft() {
        return "Left";
    }

    /**
     * Egy játékos jobbra furdulásához tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionTurnRight() {
        return "Right";
    }

    /**
     * Egy játékos speciális képességéhez tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionSpecial() {
        return "Special";
    }

    /**
     * Egy játékos tárgyfelvételéhez tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionPickup() {
        return "Pick up";
    }

    /**
     * Egy játékos kimentésekor megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String RescueQuestion() {
        return "Who whould you like to rescue?";
    }

    /**
     * A kilépés gombon lévő szöveg a menüben
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuExit() {
        return "Exit";
    }

    /**
     * A start gombon lévő szöveg a menüben
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuStart() {
        return "Start";
    }

    /**
     * A játékosok számához tartozó szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuPlayerCount() {
        return "Number of players";
    }

    /**
     * A pálya választási listában kiírandó szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuSelectedMap() {
        return "Choose a map";
    }

    /**
     * A nyelv kiválasztási listában kiírandó szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuChangeLang() {
        return "Change language";
    }

    /**
     * A játékosok száma után megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String Players() {
        return "players";
    }
}
