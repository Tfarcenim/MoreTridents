package tfar.moretridents.init;

import net.minecraft.world.item.Item;
import tfar.moretridents.TieredTridentItem;
import tfar.moretridents.TridentTiers;

public class ModItems {

    //Wooden, Iron, Gold, Diamond, Emerald, Lapis, Amethyst, and Netherite.
    public static final TieredTridentItem WOODEN_TRIDENT = new TieredTridentItem(TridentTiers.WOOD,new Item.Properties());
    public static final TieredTridentItem IRON_TRIDENT = new TieredTridentItem(TridentTiers.IRON,new Item.Properties());
    public static final TieredTridentItem GOLDEN_TRIDENT = new TieredTridentItem(TridentTiers.GOLD,new Item.Properties());
    public static final TieredTridentItem DIAMOND_TRIDENT = new TieredTridentItem(TridentTiers.DIAMOND,new Item.Properties());
    public static final TieredTridentItem EMERALD_TRIDENT = new TieredTridentItem(TridentTiers.EMERALD,new Item.Properties());
    public static final TieredTridentItem LAPIS_TRIDENT = new TieredTridentItem(TridentTiers.LAPIS,new Item.Properties());
    public static final TieredTridentItem AMETHYST_TRIDENT = new TieredTridentItem(TridentTiers.AMETHYST,new Item.Properties());
    public static final TieredTridentItem NETHERITE_TRIDENT = new TieredTridentItem(TridentTiers.NETHERITE,new Item.Properties());

}
