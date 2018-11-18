package com.korlimann.epic_swords.util.handlers;

import com.korlimann.epic_swords.client.renderer.entity.RenderEntityTerraBladeProjectile;
import com.korlimann.epic_swords.entity.projectile.EntityTerraBladeProjectile;
import com.korlimann.epic_swords.util.Reference;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = { Side.CLIENT })
public class RenderRegistry {

	@SubscribeEvent
	public static void registerRenderers(final ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityTerraBladeProjectile.class, renderManager -> new RenderEntityTerraBladeProjectile(renderManager, 1.0F));
	}
}
