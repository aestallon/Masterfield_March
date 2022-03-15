package hu.papp_szabolcs_bazil.problem01;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A class for testing the correctness of the methods found in {@link InsuranceRequirements}.
 * <p>
 * By default, this class has a {@link #generateRandomPassenger()} method to construct a
 * random passenger for testing, and a {@link #runAllTests(Passenger)} method to
 * perform both evaluations found in {@code InsuranceRequirements} on a given {@link Passenger}.
 * </p>
 *
 * @author Szabolcs Bazil Papp
 * @version 1.0
 * @see Passenger
 * @see TravelFor
 * @see InsuranceRequirements
 * @since 17.0.2
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            Passenger passenger = generateRandomPassenger();
            System.out.println(passenger);
            runAllTests(passenger);
        }
    }

    /**
     * Tests if a passenger meets the criteria described in <i>part 1</i> of
     * the exercise.
     * <p><i>
     * Results are printed into standard output.
     * </i></p>
     *
     * @param passenger a {@link Passenger} to be tested.
     */
    private static void testPassengerForCriteria01(Passenger passenger) {
        boolean result = InsuranceRequirements.evaluateRequirement01(passenger);
        System.out.println("Criteria 01: " + result);
    }

    /**
     * Tests if a passenger meets the criteria described in <i>part 2</i> of the exercise.
     * <p><i>
     * Results are printed into standard output.
     * </i></p>
     *
     * @param passenger a {@link Passenger} to be tested.
     */
    private static void testPassengerForCriteria02(Passenger passenger) {
        boolean result = InsuranceRequirements.evaluateRequirement02(passenger);
        System.out.println("Criteria 02: " + result);
    }

    /**
     * Tests if a passenger meets any of the criteria described in the exercise.
     * <p><i>
     * Results are printed into standard output.
     * </i></p>
     *
     * @param passenger a {@link Passenger} to be tested.
     */
    private static void runAllTests(Passenger passenger) {
        testPassengerForCriteria01(passenger);
        testPassengerForCriteria02(passenger);
    }

    /**
     * Generates a new instance of {@link Passenger} with random properties.
     * <p>
     * The generated passenger has the following properties:
     * </p>
     * <ul>
     * <li>{@code age}: random {@code int} between 0 and 99 (inclusive).
     * <li>{@code adultCompanions}: random {@code int} between 0 and 2 (inclusive).
     * <li>{@code childCompanions}: random {@code int} between 0 and 4 (inclusive).
     * <li>{@code destination}: random {@code boolean} signalling if the passenger
     * travels to Europe or not.
     * <li>{@code purpose}: random element of {@link TravelFor} to describe the
     * trips purpose.
     * <li>{@code history}: random {@code boolean} signalling if the passenger has
     * record of prior accidents or not.
     * </ul>
     *
     * @return a randomly generated {@link Passenger}.
     */
    private static Passenger generateRandomPassenger() {
        int rndAge = ThreadLocalRandom.current().nextInt(100);
        int rndAdultCompanions = ThreadLocalRandom.current().nextInt(3);
        int rndChildCompanions = ThreadLocalRandom.current().nextInt(5);
        boolean rndDestination = ThreadLocalRandom.current().nextBoolean();

        TravelFor rndPurpose = TravelFor.OTHER;
        int roll = ThreadLocalRandom.current().nextInt(5);
        switch (roll) {
            case 0 -> rndPurpose = TravelFor.BUSINESS;
            case 1 -> rndPurpose = TravelFor.CITY_TOUR;
            case 2 -> rndPurpose = TravelFor.EDUCATION;
            case 3 -> rndPurpose = TravelFor.SEASIDE_VACATION;
            case 4 -> rndPurpose = TravelFor.SPORT;
        }

        boolean rndHistory = ThreadLocalRandom.current().nextBoolean();

        return new Passenger(rndAge, rndAdultCompanions, rndChildCompanions, rndDestination, rndPurpose, rndHistory);
    }
}
