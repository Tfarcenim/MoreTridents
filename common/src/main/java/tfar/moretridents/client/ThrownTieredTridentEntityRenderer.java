package tfar.moretridents.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownTridentRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.ThrownTrident;
import tfar.moretridents.entity.ThrownTieredTridentEntity;

public class ThrownTieredTridentEntityRenderer extends ThrownTridentRenderer {


    public static final ResourceLocation TRIDENT_LOCATION = new ResourceLocation("textures/entity/trident.png");


    public ThrownTieredTridentEntityRenderer(EntityRendererProvider.Context $$0) {
        super($$0);
    }


    @Override
    public ResourceLocation getTextureLocation(ThrownTrident trident) {
        return ((ThrownTieredTridentEntity)trident).getOrCreateTridentTexture();
    }
}
