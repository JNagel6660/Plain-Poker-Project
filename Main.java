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


        for (String line : lines) {
            String[] numbers = line.split("\\|");
            System.out.println(Arrays.toString(numbers));
            String[] cards = numbers[0].split(",");
            String bid = numbers[1];
            hand h = new hand(cards);
            h.handStrengthCalc();
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
        }
        System.out.println("Number of five of a kinds = " + fiveOAK);
        System.out.println("Number of four of a kinds = " + fourOAK);
        System.out.println("Number of full houses = " + fullHouse);
        System.out.println("Number of three of a kinds = " + trips);
        System.out.println("Number of two pairs = " + twoPair);
        System.out.println("Number of pairs = " + pair);
        System.out.println("Number of high cards = " + highCard);


    }
}