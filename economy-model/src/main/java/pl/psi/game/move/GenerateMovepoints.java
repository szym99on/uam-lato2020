package pl.psi.game.move;

class GenerateMovepoints {

    private boolean haveBoots;
    private boolean haveNecklace;
    private boolean haveGloves;
    private boolean haveHat;
    private boolean isOnWater;

    GenerateMovepoints(boolean aHaveBoots,  boolean aHaveGloves, boolean aHaveHat, boolean aHaveNecklace, boolean aIsOnWater){
        haveBoots = aHaveBoots;
        haveNecklace = aHaveNecklace;
        haveGloves = aHaveGloves;
        haveHat = aHaveHat;
        isOnWater = aIsOnWater;

    }

    private int basicMovementPoints(int speedTheSlowestCreature) {
            switch (speedTheSlowestCreature){
                case 3:
                    return 1500;

                case 4:
                    return 1560;

                case 5:
                    return 1630;

                case 6:
                    return 1700;

                case 7:
                    return 1760;

                case 8:
                    return 1830;

                case 9:
                    return 1900;

                case 10:
                    return 1960;

                default:
                    if(speedTheSlowestCreature >= 11){
                        return 2000;
                    }else{
                        throw new IllegalArgumentException("Wrong creature move speed");
                    }
            }
    }

    private int artifacts() {
            int value = 0;
            if(haveBoots){
                value += 600;
            } else {
                value += 0;
            }

            if(haveGloves){
                value += 300;
            } else {
                value += 0;
            }

            if(haveNecklace && isOnWater){
                value += 1000;
            } else {
                value += 0;
            }

            if(haveHat){
                value += 500;
            } else {
                value += 0;
            }

            return value;
        }

    public int movementPoints(int speedTheSlowestCreature) {

            int movementPoints = basicMovementPoints(speedTheSlowestCreature) + artifacts();

            if(movementPoints > 2000){
                return 2000;
            } else {
                return movementPoints;
            }
    }
}
