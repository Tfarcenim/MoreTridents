package tfar.moretridents.init;

import net.minecraft.world.item.Item;
import tfar.moretridents.TieredTridentItem;
import tfar.moretridents.TridentTiers;

public class ModItems {

    //Wooden, Iron, Gold, Diamond, Emerald, Lapis, Amethyst, and Netherite.
    public static final Item WOODEN_TRIDENT = new TieredTridentItem(TridentTiers.WOOD,new Item.Properties());
    public static final Item IRON_TRIDENT = new TieredTridentItem(TridentTiers.IRON,new Item.Properties());
    public static final Item GOLDEN_TRIDENT = new TieredTridentItem(TridentTiers.GOLD,new Item.Properties());
    public static final Item DIAMOND_TRIDENT = new TieredTridentItem(TridentTiers.DIAMOND,new Item.Properties());
    public static final Item EMERALD_TRIDENT = new TieredTridentItem(TridentTiers.EMERALD,new Item.Properties());
    public static final Item LAPIS_TRIDENT = new TieredTridentItem(TridentTiers.LAPIS,new Item.Properties());
    public static final Item AMETHYST_TRIDENT = new TieredTridentItem(TridentTiers.AMETHYST,new Item.Properties());
    public static final Item NETHERITE_TRIDENT = new TieredTridentItem(TridentTiers.NETHERITE,new Item.Properties());

}
