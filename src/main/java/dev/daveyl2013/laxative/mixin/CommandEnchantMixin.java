package dev.daveyl2013.laxative.mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import net.minecraft.server.command.EnchantCommand;

@Mixin(value = EnchantCommand.class)
public abstract class CommandEnchantMixin {
	@ModifyExpressionValue(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;getMaxLevel()I"))
	private static int executeMixinLevel(int maxLevel) {
		return Integer.MAX_VALUE;
	}

	@ModifyExpressionValue(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;isAcceptableItem(Lnet/minecraft/item/ItemStack;)Z"))
	private static boolean executeMixinAcceptable(boolean isAcceptable) {
		return true;
	}

	@ModifyExpressionValue(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;isCompatible(Ljava/util/Collection;Lnet/minecraft/enchantment/Enchantment;)Z"))
	private static boolean executeMixinCompatable(boolean isCompatible) {
		return true;
	}
}
