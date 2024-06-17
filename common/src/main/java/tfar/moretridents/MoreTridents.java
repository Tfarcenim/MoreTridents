package tfar.moretridents;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import org.apache.commons.lang3.tuple.Triple;
import tfar.moretridents.init.ModEntityTypes;
import tfar.moretridents.init.ModItems;
import tfar.moretridents.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class MoreTridents {

    public static final String MOD_ID = "moretridents";
    public static final String MOD_NAME = "MoreTridents";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);
    public static final Map<String, Triple<Integer,Double,Integer>> defaults = new HashMap<>();

    static {
        MoreTridents.defaults.put("wood", Triple.of(Tiers.WOOD.getUses(),-2d, Tiers.WOOD.getEnchantmentValue()));
        MoreTridents.defaults.put("iron", Triple.of(Tiers.IRON.getUses(), (double) Tiers.IRON.getAttackDamageBonus(), Tiers.IRON.getEnchantmentValue()));
        MoreTridents.defaults.put("gold", Triple.of(Tiers.GOLD.getUses(), (double) Tiers.GOLD.getAttackDamageBonus(), Tiers.GOLD.getEnchantmentValue()));
        MoreTridents.defaults.put("diamond", Triple.of(Tiers.DIAMOND.getUses(), (double) Tiers.DIAMOND.getAttackDamageBonus(), Tiers.DIAMOND.getEnchantmentValue()));
        MoreTridents.defaults.put("emerald", Triple.of(1600, (double) Tiers.DIAMOND.getAttackDamageBonus() + Tiers.WOOD.getEnchantmentValue(), Tiers.DIAMOND.getEnchantmentValue()));
        MoreTridents.defaults.put("lapis", Triple.of(320, (double) Tiers.IRON.getAttackDamageBonus(), Tiers.IRON.getEnchantmentValue() + 5));
        MoreTridents.defaults.put("amethyst", Triple.of(640, (double) Tiers.IRON.getAttackDamageBonus(), Tiers.IRON.getEnchantmentValue() + 10));
        MoreTridents.defaults.put("netherite", Triple.of(Tiers.NETHERITE.getUses(), (double) Tiers.NETHERITE.getAttackDamageBonus(), Tiers.NETHERITE.getEnchantmentValue()));
    }

    // The loader specific projects are able to import and use any code from the common project. This allows you to
    // write the majority of your code here and load it from your loader specific projects. This example has some
    // code that gets invoked by the entry point of the loader specific projects.
    public static void init() {
        Services.PLATFORM.registerAll(ModItems.class,BuiltInRegistries.ITEM, Item.class);
        Services.PLATFORM.registerAll(ModEntityTypes.class,BuiltInRegistries.ENTITY_TYPE, EntityType.class);
    }


    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID,path);
    }

}