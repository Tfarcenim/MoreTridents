package tfar.moretridents.datagen.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import tfar.moretridents.MoreTridents;

import java.util.stream.Collectors;

public class ModBlockLoot extends VanillaBlockLoot {

    @Override
    protected void generate() {
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getValues().stream()
                .filter(b -> BuiltInRegistries.BLOCK.getKey(b).getNamespace().equals(MoreTridents.MOD_ID))
                .collect(Collectors.toList());
    }
}
