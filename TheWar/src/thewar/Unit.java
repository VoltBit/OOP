package thewar;

import thewar.graph.Vector2d;

public class Unit {
    Vector2d pos,direction;
    double speed;
    double defence;
    double offence;
    char colour; /* 'r' or 'g' */
    Unit(Vector2d a, Vector2d b, double c, double d, double e, char f){
        this.pos = a;
        this.direction = b;
        this.speed = c;
        this.defence = d;
        this.offence = e;
        this.colour = f;
    }
}
