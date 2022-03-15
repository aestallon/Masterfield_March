package hu.papp_szabolcs_bazil.problem01;

/**
 * The {@code Passenger} class is used to create passengers with various flags about their age-bracket,
 * travelling group, destination and prior accidents. Instances of this class can be passed to
 * methods found in {@link InsuranceRequirements} to check if they are eligible for travel insurance.
 *
 * @author Szabolcs Bazil Papp
 * @version 1.0
 * @see InsuranceRequirements
 * @see TravelFor
 * @since 17.0.2
 */
public class Passenger {

    private int age;
    private boolean isAdult;
    private int numberOfAdults;
    private int numberOfChildren;
    private boolean isTravellingWithFamily;
    private boolean isTravellingAlone;
    private boolean hasHadAccident;
    private TravelFor purpose;
    private boolean isTravellingToEurope;

    /**
     * Creates a new passenger based on the parameters provided.
     *
     * @param age                  {@code int} the age of the passenger provided in <i>years</i>.
     *                             Should be a non-negative, reasonable number.
     * @param adultCompanions      {@code int} number of adults accompanying the passenger.
     * @param childCompanions      {@code int} number of children accompanying the passenger.
     * @param isTravellingToEurope {@code boolean} signaling the destination of the passenger.
     *                             Should be {@code true} if the passenger wishes to travel to Europe,
     *                             and {@code false} in any other case.
     * @param purpose              {@link TravelFor} enumerated category of the passenger's trip.
     * @param hasHadAccidents      {@code boolean} describing the accident record of the passenger.
     *                             Should be {@code true} if the passenger has record of prior accidents,
     *                             and {@code false} if not.
     */
    public Passenger(
            int age, int adultCompanions, int childCompanions,
            boolean isTravellingToEurope, TravelFor purpose, boolean hasHadAccidents) {

        this.age = age;
        initAgeRelatedFlags();
        initGroup(adultCompanions, childCompanions);
        initGroupRelatedFlags();

        // Setting miscellaneous information
        this.isTravellingToEurope = isTravellingToEurope;
        this.purpose = purpose;
        this.hasHadAccident = hasHadAccidents;

    }

    /**
     * Initializes the passenger's age related flags.
     * <p>
     * Sets the passenger as 'Adult' if they are at least 18 year of age, and to 'Child' if not.
     * </p>
     * <p><i>
     * This method should be used only in the constructor!
     * </i></p>
     */
    private void initAgeRelatedFlags() {
        this.isAdult = this.age >= 18;
    }

    /**
     * Initializes the passenger's travel group.
     * <p><i>
     * This method should be used only in the constructor!
     * </i></p>
     *
     * @param adultCompanions {@code int} number of adults accompanying the passenger.
     * @param childCompanions {@code int} number of children accompanying the passenger.
     */
    private void initGroup(int adultCompanions, int childCompanions) {
        this.numberOfAdults += adultCompanions;
        this.numberOfChildren += childCompanions;
        if (this.isAdult) {
            this.numberOfAdults++;
        } else {
            this.numberOfChildren++;
        }
    }

    /**
     * Initializes the passenger's group related flags.
     * <p>
     * If the group consists of exactly 2 adults and at least 2 children, the passenger will be
     * flagged as <i>'travelling with family'</i>.
     * </p><p>
     * If the group consists of exactly 1 person (the passenger himself/herself), the
     * passenger will be flagged as <i>'travelling alone'</i>.
     * </p><p><i>
     * This method should be used only in the constructor!
     * </i></p>
     */
    private void initGroupRelatedFlags() {
        if (this.numberOfAdults + this.numberOfChildren == 1) {
            this.isTravellingAlone = true;
        } else if (this.numberOfAdults == 2 && this.numberOfChildren >= 2) {
            this.isTravellingWithFamily = true;
        }
    }

    /**
     * Checks if the passenger is an adult
     *
     * @return {@code true} if the passenger is at least 18 years of age, else {@code false}.
     */
    public boolean isAdult() {
        return isAdult;
    }

    /**
     * Checks if the passenger is travelling with a family.
     *
     * @return {@code true} if the passenger's group has exactly 2 adults and at least 2 children,
     * else {@code false}.
     */
    public boolean isTravellingWithFamily() {
        return isTravellingWithFamily;
    }

    /**
     * Checks if the passenger is travelling alone.
     *
     * @return {@code true} if the passenger's group is a single person, else {@code false}.
     */
    public boolean isTravellingAlone() {
        return isTravellingAlone;
    }

    /**
     * Checks if the passenger has a record of prior accidents.
     *
     * @return {@code true} if the passenger has had accidents before, else {@code false}.
     */
    public boolean hasHadAccident() {
        return hasHadAccident;
    }

    /**
     * Checks the purpose of the passenger's trip.
     *
     * @return an item of {@link TravelFor}.
     * @see TravelFor
     */
    public TravelFor getPurpose() {
        return purpose;
    }

    /**
     * Checks if the passenger is travelling to a European country or not.
     *
     * @return {@code true} if the trip's destination is Europe, else {@code false}.
     */
    public boolean isTravellingToEurope() {
        return isTravellingToEurope;
    }

    /**
     * For testing purposes.
     *
     * @return a proper {@code String} representation of the passenger.
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Passenger{");
        sb.append("age=").append(age);
        sb.append(", isAdult=").append(isAdult);
        sb.append(", numberOfAdults=").append(numberOfAdults);
        sb.append(", numberOfChildren=").append(numberOfChildren);
        sb.append(", isTravellingWithFamily=").append(isTravellingWithFamily);
        sb.append(", isTravellingAlone=").append(isTravellingAlone);
        sb.append(", hasHadAccident=").append(hasHadAccident);
        sb.append(", purpose=").append(purpose);
        sb.append(", isTravellingToEurope=").append(isTravellingToEurope);
        sb.append('}');
        return sb.toString();
    }
}
