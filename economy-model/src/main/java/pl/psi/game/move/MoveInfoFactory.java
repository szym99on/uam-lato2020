package pl.psi.game.move;

public class MoveInfoFactory {

    int movementPoints(int speedTheSlowestCreature){
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
                    return 0;
                }
        }
    }

}
