package tfar.moretridents;

import net.minecraft.world.item.TridentItem;

public class TieredTridentItem extends TridentItem {
    private final TridentTier tridentTier;

    public TieredTridentItem(TridentTier tridentTier, Properties properties) {
        super(properties.defaultDurability(tridentTier.uses()));
        this.tridentTier = tridentTier;
    }

    public TridentTier getTridentTier() {
        return tridentTier;
    }
}
