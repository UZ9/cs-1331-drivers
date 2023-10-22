class HalloweenNightTests {

    @TestCase(name = "Constructor: Valid inputs passed in.")
    @Tip(description = "Make sure that there is no field shadowing in your constructor!")
    public void constructorValidInputs() throws TestFailedException {
        TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
        TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

        cryptKickerFive[0] = new Ghost("kicker1", 0, 0);
        cryptKickerFive[1] = new Ghost("kicker2", 0, 0);
        cryptKickerFive[2] = new Ghost("kicker3", 0, 0);
        cryptKickerFive[3] = new Ghost("kicker4", 0, 0);
        cryptKickerFive[4] = new Ghost("kicker5", 0, 0);
        ghoulGang[0] = new Ghost("ghoul1", 0, 0);
        ghoulGang[1] = new Ghost("ghoul2", 0, 0);
        ghoulGang[2] = new Ghost("ghoul3", 0, 0);
        ghoulGang[3] = new Ghost("ghoul4", 0, 0);
        ghoulGang[4] = new Ghost("ghoul5", 0, 0);

        HalloweenNight night = new HalloweenNight(cryptKickerFive, ghoulGang);

        String string = night.toString();

        TestFunction.assertEqual(string, "cryptKickerFive: kicker1/0/0/0, kicker2/0/0/0, kicker3/0/0/0, kicker4/0/0/0, kicker5/0/0/0 versus ghoulGang: ghoul1/0/0/0, ghoul2/0/0/0, ghoul3/0/0/0, ghoul4/0/0/0, ghoul5/0/0/0");
    }

    @TestCase(name = "compareTeams: cryptKicker5 is favored 3 to 2")
    @Tip(description = "Make sure you're comparing the same index on each team!")
    public void compareTeamsCK5Favored() throws TestFailedException {
        TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
        TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

        IOHijacker hijacker = IOHijacker.getInstance();
        hijacker.startRecording();

        cryptKickerFive[0] = new Ghost("kicker1", 0, 1);
        cryptKickerFive[1] = new Ghost("kicker2", 0,1);
        cryptKickerFive[2] = new Ghost("kicker3", 0, 1);
        cryptKickerFive[3] = new Ghost("kicker4", 0, 0);
        cryptKickerFive[4] = new Ghost("kicker5", 0, 0);
        ghoulGang[0] = new Ghost("ghoul1", 0, 0);
        ghoulGang[1] = new Ghost("ghoul2", 0, 0);
        ghoulGang[2] = new Ghost("ghoul3", 0, 0);
        ghoulGang[3] = new Ghost("ghoul4", 0, 1);
        ghoulGang[4] = new Ghost("ghoul5", 0, 1);

        HalloweenNight night = new HalloweenNight(cryptKickerFive, ghoulGang);
        night.compareTeams();

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(output, "cryptKickerFive is favored.\n");
    }

    @TestCase(name = "compareTeams: ghoulGang is favored 3 to 2")
    @Tip(description = "Make sure you're comparing the same index on each team!")
    public void compareTeamsGGFavored() throws TestFailedException {
        TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
        TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

        IOHijacker hijacker = IOHijacker.getInstance();
        hijacker.startRecording();

        cryptKickerFive[0] = new Ghost("kicker1", 0, 1);
        cryptKickerFive[1] = new Ghost("kicker2", 0,1);
        cryptKickerFive[2] = new Ghost("kicker3", 0, 1);
        cryptKickerFive[3] = new Ghost("kicker4", 1, 1);
        cryptKickerFive[4] = new Ghost("kicker5", 1, 1);
        ghoulGang[0] = new Ghost("ghoul1", 0, 2);
        ghoulGang[1] = new Ghost("ghoul2", 0, 2);
        ghoulGang[2] = new Ghost("ghoul3", 0, 2);
        ghoulGang[3] = new Ghost("ghoul4", 0, 1);
        ghoulGang[4] = new Ghost("ghoul5", 0, 1);

        HalloweenNight night = new HalloweenNight(cryptKickerFive, ghoulGang);
        night.compareTeams();

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(output, "ghoulGang is favored.\n");
    }

    @TestCase(name = "compareTeams: neither team is favored (all 5 TrickOrTreaters are equal)")
    @Tip(description = "Make sure you're comparing the same index on each team!")
    public void compareTeamsNeitherFavoredFive() throws TestFailedException {
        TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
        TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

        IOHijacker hijacker = IOHijacker.getInstance();
        hijacker.startRecording();

        cryptKickerFive[0] = new Ghost("kicker1", 3, 2);
        cryptKickerFive[1] = new Ghost("kicker2", 1, 2);
        cryptKickerFive[2] = new Ghost("kicker3", 0, 2);
        cryptKickerFive[3] = new Ghost("kicker4", 1, 1);
        cryptKickerFive[4] = new Ghost("kicker5", 1, 1);
        ghoulGang[0] = new Ghost("ghoul1", 3, 2);
        ghoulGang[1] = new Ghost("ghoul2", 1, 2);
        ghoulGang[2] = new Ghost("ghoul3", 0, 2);
        ghoulGang[3] = new Ghost("ghoul4", 1, 1);
        ghoulGang[4] = new Ghost("ghoul5", 1, 1);

        HalloweenNight night = new HalloweenNight(cryptKickerFive, ghoulGang);
        night.compareTeams();

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(output, "Neither team is favored.\n");
    }

    @TestCase(name = "compareTeams: neither team is favored (3 TrickOrTreaters are equal)")
    @Tip(description = "Make sure you're comparing the same index on each team!")
    public void compareTeamsNeitherFavoredThree() throws TestFailedException {
        TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
        TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

        IOHijacker hijacker = IOHijacker.getInstance();
        hijacker.startRecording();

        cryptKickerFive[0] = new Ghost("kicker1", 4, 2);
        cryptKickerFive[1] = new Ghost("kicker2", 0, 2);
        cryptKickerFive[2] = new Ghost("kicker3", 0, 2);
        cryptKickerFive[3] = new Ghost("kicker4", 1, 1);
        cryptKickerFive[4] = new Ghost("kicker5", 1, 1);
        ghoulGang[0] = new Ghost("ghoul1", 3, 2);
        ghoulGang[1] = new Ghost("ghoul2", 1, 2);
        ghoulGang[2] = new Ghost("ghoul3", 0, 2);
        ghoulGang[3] = new Ghost("ghoul4", 1, 1);
        ghoulGang[4] = new Ghost("ghoul5", 1, 1);

        HalloweenNight night = new HalloweenNight(cryptKickerFive, ghoulGang);
        night.compareTeams();

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(output, "Neither team is favored.\n");
    }

    @TestCase(name = "compareTeams: neither team is favored (1 TrickOrTreater is equal)")
    @Tip(description = "Make sure you're comparing the same index on each team!")
    public void compareTeamsNeitherFavoredOne() throws TestFailedException {
        TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
        TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

        IOHijacker hijacker = IOHijacker.getInstance();
        hijacker.startRecording();

        cryptKickerFive[0] = new Ghost("kicker1", 4, 2);
        cryptKickerFive[1] = new Ghost("kicker2", 0, 2);
        cryptKickerFive[2] = new Ghost("kicker3", 1, 2);
        cryptKickerFive[3] = new Ghost("kicker4", 0, 1);
        cryptKickerFive[4] = new Ghost("kicker5", 1, 1);
        ghoulGang[0] = new Ghost("ghoul1", 3, 2);
        ghoulGang[1] = new Ghost("ghoul2", 1, 2);
        ghoulGang[2] = new Ghost("ghoul3", 0, 2);
        ghoulGang[3] = new Ghost("ghoul4", 1, 1);
        ghoulGang[4] = new Ghost("ghoul5", 1, 1);

        HalloweenNight night = new HalloweenNight(cryptKickerFive, ghoulGang);
        night.compareTeams();

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(output, "Neither team is favored.\n");
    }

    @TestCase(name = "battle: cryptKickerFive wins in one turn by trickOrTreating")
    @Tip(description = "Remember to trickOrTreat() first!")
    public void battleWinImmediately() throws TestFailedException {
        TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
        TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

        IOHijacker hijacker = IOHijacker.getInstance();
        hijacker.startRecording();

        cryptKickerFive[0] = new Ghost("kicker1", 0, 8);
        cryptKickerFive[1] = new Ghost("kicker2", 0, 8);
        cryptKickerFive[2] = new Ghost("kicker3", 0, 8);
        cryptKickerFive[3] = new Ghost("kicker4", 0, 8);
        cryptKickerFive[4] = new Ghost("kicker5", 0, 8);
        ghoulGang[0] = new Witch("ghoul1", 1, 0, "Ha");
        ghoulGang[1] = new Witch("ghoul2", 1, 0, "Ha");
        ghoulGang[2] = new Witch("ghoul3", 1, 0, "Ha");
        ghoulGang[3] = new Witch("ghoul4", 1, 0, "Ha");
        ghoulGang[4] = new Witch("ghoul5", 1, 0, "Ha");

        HalloweenNight night = new HalloweenNight(cryptKickerFive, ghoulGang);
        night.battle(48);

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(output, "Boo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\n"
            + "Ha! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\n" 
            + "cryptKickerFive won!\n");
    }

    @TestCase(name = "battle: threshold defaults to 60")
    @Tip(description = "Remember to trickOrTreat() first!")
    public void battleDefaultThreshold() throws TestFailedException {
        TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
        TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

        IOHijacker hijacker = IOHijacker.getInstance();
        hijacker.startRecording();

        cryptKickerFive[0] = new Ghost("kicker1", 0, 9);
        cryptKickerFive[1] = new Ghost("kicker2", 0, 9);
        cryptKickerFive[2] = new Ghost("kicker3", 0, 9);
        cryptKickerFive[3] = new Ghost("kicker4", 0, 9);
        cryptKickerFive[4] = new Ghost("kicker5", 0, 9);
        ghoulGang[0] = new Witch("ghoul1", 1, 0, "Ha");
        ghoulGang[1] = new Witch("ghoul2", 1, 0, "Ha");
        ghoulGang[2] = new Witch("ghoul3", 1, 0, "Ha");
        ghoulGang[3] = new Witch("ghoul4", 1, 0, "Ha");
        ghoulGang[4] = new Witch("ghoul5", 1, 0, "Ha");

        HalloweenNight night = new HalloweenNight(cryptKickerFive, ghoulGang);
        night.battle(0);

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(output, "Boo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\n"
            + "Ha! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\n" 
            + "Boo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\n"
            + "Ha! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\n" 
            + "cryptKickerFive won!\n");
    }

    @TestCase(name = "battle: Both teams go at least once")
    @Tip(description = "Even if the threshold is met, make sure that the teams both get the same number of turns!")
    public void battleBothTeamsGo() throws TestFailedException {
        TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
        TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

        IOHijacker hijacker = IOHijacker.getInstance();
        hijacker.startRecording();

        cryptKickerFive[0] = new Ghost("kicker1", 0, 10);
        cryptKickerFive[1] = new Ghost("kicker2", 0, 10);
        cryptKickerFive[2] = new Ghost("kicker3", 0, 10);
        cryptKickerFive[3] = new Ghost("kicker4", 0, 10);
        cryptKickerFive[4] = new Ghost("kicker5", 0, 10);
        ghoulGang[0] = new Witch("ghoul1", 1, 69, "Ha");
        ghoulGang[1] = new Witch("ghoul2", 1, 0, "Ha");
        ghoulGang[2] = new Witch("ghoul3", 1, 0, "Ha");
        ghoulGang[3] = new Witch("ghoul4", 1, 0, "Ha");
        ghoulGang[4] = new Witch("ghoul5", 1, 0, "Ha");

        HalloweenNight night = new HalloweenNight(cryptKickerFive, ghoulGang);
        night.battle(65);

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(output, "Boo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\n"
            + "Ha! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\n"
            + "It is a tie!\n");
    }

    @TestCase(name = "battle: ghoulGang just barely meets the threshold")
    @Tip(description = "Is a threshold a greater-than requirement, or a greater-than-or-equal-to?")
    public void battleMinimumAmount() throws TestFailedException {
        TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
        TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

        IOHijacker hijacker = IOHijacker.getInstance();
        hijacker.startRecording();

        cryptKickerFive[0] = new Witch("kicker1", 1, 0, "Ha");
        cryptKickerFive[1] = new Witch("kicker2", 1, 0, "Ha");
        cryptKickerFive[2] = new Witch("kicker3", 1, 0, "Ha");
        cryptKickerFive[3] = new Witch("kicker4", 1, 0, "Ha");
        cryptKickerFive[4] = new Witch("kicker5", 1, 0, "Ha");
        ghoulGang[0] = new Ghost("ghoul1", 0, 10);
        ghoulGang[1] = new Ghost("ghoul2", 0, 10);
        ghoulGang[2] = new Ghost("ghoul3", 0, 10);
        ghoulGang[3] = new Ghost("ghoul4", 0, 10);
        ghoulGang[4] = new Ghost("ghoul5", 0, 10);

        HalloweenNight night = new HalloweenNight(cryptKickerFive, ghoulGang);
        night.battle(65);

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(output, "Ha! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\n" 
            + "Boo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\n"
            + "ghoulGang won!\n");
    }

    @TestCase(name = "battle: ghoulGang wins by robbing")
    @Tip(description = "What should each Ghost do after it TrickOrTreats?")
    public void battleWinByRobbing() throws TestFailedException {
        TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
        TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

        IOHijacker hijacker = IOHijacker.getInstance();
        hijacker.startRecording();

        cryptKickerFive[0] = new Witch("kicker1", 1, 10, "Ha");
        cryptKickerFive[1] = new Witch("kicker2", 1, 10, "Ha");
        cryptKickerFive[2] = new Witch("kicker3", 1, 10, "Ha");
        cryptKickerFive[3] = new Witch("kicker4", 1, 10, "Ha");
        cryptKickerFive[4] = new Witch("kicker5", 1, 10, "Ha");
        ghoulGang[0] = new Ghost("ghoul1", 0, 10);
        ghoulGang[1] = new Ghost("ghoul2", 0, 10);
        ghoulGang[2] = new Ghost("ghoul3", 0, 10);
        ghoulGang[3] = new Ghost("ghoul4", 0, 10);
        ghoulGang[4] = new Ghost("ghoul5", 0, 10);

        HalloweenNight night = new HalloweenNight(cryptKickerFive, ghoulGang);
        night.battle(90);

        String output = hijacker.stopRecording();

        TestFunction.assertEqual(output, "Ha! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\nHa! I'll get you my pretty!\n" 
            + "Boo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\nBoo! Trick or treat!\n"
            + "ghoulGang won!\n");
    }
}
