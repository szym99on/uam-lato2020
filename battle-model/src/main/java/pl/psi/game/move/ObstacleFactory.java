package pl.psi.game.move;

public class ObstacleFactory {

    public Obstacle createObstacle(String name){
        Obstacle obstacle = null;

    /*    if (name.equals("lava")){
            obstacle = new DealDamageObstacle(name);
        } else if (name.equals("marsh")) {
            obstacle = new ReduceMoveRangeObstacle();
        } else if (name.equals("river")){
            obstacle = new EndingMoveObstacle();
        } else {
            throw new IllegalArgumentException("Unknown obstacle: " + name);
        }
*/
        return obstacle;
    }
}
