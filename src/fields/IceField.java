package fields;

public abstract class IceField extends Field {
    public IceField(){
        super();
    }

    //Iglu építése
    @Override
    public boolean buildIgloo() {
        return false;
    }

    @Override
    public boolean buildTent() {
        return false;
    }


}
