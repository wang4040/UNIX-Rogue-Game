package src;
public class Displayable{
    Displayable(){
        System.out.println("Displayable");
    }
    void setInvisible(){
        System.out.println("setInvisible");
    }

    void setVisible(){
        System.out.println("setVisible");
    }

    void setMaxHit(int maxHit){
        System.out.println("setMaxHit maxHit: " + maxHit);
    }

    void setHpMove(int hpMoves){
        System.out.println("setHpMove Displayable hpMoves: " + hpMoves);
    }

    void setHp(int Hp){
        System.out.println("setHp Displayable Hp: " + Hp);
    }

    void setType(char t){
        System.out.println("setType t: " + t);
    }

    void setIntValue(int v){
        System.out.println("setIntValue v: " + v);
    }

    void SetPosX(int x){
        System.out.println("SetPosX x: " + x);
    }

    void setPosY(int y){
        System.out.println("setPosY y: " + y);
    }

    void SetWidth(int x){
        System.out.println("SetWidth x: " + x);
    }

    void setHeight(int y){
        System.out.println("setHeight y: " + y);
    }
}