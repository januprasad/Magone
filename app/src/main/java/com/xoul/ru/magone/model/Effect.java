package com.xoul.ru.magone.model;

public abstract class Effect {
    private int timeleft;
    private boolean available;
    public EffectType type;
    private int healAmmount;
    private  int damageAmmount;

    public Effect(int timeleft, boolean available, EffectType type, int healAmmount, int damageAmmount) {
        this.timeleft = timeleft;
        this.available = available;
        this.type = type;
        this.healAmmount = healAmmount;
        this.damageAmmount = damageAmmount;
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

    public void endOfTurn(PlayerModel currentPlayer) {
        timeleft--;
        if (timeleft < 1) {
            unavailable();
        }
        currentPlayer.endTurnEffect(healAmmount,damageAmmount);
    }

    private void unavailable(){
        available = false;
    }

    public abstract boolean isOpposite(EffectType type);
}
