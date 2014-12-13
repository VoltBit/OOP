package thewar3;

public class SceneInfo {
    public float distance;
    public Vector2d stangaSus;
    public Vector2d dreaptaJos;
    public float unitDistance;
    public float conexSize;
    public float supplementaryDefense;
    DebugDrawPosition DrawSystem;
    public SceneInfo(){
        
    }
    public SceneInfo(float dist, Vector2d leftUp, Vector2d rightDown, float uD,
            float conxSize, float suppDeff){
        this.distance = dist;
        this.stangaSus = leftUp;
        this.dreaptaJos = rightDown;
        this.unitDistance = uD;
        this.conexSize = conxSize;
        this.supplementaryDefense = suppDeff;
    }
}
