package tfar.moretridents;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import tfar.moretridents.entity.ThrownTieredTridentEntity;

public class TieredTridentItem extends TridentItem {
    private final ConfigurableTridentTier configurableTridentTier;
    protected ImmutableMultimap<Attribute, AttributeModifier> defaultModifiers1;

    public TieredTridentItem(ConfigurableTridentTier configurableTridentTier, Properties properties) {
        super(properties);
        this.configurableTridentTier = configurableTridentTier;
    }

    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            int i = this.getUseDuration(pStack) - pTimeLeft;
            if (i >= 10) {
                int j = EnchantmentHelper.getRiptide(pStack);
                if (j <= 0 || player.isInWaterOrRain()) {
                    if (!pLevel.isClientSide) {
                        pStack.hurtAndBreak(1, player, (player1) -> player1.broadcastBreakEvent(pEntityLiving.getUsedItemHand()));
                        if (j == 0) {
                            ThrownTrident throwntrident = new ThrownTieredTridentEntity(pLevel, player, pStack);
                            throwntrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + j * 0.5F, 1.0F);
                            if (player.getAbilities().instabuild) {
                                throwntrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                            }

                            pLevel.addFreshEntity(throwntrident);
                            pLevel.playSound(null, throwntrident, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                            if (!player.getAbilities().instabuild) {
                                player.getInventory().removeItem(pStack);
                            }
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    if (j > 0) {
                        float f7 = player.getYRot();
                        float f = player.getXRot();
                        float f1 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * (float) Math.PI / 180F);
                        float f2 = -Mth.sin(f * ((float)Math.PI / 180F));
                        float f3 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f * (float) Math.PI / 180F);
                        float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
                        float f5 = 3.0F * ((1.0F + j) / 4.0F);
                        f1 *= f5 / f4;
                        f2 *= f5 / f4;
                        f3 *= f5 / f4;
                        player.push(f1, f2, f3);
                        player.startAutoSpinAttack(20);
                        if (player.onGround()) {
                            float f6 = 1.1999999F;
                            player.move(MoverType.SELF, new Vec3(0.0D, f6, 0.0D));
                        }

                        SoundEvent soundevent;
                        if (j >= 3) {
                            soundevent = SoundEvents.TRIDENT_RIPTIDE_3;
                        } else if (j == 2) {
                            soundevent = SoundEvents.TRIDENT_RIPTIDE_2;
                        } else {
                            soundevent = SoundEvents.TRIDENT_RIPTIDE_1;
                        }

                        pLevel.playSound(null, player, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                    }

                }
            }
        }
    }


    public ConfigurableTridentTier getTridentTier() {
        return configurableTridentTier;
    }

    @Override
    public int getMaxDamage() {
        return getTridentTier().tridentConfig().uses();
    }

    @Override
    public int getEnchantmentValue() {
        return getTridentTier().tridentConfig().enchantability();
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return getTridentTier().repairIngredient().get().test(pRepair) || super.isValidRepairItem(pToRepair, pRepair);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot $$0) {
        if (defaultModifiers1 == null) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> $$1 = ImmutableMultimap.builder();
            $$1.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", BASE_DAMAGE + getTridentTier().tridentConfig().damage(), AttributeModifier.Operation.ADDITION));
            $$1.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.9, AttributeModifier.Operation.ADDITION));
            this.defaultModifiers1 = $$1.build();
        }
        return $$0 == EquipmentSlot.MAINHAND ? this.defaultModifiers1 :ImmutableMultimap.of();
    }

}
