package tfar.moretridents.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.util.NonNullLazy;
import tfar.moretridents.ConfigurableTridentTier;
import tfar.moretridents.TieredTridentItem;
import tfar.moretridents.client.TieredTridentItemRenderer;

import java.util.function.Consumer;

public class TieredTridentItemForge extends TieredTridentItem {
    public TieredTridentItemForge(ConfigurableTridentTier configurableTridentTier, Properties properties) {
        super(configurableTridentTier, properties);
    }


    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private final NonNullLazy<BlockEntityWithoutLevelRenderer> ister = NonNullLazy.of(() -> new TieredTridentItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels()));

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return ister.get();
            }
        });
    }
}
