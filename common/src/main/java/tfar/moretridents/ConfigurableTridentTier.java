package tfar.moretridents;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.crafting.Ingredient;
import tfar.moretridents.platform.TridentConfig;

public record ConfigurableTridentTier(TridentConfig tridentConfig, LazyLoadedValue<Ingredient> repairIngredient) {


}
