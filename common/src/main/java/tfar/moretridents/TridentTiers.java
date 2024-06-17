package tfar.moretridents;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import tfar.moretridents.platform.Services;

public class TridentTiers {

    public static final ConfigurableTridentTier WOOD = new ConfigurableTridentTier(Services.PLATFORM.getConfig().wooden(), new LazyLoadedValue<>(() -> Ingredient.of(ItemTags.PLANKS)),create("wooden"));
    public static final ConfigurableTridentTier IRON = new ConfigurableTridentTier(Services.PLATFORM.getConfig().iron(), new LazyLoadedValue<>(() -> Ingredient.of(Items.IRON_INGOT)),create("iron"));
    public static final ConfigurableTridentTier GOLD = new ConfigurableTridentTier(Services.PLATFORM.getConfig().gold(), new LazyLoadedValue<>(() -> Ingredient.of(Items.GOLD_INGOT)),create("golden"));
    public static final ConfigurableTridentTier DIAMOND = new ConfigurableTridentTier(Services.PLATFORM.getConfig().diamond(), new LazyLoadedValue<>(() -> Ingredient.of(Items.DIAMOND)),create("diamond"));
    public static final ConfigurableTridentTier EMERALD = new ConfigurableTridentTier(Services.PLATFORM.getConfig().emerald(), new LazyLoadedValue<>(() -> Ingredient.of(Items.EMERALD)),create("emerald"));
    public static final ConfigurableTridentTier LAPIS = new ConfigurableTridentTier(Services.PLATFORM.getConfig().lapis(), new LazyLoadedValue<>(() -> Ingredient.of(Items.LAPIS_LAZULI)),create("lapis"));
    public static final ConfigurableTridentTier AMETHYST = new ConfigurableTridentTier(Services.PLATFORM.getConfig().amethyst(), new LazyLoadedValue<>(() -> Ingredient.of(Items.AMETHYST_SHARD)),create("amethyst"));
    public static final ConfigurableTridentTier NETHERITE = new ConfigurableTridentTier(Services.PLATFORM.getConfig().netherite(), new LazyLoadedValue<>(() -> Ingredient.of(Items.NETHERITE_INGOT)),create("netherite"));


    static ResourceLocation create(String type) {
        return MoreTridents.id("textures/entity/"+type+"_trident.png");
    }

}
