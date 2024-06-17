package tfar.moretridents;

import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import tfar.moretridents.platform.Services;

public class TridentTiers {

    public static final ConfigurableTridentTier WOOD = new ConfigurableTridentTier(Services.PLATFORM.getConfig().wooden(), new LazyLoadedValue<>(() -> Ingredient.of(ItemTags.PLANKS)));
    public static final ConfigurableTridentTier IRON = new ConfigurableTridentTier(Services.PLATFORM.getConfig().iron(), new LazyLoadedValue<>(() -> Ingredient.of(Items.IRON_INGOT)));
    public static final ConfigurableTridentTier GOLD = new ConfigurableTridentTier(Services.PLATFORM.getConfig().gold(), new LazyLoadedValue<>(() -> Ingredient.of(Items.GOLD_INGOT)));
    public static final ConfigurableTridentTier DIAMOND = new ConfigurableTridentTier(Services.PLATFORM.getConfig().diamond(), new LazyLoadedValue<>(() -> Ingredient.of(Items.DIAMOND)));
    public static final ConfigurableTridentTier EMERALD = new ConfigurableTridentTier(Services.PLATFORM.getConfig().emerald(), new LazyLoadedValue<>(() -> Ingredient.of(Items.EMERALD)));
    public static final ConfigurableTridentTier LAPIS = new ConfigurableTridentTier(Services.PLATFORM.getConfig().lapis(), new LazyLoadedValue<>(() -> Ingredient.of(Items.LAPIS_LAZULI)));
    public static final ConfigurableTridentTier AMETHYST = new ConfigurableTridentTier(Services.PLATFORM.getConfig().amethyst(), new LazyLoadedValue<>(() -> Ingredient.of(Items.AMETHYST_SHARD)));
    public static final ConfigurableTridentTier NETHERITE = new ConfigurableTridentTier(Services.PLATFORM.getConfig().netherite(), new LazyLoadedValue<>(() -> Ingredient.of(Items.NETHERITE_INGOT)));

}
