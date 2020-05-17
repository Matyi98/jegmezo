package localization;

/**
 * Orosz nyelvi csomag.
 */
public class Russian extends Language {

    /**
     * Lehetséges orosz eszkimó nevek.
     */
    private String[] naEskimo = new String[] {
            "Пётр Игнлуевич Снег",
            "Борис Пингвиневич Пингвин",
            "Сергей Александрович Гагарин",
            "Димитрий Александрович Гагарин",
            "Николай Игнлуевич Снег",
            "Юрий Алексеевич Гагарин"
    };

    /**
     * Lehetséges orosz kutató nevek.
     */
    private String[] naExplorer = new String[] {
            "Дмитрий Иванович Менделеев",
            "Др. Hensel von Antifreeze",
            "Сергій Павлович Корольов",
            "Др. Вернер вон Браун",
            "Доктор Андраш Kрасный",
            "Др. Balage Goldschmidt"
    };

    /**
     * A hóvihar szövegát adja meg
     * @return a hóvihar szövege
     */
    @Override
    public String BlizzardShort() {
        return "Снежная буря";
    }

    /**
     * A hóvihar szövegát adja meg, hosszabban
     * @return a hóvihar szövege, hosszabban
     */
    @Override
    public String BlizzardLong() {
        return "Метель поразила поля!";
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
        return "Белый медведь покалечил тебя до смерти.";
    }

    @Override
    public String ColdDeathMSG() {
        return "Вы замерзли до смерти.";
    }

    @Override
    public String DrownDeathMSG() {
        return "Ты утонул";
    }

    @Override
    public String WinMSG() {
        return "Ты выиграл";
    }

    @Override
    public String ResearchMSG() {
        return "Результат исследования";
    }

    @Override
    public String Inventory() {
        return "Инвентарь";
    }

    @Override
    public String PlayerName() {
        return "Завут: ";
    }

    @Override
    public String PlayerHP() {
        return "Очки здоровья\n: ";
    }

    @Override
    public String PlayerAP() {
        return "Очки действия: ";
    }

    @Override
    public String Round() {
        return "Раунд: ";
    }

    @Override
    public String ActionPass() {
        return "Пропуск";
    }

    @Override
    public String ActionMove() {
        return "Шаг";
    }

    @Override
    public String ActionDig() {
        return "Копать";
    }

    @Override
    public String ActionTurnLeft() {
        return "Оставил";
    }

    @Override
    public String ActionTurnRight() {
        return "Правильно";
    }

    @Override
    public String ActionSpecial() {
        return "Особая";
    }

    @Override
    public String ActionPickup() {
        return "Подобрать";
    }

    @Override
    public String RescueQuestion() {
        return "Кого вы хотите выводить?";
    }

    @Override
    public String MenuExit() {
        return "Выход";
    }

    @Override
    public String MenuStart() {
        return "Старт";
    }

    @Override
    public String MenuPlayerCount() {
        return "Количество игроков";
    }

    @Override
    public String MenuSelectedMap() {
        return "Выбери трек";
    }

    @Override
    public String MenuSchangeLang() {
        return "Русский";
    }

    @Override
    public String Players() {
        return "игроки";
    }
}
