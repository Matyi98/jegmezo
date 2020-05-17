package localization;

public abstract class Language {
    public static Languages GetSelected() {
        return sel;
    }

    public enum Languages {English, Magyar, Русский }
    private static Languages sel;
    private static Language lang = new Magyar();

    static public void Initialise(Languages lang) {
        sel = lang;
        switch (lang) {
            case English:
                Language.lang = new English();
                break;
            case Magyar:
                Language.lang = new Magyar();
                break;
            case Русский:
                Language.lang = new Russian();
                break;
        }
    }

    static public Language Instance() {
        return lang;
    }

    public abstract String BlizzardShort();
    public abstract String BlizzardLong();

    public abstract String EskimoName(int c);
    public abstract String ExplorerName(int c);

    public abstract String BearDeathMSG();
    public abstract String ColdDeathMSG();
    public abstract String DrownDeathMSG();
    public abstract String WinMSG();
    public abstract String ResearchMSG();

    public abstract String Inventory();
    public abstract String PlayerName();
    public abstract String PlayerHP();
    public abstract String PlayerAP();
    public abstract String Round();

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
