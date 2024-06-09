public enum SolarSystem {
    // Radius: 2440 km, Distance from Sun: 0 units
    MERCURY(0, 2440, null),
    // Radius: 6052 km, Distance from Sun: 0.4 units
    VENUS(0.4, 6052, MERCURY),
    // Radius: 6371 km, Distance from Sun: 0.7 units (0.4 + 0.3)
    EARTH(0.3, 6371, VENUS),
    // Radius: 3390 km, Distance from Sun: 1.2 units (0.7 + 0.5)
    MARS(0.5, 3390, EARTH),
    // Radius: 69911 km, Distance from Sun: 5.4 units (1.2 + 4.2)
    JUPITER(4.2, 69911, MARS),
    // Radius: 58232 km, Distance from Sun: 9.7 units (5.4 + 4.3)
    SATURN(4.3, 58232, JUPITER),
    // Radius: 25362 km, Distance from Sun: 19.5 units (9.7 + 9.8)
    URANUS(9.8, 25362, SATURN),
    // Radius: 24622 km, Distance from Sun: 30 units (19.5 + 10.5)
    NEPTUNE(10.5, 24622, URANUS);

    private final int sequence;
    private final double distanceFromPrevious;
    private final double distanceFromSun;
    private final int radius;
    private final SolarSystem previousPlanet;
    private SolarSystem nextPlanet;

    SolarSystem(double prevDistance, int radius, SolarSystem previousPlanet) {
        this.sequence = this.ordinal() + 1;
        this.distanceFromPrevious = prevDistance;
        this.radius = radius;
        this.previousPlanet = previousPlanet;
        if (previousPlanet != null) {
            this.distanceFromSun = previousPlanet.distanceFromSun + prevDistance;
            previousPlanet.nextPlanet = this;
        } else {
            this.distanceFromSun = 0; // For Mercury
        }
    }

    public int getSequence() {
        return sequence;
    }

    public double getDistanceFromPrevious() {
        return distanceFromPrevious;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    public int getRadius() {
        return radius;
    }

    public SolarSystem getPreviousPlanet() {
        return previousPlanet;
    }

    public SolarSystem getNextPlanet() {
        return nextPlanet;
    }

    public static void main(String[] args) {
        for (SolarSystem planet : SolarSystem.values()) {
            System.out.println("Planet: " + planet);
            System.out.println("Sequence: " + planet.getSequence());
            System.out.println("Distance from previous: " + planet.getDistanceFromPrevious() + " units");
            System.out.println("Distance from Sun: " + planet.getDistanceFromSun() + " units");
            System.out.println("Radius: " + planet.getRadius() + " km");
            System.out.println("Previous planet: " + (planet.getPreviousPlanet() != null ? planet.getPreviousPlanet() : "None"));
            System.out.println("Next planet: " + (planet.getNextPlanet() != null ? planet.getNextPlanet() : "None"));
            System.out.println();
        }
    }
}