package tfar.moretridents.client;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModClientForge {

    public static void init(IEventBus bus) {
        bus.addListener(ModClientForge::setupRenderers);
    }

    static void setupRenderers(EntityRenderersEvent.RegisterRenderers event) {
        ModClient.setupRenderers();
    }

}
