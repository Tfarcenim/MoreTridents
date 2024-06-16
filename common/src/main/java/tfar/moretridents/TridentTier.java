package tfar.moretridents;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.crafting.Ingredient;

public record TridentTier(int uses,float damage,int enchantmentValue,LazyLoadedValue<Ingredient> repairIngredient) {


}
