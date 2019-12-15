import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input amount of candidates:");

        int amountOfCandidates = in.nextInt();
        in.nextLine();
        String[][] mass = new String[amountOfCandidates][8];
        boolean[] bSatisfies = new boolean[amountOfCandidates];
        Arrays.fill(bSatisfies, true);

        String[] aEducation = {"Average", "Special", "Higher"};
        String[] aForeignLanguage = {"English", "Deutsch", "French"};
        String[] aLanguageLevel = {"Speak fluent language", "Read and translate with a dictionary"};
        String[] aComputerSkills = {"MSDOS", "Windows", "Linux"};
        String[] aRecommendation = {"Have recommendations", "Don't have recommendations"};

        for(int i = 0; i < amountOfCandidates; i++) {
            System.out.println("Candidate " + (i + 1));
            System.out.println("Input full name:");
            mass[i][0] = in.nextLine();
            System.out.println("Input year of birth:");
            mass[i][1] = in.nextLine();
            System.out.println("Choose education:\n");
            for(int j = 0; j < aEducation.length; j++) {
                System.out.println((j + 1) + ". " + aEducation[j]);
            }
            mass[i][2] = aEducation[in.nextInt() - 1];

            System.out.println("Choose knowledge of foreign languages:\n");
            for(int j = 0; j < aForeignLanguage.length; j++) {
                System.out.println((j + 1) + ". " + aForeignLanguage[j]);
            }
            mass[i][3] = aForeignLanguage[in.nextInt() - 1];

            System.out.println("Choose your language level\n");
            for(int j = 0; j < aLanguageLevel.length; j++) {
                System.out.println((j + 1) + ". " + aLanguageLevel[j]);
            }
            mass[i][4] = aLanguageLevel[in.nextInt() - 1];

            System.out.println("Choose computer skills:\n");
            for(int j = 0; j < aComputerSkills.length; j++) {
                System.out.println((j + 1) + ". " + aComputerSkills[j]);
            }
            mass[i][5] = aComputerSkills[in.nextInt() - 1];

            System.out.println("Input work experience");
            mass[i][6] = String.valueOf(in.nextInt());

            System.out.println("Do you have recommendations?\n");
            for(int j = 0; j < aRecommendation.length; j++) {
                System.out.println((j + 1) + ". " + aRecommendation[j]);
            }
            mass[i][7] = aRecommendation[in.nextInt() - 1];
            in.nextLine();
        }

        System.out.println("Table of candidates:");
        showMatrix(mass);


        System.out.println("Input requirements");
        int number;

        String str = "Choose year of birth:\n";
        Set yearsOfBirthSet = new HashSet();
        for (int j = 0; j < amountOfCandidates; j++) {
            yearsOfBirthSet.add(mass[j][1]);
        }

        chooseCriteria(in, str, yearsOfBirthSet.toArray(), 1, mass, bSatisfies);

        str = "Choose education:\n";
        chooseCriteria(in, str, aEducation, 3, mass, bSatisfies);

        str = "Knowledge of foreign languages:\n";
        chooseCriteria(in, str, aForeignLanguage, 3, mass, bSatisfies);

        str = "Language level:\n";
        chooseCriteria(in, str, aLanguageLevel, 4, mass, bSatisfies);

        str = "Computer skills:\n";
        chooseCriteria(in, str, aComputerSkills, 5, mass, bSatisfies);

        str = "Work experience:\n";
        Set experienceSet = new HashSet();
        for (int j = 0; j < amountOfCandidates; j++) {
            experienceSet.add(mass[j][6]);
        }
        chooseCriteria(in, "Work experience:\n", experienceSet.toArray(), 6, mass, bSatisfies);

        str = "Recommendations:\n";
        chooseCriteria(in, str, aRecommendation, 7, mass, bSatisfies);

//        for(int j = 0; j < bSatisfies.length; j++) {
//            System.out.print(bSatisfies[j] + " ");
//        }

        System.out.println("Results:");

        for (int i = 0; i < mass.length; i++) {
            if (bSatisfies[i]) {
                for (int j = 0; j < mass[i].length; j++) {
                    System.out.print(mass[i][j] + " ");
                }
                System.out.println();
            }
        }

//        showMatrix(mass);
    }

    public static void chooseCriteria(Scanner in, String str, Object[] criteria, int numberOfCriteria, String[][] m, boolean[] bSatisfies) {
        int number;

        for(int j = 0; j < criteria.length; j++) {
            str += (j + 1) + ". " + criteria[j] + "\n";
        }

        boolean[] bCriterias = new boolean[criteria.length];

        for (int i = 0; i < criteria.length; i++) {
            System.out.print(str);
            System.out.println((criteria.length + 1) + ". Go to next criterion\n");
            number = in.nextInt();
            if (number < criteria.length + 1 && number > 0) {
                bCriterias[number - 1] = true;
            } else {
                break;
            }
        }
        boolean bChanged = false;
        for(int j = 0; j < m.length; j++) {
            boolean bSuite = false;
            for(int k = 0; k < criteria.length; k++) {
                if (bCriterias[k]) {
                    bChanged = true;
                    if (!m[j][numberOfCriteria].equals(criteria[k])) {
                        bSuite = bSuite || false;

                    } else {
                        bSuite = true;
                    }
                }
            }
            if (bChanged) {
                bSatisfies[j] = bSuite;
            }
        }


    }

    public static void showMatrix(String[][] m) {
        for (String[] s : m) {
            for (String k : s) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
