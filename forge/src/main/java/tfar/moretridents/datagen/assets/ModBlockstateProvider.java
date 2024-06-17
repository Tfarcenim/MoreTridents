package tfar.moretridents.datagen.assets;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.moretridents.MoreTridents;

public class ModBlockstateProvider extends BlockStateProvider {
    public ModBlockstateProvider(PackOutput gen, ExistingFileHelper exFileHelper) {
        super(gen, MoreTridents.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {}
}
