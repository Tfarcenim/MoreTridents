package tfar.moretridents.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import tfar.moretridents.TieredTridentItem;

public class TieredTridentItemRenderer extends BlockEntityWithoutLevelRenderer {
    public TieredTridentItemRenderer(BlockEntityRenderDispatcher $$0, EntityModelSet $$1) {
        super($$0, $$1);
    }

    public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if (pStack.getItem() instanceof TieredTridentItem tieredTridentItem) {
            pPoseStack.pushPose();
            pPoseStack.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer consumer = ItemRenderer.getFoilBufferDirect(pBuffer, Minecraft.getInstance().getBlockRenderer().blockEntityRenderer.tridentModel.renderType(tieredTridentItem.getTridentTier().entityTexture()), false, pStack.hasFoil());
            Minecraft.getInstance().getBlockRenderer().blockEntityRenderer.tridentModel.renderToBuffer(pPoseStack, consumer, pPackedLight, pPackedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            pPoseStack.popPose();
        }
    }
}
