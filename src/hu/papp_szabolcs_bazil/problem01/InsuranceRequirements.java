package hu.papp_szabolcs_bazil.problem01;

/**
 * <b>Problem No.1</b>
 * <p>
 * The {@code InsuranceRequirements} class consists exclusively of static methods used for
 * evaluating travel insurance related criteria for {@link Passenger}s.
 * </p><p>
 * <i>The source code is available at
 * <a href="https://github.com/aestallon/Masterfield_March">this GitHub address.</a></i>
 * </p>
 *
 * @author Szabolcs Bazil Papp <papp.szabolcs.bazil@gmail.com>
 * @version 1.0
 * @see Passenger
 * @see TravelFor
 * @since 17.0.2
 */
public class InsuranceRequirements {

    /**
     * Evaluates if a passenger fits the below criteria for travel insurance:
     * <blockquote>
     * {@code true}, if the passenger travels alone for business purposes to a European country;
     * also {@code true}, if the passenger travels for sport-related reasons, is at least 18 years
     * of age and has no prior record of accidents.
     * </blockquote>
     * <p>
     * The original specification for the requirement written in Hungarian is as follows:
     * <blockquote>
     * Igaz, (1) ha egyedül utazik és üzleti úton vesz részt és európai országba utazik, akkor is igaz,
     * (2) ha sportolási céllal utazik, legalább 18 éves és még nem volt balesete
     * </blockquote>
     * </p>
     *
     * @param passenger a {@link Passenger}.
     * @return {@code true} if the passenger fits the criteria, else {@code false}.
     * @see Passenger
     */
    public static boolean evaluateRequirement01(Passenger passenger) {
        boolean subRequirement01 = passenger.isTravellingAlone() &&
                (passenger.getPurpose() == TravelFor.BUSINESS) &&
                passenger.isTravellingToEurope();
        boolean subRequirement02 = (passenger.getPurpose() == TravelFor.SPORT) &&
                passenger.isAdult() &&
                !passenger.hasHadAccident();

        return (subRequirement01 || subRequirement02);
    }

    /**
     * Evaluates if a passenger fits the below criteria for travel insurance:
     * <blockquote>
     * {@code true}, if the passenger travels alone for education abroad;
     * also {@code true}, if the passenger travels in a family unit (2 adults and at least 2 children), for
     * a seaside vacation and has no record of prior accidents;
     * also {@code true}, if the passenger travels for a city-tour to either a European country, or a
     * non-European country, but has no record of prior accidents.
     * </blockquote>
     * <p>
     * The original specification for the requirement written in Hungarian is as follows:
     * <blockquote>
     * Igaz, (1) ha egyedül utazik és külföldi tanulmányúton vesz részt, akkor is igaz,
     * (2) ha családdal utazik (2 felnőtt és legalább 2 gyerek) és tengerpari nyaraláson vesz részt
     * és még nem volt balesete, és akkor is igaz,
     * (3) ha városnézésen vesz részt és európai országba utazik, vagy nem európai országba utazik,
     * de még nem volt balesete.
     * </blockquote>
     * </p>
     *
     * @param passenger a {@link Passenger}.
     * @return {@code true} if the passenger fits the criteria, else {@code false}.
     * @see Passenger
     */
    public static boolean evaluateRequirement02(Passenger passenger) {
        boolean subRequirement01 = passenger.isTravellingAlone() &&
                (passenger.getPurpose() == TravelFor.EDUCATION);
        boolean subRequirement02 = passenger.isTravellingWithFamily() &&
                passenger.getPurpose() == TravelFor.SEASIDE_VACATION &&
                !passenger.hasHadAccident();
        boolean subRequirement03 = (passenger.getPurpose() == TravelFor.CITY_TOUR) &&
                (passenger.isTravellingToEurope() ||
                        !passenger.isTravellingToEurope() && !passenger.hasHadAccident());

        return (subRequirement01 || subRequirement02 || subRequirement03);
    }
}
