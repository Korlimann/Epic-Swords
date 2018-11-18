package com.korlimann.epic_swords.proxy;

import com.korlimann.epic_swords.util.ILifecycleListener;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;

public interface IProxy extends ILifecycleListener {
    IThreadListener getContextListener();

    World getClientWorld();

    EntityPlayer getClientPlayer();

}
