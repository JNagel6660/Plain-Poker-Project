import java.util.Arrays;

public class hand {
    private String[] specificHand;
    private int handPower;


    public hand(String[] uniqueHand) {
        this.specificHand = uniqueHand;
        for (int i = 0; i < uniqueHand.length; i++) {
            System.out.print(uniqueHand[i]);

        }
    }

    public int getHandPower() {
        return handPower;
    }

    public String[] getSpecificHand(){
        return specificHand;
    }

    public String handStrengthCalc() {
        int count[] = {0, 0, 0, 0};
        int finalCount = 0;
        int jackCount = 0;
        for (int i = 1; i < specificHand.length; i++) {
            if(specificHand[0].equals(specificHand[i])){
                count[0] += 1;
            }
        }
        if (count[0] == 4){
            this.handPower = 6;
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
            if (specificHand[i].equals("Jack")) {
                jackCount += 1;
            }
            if (jackCount == 4) {
                this.handPower = 6;
                return " Five of a kind";
            }
        }
        if (finalCount == 6){
            if (jackCount == 1){
                this.handPower = 6;
                return " Five of a kind";
            }else {
                this.handPower = 5;
                return " four of a kind";
            }
        }
            System.out.println(jackCount);


        if (finalCount == 4){
            if (jackCount == 0){
            this.handPower = 4;
            return " Full house";
        }
            if (jackCount == 2 || jackCount == 3){
                this.handPower = 6;
                return " Five of a kind";
            }

        }
        if(finalCount == 3){
            if (jackCount == 1 || jackCount == 2 || jackCount == 3){
                this.handPower = 5;
                return " four of a kind";
            } else {
                this.handPower = 3;
                return " three of a kind";
            }

        }
        if(finalCount == 2){
            if (jackCount == 2){
                this.handPower = 5;
                return " four of a kind";
            } else if (jackCount == 1) {
                this.handPower = 4;
                return " Full house";

            }else {
                this.handPower = 2;
                return " two pair";
            }
        }
        if (finalCount == 1) {
            if (jackCount == 1) {
                this.handPower = 3;
                return " three of a kind";
            } else if (jackCount == 2) {
                this.handPower = 3;
                return " three of a kind";
            } else {
                this.handPower = 1;
                return " pair";
            }
        }
        else {
            this.handPower = 0;
            return " high card";
        }
    }




}
