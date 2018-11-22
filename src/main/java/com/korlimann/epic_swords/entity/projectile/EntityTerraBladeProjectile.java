package com.korlimann.epic_swords.entity.projectile;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityTerraBladeProjectile extends EntityThrowable {

	private int ticksInAir;
	private int ticksAlive;
	private double damage;
	private int knockbackStrength;
	//private double motionX = 1;
	//private double motionY = 1;
	//private double motionZ = 1;
	private int blocksTravelled = 0;
	RayTraceResult raytraceresult;

	public EntityTerraBladeProjectile(World worldIn) {
		super(worldIn);
		this.setDamage(5);
	}
	
	public EntityTerraBladeProjectile(World worldIn, EntityLivingBase thrower) {
		super(worldIn, thrower);
		this.thrower = thrower;
		raytraceresult = ProjectileHelper.forwardsRaycast(this, true, this.ticksInAir >= 25, this.thrower);
		this.setDamage(5);
	}

	public EntityTerraBladeProjectile(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
		this.setDamage(5);
	}
	
	public void onUpdate()
    {
        if (this.world.isRemote || (this.thrower == null || !this.thrower.isDead) && this.world.isBlockLoaded(new BlockPos(this)))
        {
            ++this.ticksInAir;

            if (raytraceresult != null && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult))
            {
                this.onImpact(raytraceresult);
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            ProjectileHelper.rotateTowardsMovement(this, 0.2F);
            float f = this.getMotionFactor();

            if (this.isInWater()) {
                for (int i = 0; i < 4; ++i) {
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25D, this.posY - this.motionY * 0.25D, this.posZ - this.motionZ * 0.25D, this.motionX, this.motionY, this.motionZ);
                }

                f = 0.8F;
            }

            //this.motionX *= (double)f;
            //this.motionY *= (double)f;
            //this.motionZ *= (double)f;
            this.world.spawnParticle(this.getParticleType(), this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
            this.setPosition(this.posX, this.posY, this.posZ);
            this.blocksTravelled++;
            
            if(this.blocksTravelled > 100) {
            	this.setDead();
            }
        }
        else
        {
            this.setDead();
        }
    }
	
	@Override
	protected void onImpact(RayTraceResult result) {
		Entity entity = result.entityHit;
		
		float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
        int i = MathHelper.ceil((double)f * this.damage);

        if (entity != null) {
        	
        	DamageSource damagesource;
        	
        	if (this.thrower == null)
	        {
	            damagesource = DamageSource.causePlayerDamage((EntityPlayer) this.thrower);
	        }
	        else
	        {
	            damagesource = DamageSource.causePlayerDamage((EntityPlayer) this.thrower);
	        }
        	
        	if (entity.attackEntityFrom(damagesource, (float)i))
            {
                if (entity instanceof EntityLivingBase)
                {
                    EntityLivingBase entitylivingbase = (EntityLivingBase)entity;

                    if (this.knockbackStrength > 0)
                    {
                        float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

                        if (f1 > 0.0F)
                        {
                            entitylivingbase.addVelocity(this.motionX * (double)this.knockbackStrength * 0.6000000238418579D / (double)f1, 0.1D, this.motionZ * (double)this.knockbackStrength * 0.6000000238418579D / (double)f1);
                        }
                    }

                    if (this.thrower instanceof EntityLivingBase)
                    {
                        EnchantmentHelper.applyThornEnchantments(entitylivingbase, this.thrower);
                        EnchantmentHelper.applyArthropodEnchantments((EntityLivingBase)this.thrower, entitylivingbase);
                    }

                    if (this.thrower != null && entitylivingbase != this.thrower && entitylivingbase instanceof EntityPlayer && this.thrower instanceof EntityPlayerMP)
                    {
                        ((EntityPlayerMP)this.thrower).connection.sendPacket(new SPacketChangeGameState(6, 0.0F));
                    }
                }

                this.playSound(SoundEvents.BLOCK_FIRE_EXTINGUISH, 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
            }
        }   
	}
	
	

    protected EnumParticleTypes getParticleType()
    {
        return EnumParticleTypes.TOTEM;
    }

    /**
     * Return the motion factor for this projectile. The factor is multiplied by the original motion.
     */
    protected float getMotionFactor()
    {
        return 0.95F;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setTag("direction", this.newDoubleNBTList(new double[] {this.motionX, this.motionY, this.motionZ}));
        //compound.setTag("power", this.newDoubleNBTList(new double[] {this.accelerationX, this.accelerationY, this.accelerationZ}));
        compound.setInteger("life", this.ticksAlive);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        if (compound.hasKey("power", 9))
        {
            NBTTagList nbttaglist = compound.getTagList("power", 6);

            if (nbttaglist.tagCount() == 3)
            {
                //this.accelerationX = nbttaglist.getDoubleAt(0);
                //this.accelerationY = nbttaglist.getDoubleAt(1);
                //this.accelerationZ = nbttaglist.getDoubleAt(2);
            }
        }

        this.ticksAlive = compound.getInteger("life");

        if (compound.hasKey("direction", 9) && compound.getTagList("direction", 6).tagCount() == 3)
        {
            NBTTagList nbttaglist1 = compound.getTagList("direction", 6);
            this.motionX = nbttaglist1.getDoubleAt(0);
            this.motionY = nbttaglist1.getDoubleAt(1);
            this.motionZ = nbttaglist1.getDoubleAt(2);
        }
        else
        {
            this.setDead();
        }
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return true;
    }

    public float getCollisionBorderSize()
    {
        return 1.0F;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else
        {
            this.markVelocityChanged();

            if (source.getTrueSource() != null)
            {
                Vec3d vec3d = source.getTrueSource().getLookVec();

                if (vec3d != null)
                {
                    this.motionX = vec3d.x;
                    this.motionY = vec3d.y;
                    this.motionZ = vec3d.z;
                    //this.accelerationX = this.motionX * 0.1D;
                    //this.accelerationY = this.motionY * 0.1D;
                    //this.accelerationZ = this.motionZ * 0.1D;
                }

                if (source.getTrueSource() instanceof EntityLivingBase)
                {
                    this.thrower = (EntityLivingBase)source.getTrueSource();
                }

                return true;
            }
            else
            {
                return false;
            }
        }
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness()
    {
        return 1.0F;
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        return 15728880;
    }
    
    public void setDamage(double damageIn)
    {
        this.damage = damageIn;
    }

    public double getDamage()
    {
        return this.damage;
    }
    
    public void setKnockbackStrength(int knockbackStrengthIn)
    {
        this.knockbackStrength = knockbackStrengthIn;
    }
}
