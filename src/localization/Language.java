package localization;

public abstract class Language {
    public static Languages GetSelected() {
        return sel;
    }

    public enum Languages {English, Magyar}
    private static Languages sel;
    private static Language lang;

    static public void Initialise(Languages lang) {
        sel = lang;
        switch (lang) {
            case English:
                Language.lang = new English();
                break;
            case Magyar:
                Language.lang = new Magyar();
                break;
        }
    }

    static public Language Instance() {
        return lang;
    }

    public abstract String BearDeathMSG();
    public abstract String ColdDeathMSG();
    public abstract String DrownDeathMSG();
    public abstract String WinMSG();
    public abstract String Inventory();
    public abstract String PlayerName();
    public abstract String PlayerHP();
    public abstract String PlayerAP();

    public abstract String ActionPass();
    public abstract String ActionMove();
    public abstract String ActionDig();
    public abstract String ActionTurnLeft();
    public abstract String ActionTurnRight();
    public abstract String ActionSpecial();
    public abstract String ActionPickup();

    public abstract String RescueQuestion();

    public abstract  String MenuExit();
    public abstract  String MenuStart();
    public abstract  String MenuPlayerCount();
    public abstract  String MenuSelectedMap();
    public abstract  String MenuSchangeLang();

    public abstract  String Players();
}
