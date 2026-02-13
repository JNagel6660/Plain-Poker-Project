import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int fiveOAK = 0;
        int fourOAK = 0;
        int fullHouse = 0;
        int trips = 0;
        int twoPair = 0;
        int pair = 0;
        int highCard = 0;

        String fileData = "";
        try{
            File f = new File("src/data");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()){
                String line = s.nextLine();
                fileData += line + "\n";
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        System.out.println(fileData);
        String[] lines = fileData.split("\n");

        hand[] allHands = new hand[lines.length];
        int[] rankings = new int[lines.length];
        String[] hand1 = new String[4];
        String[] hand2 = new String[4];
        String[] allBids = new String[lines.length];


        int lineNumber = 0;
        int rankDummy;
        int lineDummy;
        for (String line : lines ) {
            String[] numbers = line.split("\\|");
            System.out.println(Arrays.toString(numbers));
            String[] cards = numbers[0].split(",");
            allBids[lineNumber] = numbers[1];
            hand h = new hand(cards);
            h.handStrengthCalc();
            allHands[lineNumber] = h;
            System.out.println(h.handStrengthCalc());
            if (h.handStrengthCalc().equals(" Five of a kind")){
                fiveOAK += 1;
            }
            if (h.handStrengthCalc().equals(" four of a kind")){
                fourOAK += 1;
            }
            if(h.handStrengthCalc().equals(" three of a kind")){
                trips += 1;
            }
            if(h.handStrengthCalc().equals(" Full house")){
                fullHouse += 1;
            }
            if (h.handStrengthCalc().equals(" pair")){
                pair += 1;
            }
            if (h.handStrengthCalc().equals(" two pair")){
                twoPair += 1;
            }
            if(h.handStrengthCalc().equals(" high card")){
                highCard += 1;
            }

            lineNumber++;
        }

        for (int i = 0; i < allHands.length; i++) {
            for (int j = i + 1; j < allHands.length; j++) {
                if(allHands[i].getHandPower() > allHands[j].getHandPower()){
                    System.out.println("hello");
                    rankings[i] += 1;
                } else if (allHands[i].getHandPower() == allHands[j].getHandPower()) {
                    hand1 = allHands[i].getSpecificHand();
                    hand2 = allHands[j].getSpecificHand();
                    for (int k = 0; k < hand1.length; k++) {
                        if (hand1[k].equals("Ace") && !hand2[k].equals("Ace")){
                            rankings[i] += 1;
                            k = 1000;
                        } else if ((hand1[k].equals("King") && (!hand2[k].equals("King")) && !hand2[k].equals("Ace"))){
                            rankings[i] += 1;
                            k = 1000;
                        } else if ((hand1[k].equals("Queen") && ((!hand2[k].equals("Queen")) && (!hand2[k].equals("Ace") && !hand2[k].equals("King"))))) {
                            rankings[i] += 1;
                            k = 1000;
                        } else if (hand1[k].equals("Jack") && (!hand2[k].equals("Jack"))) {
                            k = 1000;
                        } else if (hand1[k].compareTo(hand2[k]) > 0){
                            rankings[i] += 1;
                            k = 1000;
                        } else if (hand1[k].compareTo(hand2[k]) < 0) {
                            k = 1000;
                        }

                    }



                }
            }
            for (int k = i - 1; k >= 0 ; k--) {
                if(allHands[i].getHandPower() > allHands[k].getHandPower()){
                    rankings[i] += 1;
                    System.out.println("hello");
                } else if (allHands[i].getHandPower() == allHands[k].getHandPower()) {
                    hand1 = allHands[i].getSpecificHand();
                    hand2 = allHands[k].getSpecificHand();
                    for (int p = 0; p < hand1.length; p++) {
                        if (hand1[p].equals("Ace") && !hand2[p].equals("Ace")){
                            rankings[i] += 1;
                            p = 1000;
                        } else if ((hand1[p].equals("King") && (!hand2[p].equals("King")) && !hand2[p].equals("Ace"))){
                            rankings[i] += 1;
                            p = 1000;
                        } else if (((hand1[p].equals("Queen")) && ((!hand2[p].equals("Queen"))) && (!hand2[p].equals("Ace") && !hand2[p].equals("King")))) {
                            rankings[i] += 1;
                            p = 1000;
                        } else if (hand1[p].equals("Jack") && (!hand2[p].equals("Jack"))) {
                            p = 1000;
                        } else if (hand1[p].compareTo(hand2[p]) > 0){
                            rankings[i] += 1;
                            p = 1000;
                        } else if (hand1[p].compareTo(hand2[p]) < 0) {
                            p = 1000;
                        }

                    }


                }


            }
            rankings[i] += 1;



        }
        int bidVal = 0;
        int total = 0;
        for (int i = 0; i < rankings.length; i++) {
            bidVal = Integer.parseInt(allBids[i]);
            rankings[i] = rankings[i] * bidVal;
            total += rankings[i];
        }

        System.out.println(Arrays.toString(rankings));
        System.out.println("Number of five of a kinds = " + fiveOAK);
        System.out.println("Number of four of a kinds = " + fourOAK);
        System.out.println("Number of full houses = " + fullHouse);
        System.out.println("Number of three of a kinds = " + trips);
        System.out.println("Number of two pairs = " + twoPair);
        System.out.println("Number of pairs = " + pair);
        System.out.println("Number of high cards = " + highCard);
        System.out.println("total bid values with jack wild = " + total);
    }
}