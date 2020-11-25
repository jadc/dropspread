package red.jad.dropspread.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import red.jad.dropspread.DropSpread;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends Entity {
	public PlayerEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@ModifyArgs(
			method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ItemEntity;setVelocity(DDD)V", ordinal = 0)
	)
	private void multiplySpread(Args args){
		for(int i = 0; i < args.size(); i++) args.set(i, (double)args.get(i)*world.getGameRules().get(DropSpread.DROP_SPREAD).get());
	}
}
