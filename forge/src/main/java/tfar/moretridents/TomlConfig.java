package tfar.moretridents;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Triple;
import tfar.moretridents.platform.MLConfig;
import tfar.moretridents.platform.TridentConfig;

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
            Triple<Integer,Double,Integer> tierDefaults = MoreTridents.defaults.get(type);
            ForgeConfigSpec.IntValue uses = builder.defineInRange("uses",tierDefaults.getLeft(),1,Integer.MAX_VALUE);
            ForgeConfigSpec.DoubleValue damage = builder.defineInRange("damage",tierDefaults.getMiddle(),-8,Double.MAX_VALUE);
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
