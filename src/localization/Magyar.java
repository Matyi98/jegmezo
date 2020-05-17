package localization;

public class Magyar extends Language {
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
