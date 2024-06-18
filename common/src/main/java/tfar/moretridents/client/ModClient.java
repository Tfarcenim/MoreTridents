package tfar.moretridents.client;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import tfar.moretridents.init.ModEntityTypes;
import tfar.moretridents.init.ModItems;

public class ModClient {


    public static void setupRenderers() {
        EntityRenderers.register(ModEntityTypes.TIERED_TRIDENT,ThrownTieredTridentEntityRenderer::new);
        registerThrowing(ModItems.WOODEN_TRIDENT);
        registerThrowing(ModItems.IRON_TRIDENT);
        registerThrowing(ModItems.GOLDEN_TRIDENT);
        registerThrowing(ModItems.DIAMOND_TRIDENT);
        registerThrowing(ModItems.EMERALD_TRIDENT);
        registerThrowing(ModItems.LAPIS_TRIDENT);
        registerThrowing(ModItems.AMETHYST_TRIDENT);
        registerThrowing(ModItems.NETHERITE_TRIDENT);


    }
    static void registerThrowing(Item item) {
        ItemProperties.register(item, new ResourceLocation("throwing"), ModClient::unclampedCall);

    }

    private static float unclampedCall(ItemStack stack, ClientLevel clientLevel, LivingEntity living, int i) {
        return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F;
    }
}
