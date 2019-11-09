public class Plate {
    int size;
    int filledPercent;
    String name;
    String colour;
    double price;
    boolean broken;
    boolean clean;

    void setDirty() {
        clean = false;
    }

    void clean(){
        clean = true;
    }

    void eatAll(){
        filledPercent = 0;
    }

    void breakPlate() {
        broken = true;
    }

    int getSize(){
        return size;
    }

    String getColour() {
        return colour;
    }

    double getPrice() {
        return price;
    }

    String getName() {
        return name;
    }

}

