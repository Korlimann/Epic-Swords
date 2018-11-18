package com.korlimann.epic_swords.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityTerraBladeProjectile extends EntityFireball {

	public EntityTerraBladeProjectile(World worldIn) {
		super(worldIn);
	}
	
	public EntityTerraBladeProjectile(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(worldIn, x, y, z, accelX, accelY, accelZ);
	}
	
	public EntityTerraBladeProjectile(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
	}
	
	

}
