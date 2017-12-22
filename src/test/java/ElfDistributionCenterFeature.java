import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ElfDistributionCenterFeature {
    private Child child;

    //1. Jedes Kind bekommt ein Geschenk
    //2. Jedes Kind bekommt übers Jahr verteilt immer wieder einen Score für Taten
    //3. Gute Taten: Einer alten Person über die Strasse helfen(1 Punkt), eine Niere spenden (100 Punkte)
    //            4. Böse Taten:
    //    Geschwister ärgern (-1 Punkt),
    //    den Hund nicht füttern (-20),
    //    Pflastersteine von der Autobahnbrücke werfen(-100 Punkte)
    //5. Geschenketabelle
    //   <= -100: Keine Geschenke für die nächsten 3 Jahre
    //   <= 0: ein Stück Kohle
    //   1-4: Ein warmer Händedruck vom Nikolaus
    //   5 Punkte: Apfel
    //   50 Punkte: Carrera Bahn
    //   100 Punkte: Millenium Falcon
    //6. Kinderhighscore

    // - Ein Kind bekommt ein Geschenk. Ein Kind
    //      - mit 0 Punkten bekommt ein ein Stück Kohle
    //      - mit -99 Punkten bekommt ein Stück Kohle
    //        ...
    // - Punktetracking
    //      - ein Kind mit 0 Punkten hat nach der Tat "einer alten Person über die Strasse helfen"
    //          1 Punkt
    //      - ein Kind mit 15 Punkten hat nach der Tat "einer alten Person über die Strasse helfen"
    //          16 Punkte
    //      - ...
    // - Highscore

    @BeforeEach
    void setUp() {
        child = new Child();
    }

    @Test
    void onePointForOldPersonCrossTheStreet() {
        child.does(Deed.HELP_OLD_PERSON_CROSS_THE_STREET);

        assertThat(child.score()).isEqualTo(1);
    }

    @Test
    void twoPointsForTwoTimesOldPersonCrossTheStreet() {
        child.does(Deed.HELP_OLD_PERSON_CROSS_THE_STREET);
        child.does(Deed.HELP_OLD_PERSON_CROSS_THE_STREET);

        assertThat(child.score()).isEqualTo(2);
    }

    @Test
    void hundredPointsForDonatingAKidney() {
        child.does(Deed.DONATE_A_KIDNEY);

        assertThat(child.score()).isEqualTo(100);
    }

    @Test
    void milleniumFalconFor100Points() {
        Deed onehundredPointDeed = Deed.DONATE_A_KIDNEY;
        child.does(onehundredPointDeed);

        ElfDistributionCenter elfDistributionCenter = new ElfDistributionCenter();

        assertThat(elfDistributionCenter.selectGiftFor(child)).isEqualTo(Gift.MILLENIUM_FALCON);
    }

    @Test
    void appleFor5Points() {
        Deed onePointDeed = Deed.HELP_OLD_PERSON_CROSS_THE_STREET;
        child.does(onePointDeed);
        child.does(onePointDeed);
        child.does(onePointDeed);
        child.does(onePointDeed);
        child.does(onePointDeed);

        ElfDistributionCenter elfDistributionCenter = new ElfDistributionCenter();

        assertThat(elfDistributionCenter.selectGiftFor(child)).isEqualTo(Gift.APPLE);
    }
}
