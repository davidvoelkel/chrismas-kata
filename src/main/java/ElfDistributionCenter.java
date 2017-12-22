public class ElfDistributionCenter {
    public Gift selectGiftFor(Child child) {
        if (child.score() == 5) {
            return Gift.APPLE;
        }
        return Gift.MILLENIUM_FALCON;
    }
}
