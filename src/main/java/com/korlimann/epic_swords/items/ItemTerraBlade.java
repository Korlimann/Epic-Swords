package com.korlimann.epic_swords.items;

import com.korlimann.epic_swords.Main;
import com.korlimann.epic_swords.entity.projectile.EntityTerraBladeProjectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemTerraBlade extends ItemSword {
	
	public ItemTerraBlade(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.epic_swords);
	}		
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack) {
		if(!(entity instanceof EntityPlayer)) {
			return false;
		}
		EntityPlayer player = (EntityPlayer) entity;
		World world = player.getEntityWorld();
		if(!world.isRemote) {
			EntityTerraBladeProjectile projectile = new EntityTerraBladeProjectile(world, player);
            projectile.shoot(player, player.rotationPitch, player.rotationYaw, 0.5F, 1.5F, 1.0F);
			world.spawnEntity(projectile);
		}
		return false;
	}
}
