package tfar.moretridents.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import tfar.moretridents.MoreTridents;
import tfar.moretridents.TieredTridentItem;
import tfar.moretridents.init.ModEntityTypes;

public class ThrownTieredTridentEntity extends ThrownTrident {

    private static final EntityDataAccessor<String> DATA_TIER = SynchedEntityData.defineId(ThrownTieredTridentEntity.class, EntityDataSerializers.STRING);

    public ThrownTieredTridentEntity(EntityType<? extends ThrownTrident> $$0, Level $$1) {
        super($$0, $$1);
    }

    public ThrownTieredTridentEntity(Level $$0, LivingEntity $$1, ItemStack stack) {
        super($$0, $$1, stack);
        if (stack.getItem() instanceof TieredTridentItem tieredTridentItem) {
            setTier(tieredTridentItem.getTridentTier().entityTexture().toString());
        }
    }


    @Override
    public EntityType<?> getType() {
        return ModEntityTypes.TIERED_TRIDENT;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_TIER,"wooden");
    }

    public String getTier() {
        return entityData.get(DATA_TIER);
    }

    void setTier(String tier) {
        entityData.set(DATA_TIER,tier);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        Entity entity = pResult.getEntity();

        double damage = TridentItem.BASE_DAMAGE;
        Item item = tridentItem.getItem();

        if (item instanceof TieredTridentItem tieredTridentItem) {
            damage+= tieredTridentItem.getTridentTier().tridentConfig().damage();
        }

        if (entity instanceof LivingEntity livingentity) {
            damage += EnchantmentHelper.getDamageBonus(this.tridentItem, livingentity.getMobType());
        }

        Entity entity1 = this.getOwner();
        DamageSource damagesource = this.damageSources().trident(this, entity1 == null ? this : entity1);
        this.dealtDamage = true;
        SoundEvent soundevent = SoundEvents.TRIDENT_HIT;
        if (entity.hurt(damagesource, (float) damage)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity livingentity1) {
                if (entity1 instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingentity1, entity1);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity)entity1, livingentity1);
                }

                this.doPostHurtEffects(livingentity1);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        float f1 = 1.0F;
        if (this.level() instanceof ServerLevel && this.level().isThundering() && this.isChanneling()) {
            BlockPos blockpos = entity.blockPosition();
            if (this.level().canSeeSky(blockpos)) {
                LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(this.level());
                if (lightningbolt != null) {
                    lightningbolt.moveTo(Vec3.atBottomCenterOf(blockpos));
                    lightningbolt.setCause(entity1 instanceof ServerPlayer ? (ServerPlayer)entity1 : null);
                    this.level().addFreshEntity(lightningbolt);
                    soundevent = SoundEvents.TRIDENT_THUNDER;
                    f1 = 5.0F;
                }
            }
        }
        this.playSound(soundevent, f1, 1.0F);
    }

    ResourceLocation tridentTexture;

    public ResourceLocation getOrCreateTridentTexture() {
        if (tridentTexture == null){
            tridentTexture = new ResourceLocation(getTier());
        }
        return tridentTexture;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("texture",getTier());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setTier(tag.getString("texture"));
    }
}
