package com.korlimann.epic_swords.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;

public class ClientProxy implements IProxy
{
    @Override
    public IThreadListener getContextListener()
    {
        return Minecraft.getMinecraft();
    }

    @Override
    public World getClientWorld()
    {
        return Minecraft.getMinecraft().world;
    }

    @Override
    public EntityPlayer getClientPlayer()
    {
        return Minecraft.getMinecraft().player;
    }

}
