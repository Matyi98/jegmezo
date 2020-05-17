package localization;

public class Romanian extends Language {
    private String[] naEskimo = new String[]{
            "Andrei zăpadescu",
            "Mihai Pingvinescu",
            "Mariana Gheaţăescu",
            "Ludovic Iarnă-escu",
            "Ion de Urs Polarescu",
            "Nicoleai de la polul Nord"
    };

    private String[] naExplorer = new String[]{
            "Dr. Inteligent ",
            "Dr. Professor",
            "Dr. Doctor",
            "Dr. Cercetător",
            "Dr. Romanescu",
            "Dr. Tăran"
    };

    /**
     * A hóvihar szövegát adja meg
     *
     * @return a hóvihar szövege
     */
    @Override
    public String BlizzardShort() {
        return "Viscol";
    }

    /**
     * A hóvihar szövegát adja meg, hosszabban
     *
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

    @Override
    public String BearDeathMSG() {
        return "Ursul polar ucide";
    }

    @Override
    public String ColdDeathMSG() {
        return "Tu a îngheţat și a murit.";
    }

    @Override
    public String DrownDeathMSG() {
        return "Tu a înecat";
    }

    @Override
    public String WinMSG() {
        return "Victorie!";
    }

    @Override
    public String ResearchMSG() {
        return "Rezultatea cercetărilor";
    }

    @Override
    public String Inventory() {
        return "Depozitor";
    }

    @Override
    public String PlayerName() {
        return "Nume: ";
    }

    @Override
    public String PlayerHP() {
        return "Vitalitate: ";
    }

    @Override
    public String PlayerAP() {
        return "Energia: ";
    }

    @Override
    public String Round() {
        return "Rundă: ";
    }

    @Override
    public String ActionPass() {
        return "Pasare";
    }

    @Override
    public String ActionMove() {
        return "Înaintare";
    }

    @Override
    public String ActionDig() {
        return "Săpare";
    }

    @Override
    public String ActionTurnLeft() {
        return "Stânga";
    }

    @Override
    public String ActionTurnRight() {
        return "Dreapta";
    }

    @Override
    public String ActionSpecial() {
        return "Specialitate";
    }

    @Override
    public String ActionPickup() {
        return "Ridica";
    }

    @Override
    public String RescueQuestion() {
        return "Cu cine vrei să salvezi ";
    }

    @Override
    public String MenuExit() {
        return "Ieșire";
    }

    @Override
    public String MenuStart() {
        return "Startul jocului";
    }

    @Override
    public String MenuPlayerCount() {
        return "Numarul jucatorilor";
    }

    @Override
    public String MenuSelectedMap() {
        return "Traseul ales";
    }

    @Override
    public String MenuSchangeLang() {
        return "Schimbare limbajului";
    }

    @Override
    public String Players() {
        return "Jucător";
    }
}

