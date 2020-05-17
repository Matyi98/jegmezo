package localization;

public class English extends Language {
    private String[] naEskimo = new String[] {
            "Andrew Snow",
            "Bill Penguin",
            "Charlie Ice",
            "David Whalehunter",
            "Earl Iglubuilder",
            "Ferdinand Polar"
    };

    private String[] naExplorer = new String[] {
            "Dr. Richard Ice Scraper",
            "Dr. Hensel von Antifreeze",
            "Dr. Mischlen",
            "Dr. Wernher von Braun",
            "Доктор Андраш Kрасный",
            "Dr. Balage Goldschmidt"
    };


    @Override
    public String EskimoName(char c) {
        return naEskimo[c-'A'];
    }

    @Override
    public String ExplorerName(char c) {
        return naExplorer[c-'A'];
    }

    @Override
    public String BearDeathMSG() {
        return "A polarbear mauled you to death.";
    }

    @Override
    public String ColdDeathMSG() {
        return "You've frozen to death.";
    }

    @Override
    public String DrownDeathMSG() {
        return "You've drowned.";
    }

    @Override
    public String WinMSG() {
        return "You won!";
    }

    @Override
    public String ResearchMSG() {
        return "Research result";
    }

    @Override
    public String Inventory() {
        return "Inventory";
    }

    @Override
    public String PlayerName() {
        return "Name: ";
    }

    @Override
    public String PlayerHP() {
        return "HP: ";
    }

    @Override
    public String PlayerAP() {
        return "AP: ";
    }

    @Override
    public String Round() {
        return "Round: ";
    }

    @Override
    public String ActionPass() {
        return "Skip";
    }

    @Override
    public String ActionMove() {
        return "Move";
    }

    @Override
    public String ActionDig() {
        return "Dig";
    }

    @Override
    public String ActionTurnLeft() {
        return "Left";
    }

    @Override
    public String ActionTurnRight() {
        return "Right";
    }

    @Override
    public String ActionSpecial() {
        return "Special";
    }

    @Override
    public String ActionPickup() {
        return "Pick up";
    }

    @Override
    public String RescueQuestion() {
        return "Who whould you like to rescue?";
    }

    @Override
    public String MenuExit() {
        return "Exit";
    }

    @Override
    public String MenuStart() {
        return "Start";
    }

    @Override
    public String MenuPlayerCount() {
        return "Number of players";
    }

    @Override
    public String MenuSelectedMap() {
        return "Chose a map";
    }

    @Override
    public String MenuSchangeLang() {
        return "Change language";
    }

    @Override
    public String Players() {
        return "players";
    }
}
