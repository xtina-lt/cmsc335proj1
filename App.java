import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private abstract static class MenuEntryConsole extends MenuEntry<Shape> {
        private final Scanner scanner;

        public MenuEntryConsole(String label, Scanner scanner) {
            super(label);
            this.scanner = scanner;
        }

        public String getAttribute(String attribute) {
            System.out.println(getQuestion(attribute));
            return scanner.nextLine();
        }
    }

    public static void main(String[] ignored) {
        final Scanner inputScanner = new Scanner(System.in);

        final MenuEntryConsole circleEntry = new MenuEntryConsole("Circle", inputScanner) {
            @Override
            public TwoDimensionalShape get() {
                return new Circle(getPositiveIntegerAttribute("Radius"));
            }
        };

        final MenuEntryConsole rectangleEntry = new MenuEntryConsole("Rectangle", inputScanner) {
            @Override
            public TwoDimensionalShape get() {
                return new Rectangle(getPositiveIntegerAttribute("length"),
                        getPositiveIntegerAttribute("width"));
                // values unique to rectangle Area = L x W
            }
        };

        final MenuEntryConsole squareEntry = new MenuEntryConsole("Square", inputScanner) {
            @Override
            public TwoDimensionalShape get() {
                return new Square(getPositiveIntegerAttribute("side"));
                // values unique to square Area = L x L
            }
        };

        final MenuEntryConsole triangleEntry = new MenuEntryConsole("Triangle", inputScanner) {
            @Override
            public TwoDimensionalShape get() {
                return new Triangle(getPositiveIntegerAttribute("base"),
                        getPositiveIntegerAttribute("height"));
                // values unique to triangle Area = L x W
            }
        };

        final MenuEntryConsole sphereEntry = new MenuEntryConsole("Sphere", inputScanner) {
            @Override
            public ThreeDimensionalShape get() {
                return new Sphere(getPositiveIntegerAttribute("Radius"));
            }
        };

        final MenuEntryConsole cubeEntry = new MenuEntryConsole("Cube",
                inputScanner) {
            @Override
            public ThreeDimensionalShape get() {
                return new Cube(getPositiveIntegerAttribute("edge"));
            }
        };

        final MenuEntryConsole cylinderEntry = new MenuEntryConsole("Cylinder", inputScanner) {
            @Override
            public ThreeDimensionalShape get() {
                return new Cylinder(getPositiveIntegerAttribute("radius"),
                        getPositiveIntegerAttribute("height"));
            }
        };

        final MenuEntryConsole coneEntry = new MenuEntryConsole("Cone",
                inputScanner) {
            @Override
            public ThreeDimensionalShape get() {
                return new Cone(getPositiveIntegerAttribute("radius"),
                        getPositiveIntegerAttribute("height"));
            }
        };

        final MenuEntryConsole torusEntry = new MenuEntryConsole("Torus", inputScanner) {
            @Override
            public ThreeDimensionalShape get() {
                return new Torus(getPositiveIntegerAttribute("minorradius"),
                        getPositiveIntegerAttribute("majorradius"));
            }
        };

        final MenuEntry<Shape>[] entries = new MenuEntryConsole[] {
                circleEntry, rectangleEntry, squareEntry,
                triangleEntry, sphereEntry, cubeEntry, coneEntry,
                cylinderEntry, torusEntry };
        final ArrayList<Shape> Logic = new ArrayList<>();

        try {
            while (true) {
                int userInput = -1;
                System.out.println("*********Welcome to the Java OO Shapes Program **********\n");
                System.out.println("Select from the menu below:\n");

                for (int i = 0; i < entries.length; ++i) {
                    System.out.println(String.format("%d. Construct a %s", (i + 1), entries[i].toString() ));
                    // System.out.println((i + 1) + ". Construct a " + entries[i].toString());
                }
                System.out.println("10. Exit theprogram ");
                try {
                    userInput = Integer.parseInt( inputScanner.nextLine() );
                } catch (NumberFormatException e) {
                    userInput = -1;
                }
                if (userInput >= 1 && userInput <= entries.length) {
                    final String label = entries[userInput -1].toString();
                    System.out.println("You have selected a " +
                            label);
                    try {
                        final Shape shapes = entries[userInput - 1].get();
                        System.out.println(shapes);
                        Logic.add(shapes);
                    } catch (Exception badInput) {
                        System.out.println("Invalid input for " +
                                label);
                    }
                } else if (userInput != entries.length + 1) {
                    System.out.println("Bad input");
                } else {
                    break;
                }

                String continueInput = "";

                while (true) {
                    System.out.println("Would you like to continue?(Y or N)");
                    continueInput = inputScanner.nextLine().toUpperCase();

                    if ("Y".equals(continueInput) ||"N".equals(continueInput)) {
                        break;
                    }

                    System.out.println("Sorry I do not understand. Enter Y or N");
                }

                if ("N".equals(continueInput)) {
                    break;
                }
            }
        } finally {
            inputScanner.close();
        }
        System.out.println("Thank you for your time!");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM YYY HH:mm");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current date and time is " + dateTimeFormatter.format(now));
    }
}