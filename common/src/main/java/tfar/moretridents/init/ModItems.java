package tfar.moretridents.init;

import net.minecraft.world.item.Item;
import tfar.moretridents.TieredTridentItem;
import tfar.moretridents.TridentTiers;
import tfar.moretridents.platform.Services;

public class ModItems {

    //Wooden, Iron, Gold, Diamond, Emerald, Lapis, Amethyst, and Netherite.
    public static final TieredTridentItem WOODEN_TRIDENT = Services.PLATFORM.makeTrident(TridentTiers.WOOD,new Item.Properties());
    public static final TieredTridentItem IRON_TRIDENT = Services.PLATFORM.makeTrident(TridentTiers.IRON,new Item.Properties());
    public static final TieredTridentItem GOLDEN_TRIDENT = Services.PLATFORM.makeTrident(TridentTiers.GOLD,new Item.Properties());
    public static final TieredTridentItem DIAMOND_TRIDENT = Services.PLATFORM.makeTrident(TridentTiers.DIAMOND,new Item.Properties());
    public static final TieredTridentItem EMERALD_TRIDENT = Services.PLATFORM.makeTrident(TridentTiers.EMERALD,new Item.Properties());
    public static final TieredTridentItem LAPIS_TRIDENT = Services.PLATFORM.makeTrident(TridentTiers.LAPIS,new Item.Properties());
    public static final TieredTridentItem AMETHYST_TRIDENT = Services.PLATFORM.makeTrident(TridentTiers.AMETHYST,new Item.Properties());
    public static final TieredTridentItem NETHERITE_TRIDENT = Services.PLATFORM.makeTrident(TridentTiers.NETHERITE,new Item.Properties());

}
