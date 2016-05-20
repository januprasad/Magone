package com.xoul.ru.magone.model;

public abstract class Effect {
    private int timeleft;
    private boolean available;
    public EffectType type;

    public Effect(int timeleft, boolean available,EffectType type) {
        this.timeleft = timeleft;
        this.available = available;
        this.type = type;
    }

    public Damage damage(Damage damage) {
        return damage;
    }

    public Heal heal(Heal healAmmount) {
        return healAmmount;
    }

    public int endTurnEffect(int BuffAmmount) {
        return BuffAmmount;
    }

    public boolean isAvailable() {
        return available;
    }

    public void endOfTurn() {
        timeleft--;
        if (timeleft < 1) {
            unavailable();
        }
    }

    private void unavailable(){
        available = false;
    }

    public abstract boolean isOpposite(EffectType type);
}
