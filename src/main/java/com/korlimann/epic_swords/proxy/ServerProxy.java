package com.korlimann.epic_swords.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ServerProxy implements IProxy{

	@Override
	public IThreadListener getContextListener() {
		return FMLCommonHandler.instance().getMinecraftServerInstance();
	}

	@Override
	public World getClientWorld() {
		return null;
	}

	@Override
	public EntityPlayer getClientPlayer() {
		return null;
	}
}
