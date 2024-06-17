package tfar.moretridents.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import tfar.moretridents.entity.ThrownTieredTridentEntity;

public class ModEntityTypes {

    public static final EntityType<ThrownTieredTridentEntity> TIERED_TRIDENT = EntityType.Builder.<ThrownTieredTridentEntity>of(ThrownTieredTridentEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("");
}
