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

    /**
     * Üzenet arra az esetre ha a játékos meghal egy
     * jegesmedve álltal
     * @return Az üzenet
     */
    @Override
    public String BearDeathMSG() {
        return "Белый медведь покалечил тебя до смерти.";
    }

    /**
     * Üzenet arra az esetre ha a játékos meghal mert
     * megfagy
     * @return Az üzenet
     */
    @Override
    public String ColdDeathMSG() {
        return "Вы замерзли до смерти.";
    }

    /**
     * Üzenet arra az esetre ha a játékos meghal mert
     * megfulladt
     * @return Az üzenet
     */
    @Override
    public String DrownDeathMSG() {
        return "Ты утонул";
    }

    /**
     * Üzenet arra az esetre ha a játékosok nyernek
     * @return Az üzenet
     */
    @Override
    public String WinMSG() {
        return "Ты выиграл";
    }

    /**
     * Üzenet arra az esetre ha a sarkkutató használja
     * a speciális képességét
     * @return Az üzenet
     */
    @Override
    public String ResearchMSG() {
        return "Результат исследования";
    }

    /**
     * Az Inventory neve
     * @return Az Inventory neve
     */
    @Override
    public String Inventory() {
        return "Инвентарь";
    }

    /**
     * A játékos nevének kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String PlayerName() {
        return "Завут: ";
    }

    /**
     * A játékos életerejének kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String PlayerHP() {
        return "Очки здоровья\n: ";
    }

    /**
     * A játékos akciópontjainak kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String PlayerAP() {
        return "Очки действия: ";
    }

    /**
     * Egy kör kiírása előtt megjelenő tag
     * @return A megjelenő szöveg
     */
    @Override
    public String Round() {
        return "Раунд: ";
    }

    /**
     * Egy játékos kör átugrásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionPass() {
        return "Пропуск";
    }

    /**
     * Egy játékos mozgásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionMove() {
        return "Шаг";
    }

    /**
     * Egy játékos ásásánál megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionDig() {
        return "Копать";
    }

    /**
     * Egy játékos balra furdulásához tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionTurnLeft() {
        return "Оставил";
    }

    /**
     * Egy játékos jobbra furdulásához tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionTurnRight() {
        return "Правильно";
    }

    /**
     * Egy játékos speciális képességéhez tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionSpecial() {
        return "Особая";
    }

    /**
     * Egy játékos tárgyfelvételéhez tartozó megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String ActionPickup() {
        return "Подобрать";
    }

    /**
     * Egy játékos kimentésekor megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String RescueQuestion() {
        return "Кого вы хотите выводить?";
    }

    /**
     * A kilépés gombon lévő szöveg a menüben
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuExit() {
        return "Выход";
    }

    /**
     * A start gombon lévő szöveg a menüben
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuStart() {
        return "Старт";
    }

    /**
     * A játékosok számához tartozó szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuPlayerCount() {
        return "Количество игроков";
    }

    /**
     * A pálya választási listában kiírandó szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuSelectedMap() {
        return "Выбери трек";
    }

    /**
     * A nyelv kiválasztási listában kiírandó szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String MenuChangeLang() {
        return "Русский";
    }

    /**
     * A játékosok száma után megjelenő szöveg
     * @return A megjelenő szöveg
     */
    @Override
    public String Players() {
        return "игроки";
    }
}
