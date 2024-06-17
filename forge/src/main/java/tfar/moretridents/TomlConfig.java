package tfar.moretridents;

import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Triple;
import tfar.moretridents.platform.MLConfig;
import tfar.moretridents.platform.TridentConfig;

import java.util.HashMap;
import java.util.Map;

public class TomlConfig implements MLConfig {

    //Wooden, Iron, Gold, Diamond, Emerald, Lapis, Amethyst, and Netherite.

    @Override
    public TridentConfig wooden() {
        return Server.WOOD;
    }

    @Override
    public TridentConfig iron() {
        return Server.IRON;
    }

    @Override
    public TridentConfig gold() {
        return Server.GOLD;
    }

    @Override
    public TridentConfig diamond() {
        return Server.DIAMOND;
    }

    @Override
    public TridentConfig emerald() {
        return Server.EMERALD;
    }

    @Override
    public TridentConfig lapis() {
        return Server.LAPIS;
    }

    @Override
    public TridentConfig amethyst() {
        return Server.AMETHYST;
    }

    @Override
    public TridentConfig netherite() {
        return Server.NETHERITE;
    }

    public static class Server {

        public static TridentConfig WOOD;
        public static TridentConfig IRON;
        public static TridentConfig GOLD;
        public static TridentConfig DIAMOND;
        public static TridentConfig EMERALD;
        public static TridentConfig LAPIS;
        public static TridentConfig AMETHYST;
        public static TridentConfig NETHERITE;




        static final Map<String, Triple<Integer,Double,Integer>> defaults = new HashMap<>();

        static {
            defaults.put("wood",Triple.of(Tiers.WOOD.getUses(), (double) Tiers.WOOD.getAttackDamageBonus(),Tiers.WOOD.getEnchantmentValue()));
            defaults.put("iron",Triple.of(Tiers.IRON.getUses(), (double) Tiers.IRON.getAttackDamageBonus(),Tiers.IRON.getEnchantmentValue()));
            defaults.put("gold",Triple.of(Tiers.GOLD.getUses(), (double) Tiers.GOLD.getAttackDamageBonus(),Tiers.GOLD.getEnchantmentValue()));
            defaults.put("diamond",Triple.of(Tiers.DIAMOND.getUses(), (double) Tiers.DIAMOND.getAttackDamageBonus(),Tiers.DIAMOND.getEnchantmentValue()));
            defaults.put("emerald",Triple.of(1600,(double) Tiers.DIAMOND.getAttackDamageBonus()+Tiers.WOOD.getEnchantmentValue(),Tiers.DIAMOND.getEnchantmentValue()));
            defaults.put("lapis",Triple.of(320,(double) Tiers.IRON.getAttackDamageBonus(),Tiers.IRON.getEnchantmentValue()+5));
            defaults.put("amethyst",Triple.of(640,(double) Tiers.IRON.getAttackDamageBonus(),Tiers.IRON.getEnchantmentValue()+10));
            defaults.put("netherite",Triple.of(Tiers.NETHERITE.getUses(), (double) Tiers.NETHERITE.getAttackDamageBonus(),Tiers.NETHERITE.getEnchantmentValue()));

        }

        public Server(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            WOOD = buildGroup(builder,"wood");
            IRON = buildGroup(builder,"iron");
            GOLD = buildGroup(builder,"gold");
            DIAMOND = buildGroup(builder,"diamond");
            EMERALD = buildGroup(builder,"emerald");
            LAPIS = buildGroup(builder,"lapis");
            AMETHYST = buildGroup(builder,"amethyst");
            NETHERITE = buildGroup(builder,"netherite");
            builder.pop();
        }

        static TridentConfig buildGroup(ForgeConfigSpec.Builder builder, String type) {
            builder.push(type);
            Triple<Integer,Double,Integer> tierDefaults = defaults.get(type);
            ForgeConfigSpec.IntValue uses = builder.defineInRange("uses",tierDefaults.getLeft(),1,Integer.MAX_VALUE);
            ForgeConfigSpec.DoubleValue damage = builder.defineInRange("damage",tierDefaults.getMiddle(),0,Double.MAX_VALUE);
            ForgeConfigSpec.IntValue enchantability = builder.defineInRange("enchantability",tierDefaults.getRight(),1,Integer.MAX_VALUE);
            builder.pop();

            return new TridentConfig() {
                @Override
                public int uses() {
                    return uses.get();
                }

                @Override
                public double damage() {
                    return damage.get();
                }

                @Override
                public int enchantability() {
                    return enchantability.get();
                }
            };

        }

    }

}
