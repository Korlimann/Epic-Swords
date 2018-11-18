package com.korlimann.epic_swords.client.renderer.entity;

import javax.annotation.Nonnull;

import com.korlimann.epic_swords.entity.projectile.EntityTerraBladeProjectile;
import com.korlimann.epic_swords.util.Reference;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;

public class RenderEntityTerraBladeProjectile<T extends EntityTerraBladeProjectile> extends Render<T>{

	public RenderEntityTerraBladeProjectile(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(T entity) {
		return new ResourceLocation(Reference.MOD_ID, "textures/entities/projectiles/terra_blade_projectile.png");
	}
	
	@Override
	public void doRender(@Nonnull T entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		GlStateManager.translate(x, y + 0.25, z);
		GlStateManager.enableRescaleNormal();
		GlStateManager.enableCull();
		
		/*this.bindTexture(entity.getTexture());
		
		Utils.drawSeamlessCuboid(minU, maxU, minV, maxV, 1, 0.25, 0.25, scale);

		GlStateManager.disableCull();
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();*/
	}

}
