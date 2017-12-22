import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ElfDistributionCenterFeature {
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

    @Test
    void test() {

    }
}
