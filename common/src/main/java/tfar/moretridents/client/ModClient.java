package tfar.moretridents.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import tfar.moretridents.init.ModEntityTypes;

public class ModClient {


    public static void setupRenderers() {
        EntityRenderers.register(ModEntityTypes.TIERED_TRIDENT,ThrownTieredTridentEntityRenderer::new);
    }

}
