package tfar.moretridents.platform;

import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import tfar.moretridents.ConfigurableTridentTier;
import tfar.moretridents.TieredTridentItem;
import tfar.moretridents.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public <F> void registerAll(Class<?> clazz, Registry<? extends F> registry, Class<F> filter) {

    }

    @Override
    public MLConfig getConfig() {
        return null;
    }

    @Override
    public TieredTridentItem makeTrident(ConfigurableTridentTier configurableTridentTier, Item.Properties properties) {
        return null;
    }
}
