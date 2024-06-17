package tfar.moretridents;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;

public class TieredTridentItem extends TridentItem {
    private final ConfigurableTridentTier configurableTridentTier;

    public TieredTridentItem(ConfigurableTridentTier configurableTridentTier, Properties properties) {
        super(properties);
        this.configurableTridentTier = configurableTridentTier;
    }

    public ConfigurableTridentTier getTridentTier() {
        return configurableTridentTier;
    }

    @Override
    public int getMaxDamage() {
        return getTridentTier().tridentConfig().uses();
    }

    @Override
    public int getEnchantmentValue() {
        return getTridentTier().tridentConfig().enchantability();
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return getTridentTier().repairIngredient().get().test(pRepair) || super.isValidRepairItem(pToRepair, pRepair);
    }


}
