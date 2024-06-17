package tfar.moretridents.platform;

import net.minecraft.world.item.Tiers;
import org.apache.commons.lang3.tuple.Triple;
import tfar.moretridents.MoreTridents;

public interface MLConfig {



    //Wooden, Iron, Gold, Diamond, Emerald, Lapis, Amethyst, and Netherite.
    TridentConfig wooden();
    TridentConfig iron();
    TridentConfig gold();
    TridentConfig diamond();
    TridentConfig emerald();
    TridentConfig lapis();
    TridentConfig amethyst();
    TridentConfig netherite();

}
