import java.util.Arrays;

public class hand {
    private String[] specificHand;

    public hand(String[] uniqueHand) {
        this.specificHand = uniqueHand;
        for (int i = 0; i < uniqueHand.length; i++) {
            System.out.print(uniqueHand[i]);

        }
    }



    public String handStrengthCalc() {
        int count[] = {0, 0, 0, 0};
        int finalCount = 0;
        for (int i = 1; i < specificHand.length; i++) {
            if(specificHand[0].equals(specificHand[i])){
                count[0] += 1;
            }
        }
        if (count[0] == 4){
            return " Five of a kind";
        }
        for (int i = 2; i < specificHand.length; i++) {
            if(specificHand[1].equals(specificHand[i])){
                count[1] += 1;
            }
        }
        for (int i = 3; i < specificHand.length ; i++) {
            if(specificHand[2].equals(specificHand[i])){
                count[2]+= 1;
            }
        }
        for (int i = 4; i < specificHand.length; i++) {
            if(specificHand[3].equals(specificHand[i])){
                count[3] += 1;
            }
        }
        for (int i = 0; i < count.length; i++) {
            finalCount += count[i];
            if(count[i] == 3) {
                return " four of a kind";
            }
        }
        if (finalCount == 4){
            return " Full house";
        }
        if(finalCount == 3){
            return " three of a kind";
        }
        if(finalCount == 2){
            return " two pair";
        }
        if (finalCount == 1){
            return " pair";
        }
        else {
            return " high card";
        }

    }
}
